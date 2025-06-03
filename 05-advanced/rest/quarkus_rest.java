///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS io.quarkus.platform:quarkus-bom:3.22.3@pom
//DEPS io.quarkus:quarkus-rest

import static java.lang.System.out;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/")
public class quarkus_rest {
    @GET
    public String hello() {
        out.println("Received: /");
        return "Hello JJUG!";
    }

    @Path("{name}")
    @GET
    public String hello(String name) {
        out.println("Received: " + name);
        return "Hello " + name + "!";
    }
}
