///usr/bin/env jbang --javaagent=org.jolokia:jolokia-agent-jvm:2.2.9:javaagent=host=0.0.0.0,port=8778,discoveryEnabled=true "$0" "$@" ; exit $?

//DEPS io.quarkus.platform:quarkus-bom:3.22.3@pom
//DEPS io.quarkus:quarkus-rest

import static java.lang.System.err;
import static java.lang.System.out;

import java.lang.management.ManagementFactory;
import java.math.BigInteger;

import javax.management.ObjectName;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.event.Observes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

/**
 * 独自のJMX MBeanを登録するRESTサーバー。
 * JMXの挙動をテストするのに使える。
 *
 * このスクリプトをサーバーとして起動させるためだけに
 * Quarkus RESTを使っている。
 */
@Path("/")
public class jolokia {
    @GET
    public String hello() {
        return "Hello JJUG!";
    }

    static final String objectName = "org.example:name=Sample";
    final Sample sampleMBean = new Sample();

    /**
     * CDIによる起動時の処理。
     * MBeanをプラットフォームMBeanサーバーに登録する。
     */
    void onStart(@Observes StartupEvent event) {
        out.println("Register mbean: " + objectName);
        try {
            ManagementFactory.getPlatformMBeanServer()
                    .registerMBean(sampleMBean, new ObjectName(objectName));
        } catch (Exception e) {
            err.println(e.getMessage());
        }
    }

    /**
     * CDIによる終了時の処理。
     * MBeanをプラットフォームMBeanサーバーから登録解除する。
     */
    void onStop(@Observes ShutdownEvent event) {
        out.println("Unregister mbean: " + objectName);
        try {
            ManagementFactory.getPlatformMBeanServer()
                    .unregisterMBean(new ObjectName(objectName));
        } catch (Exception e) {
            err.println(e.getMessage());
        }
    }

    /**
     * カスタムMBeanのインターフェース。
     */
    public interface SampleMBean {
        String getName();

        String getVersion();

        String hello(String message);

        long longValue(long value);

        BigInteger bigintValue(BigInteger value);
    }

    /**
     * カスタムMBeanの実装。
     */
    class Sample implements SampleMBean {
        public String getName() {
            return "Sample";
        }

        public String getVersion() {
            return "1.0.0";
        }

        public String hello(String message) {
            out.println("hello: " + message);
            return "Hello " + message + "!";
        }

        public long longValue(long value) {
            out.println("long: " + value);
            return Long.MAX_VALUE;
        }

        public BigInteger bigintValue(BigInteger value) {
            out.println("bigint: " + value);
            return BigInteger.valueOf(Long.MAX_VALUE).pow(2);
        }
    }
}
