///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS com.google.protobuf:protobuf-java:4.31.1
//DEPS com.google.protobuf:protobuf-java-util:4.31.1
//DEPS io.grpc:grpc-bom:1.73.0@pom
//DEPS io.grpc:grpc-protobuf
//DEPS io.grpc:grpc-stub
//DEPS io.grpc:grpc-netty-shaded
//DEPS org.apache.tomcat:annotations-api:6.0.53

//SOURCES hello/Hello.java
//SOURCES hello/HelloServiceGrpc.java

import static java.lang.System.out;

import hello.Hello.HelloRequest;
import hello.HelloServiceGrpc;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;

public class client {
    static String target = "localhost:50051";

    public static void main(String... args) {
        var name = args.length > 0 ? args[0] : "JJUG";

        var channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        var stub = HelloServiceGrpc.newBlockingStub(channel);
        var request = HelloRequest.newBuilder()
                .setName(name)
                .build();
        var response = stub.hello(request);
        out.println("Response: " + response.getMessage());
    }
}
