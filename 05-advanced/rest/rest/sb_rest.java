///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS org.springframework.boot:spring-boot-dependencies:3.4.6@pom
//DEPS org.springframework.boot:spring-boot-starter-web

package rest;

import static java.lang.System.out;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class sb_rest {

    public static void main(String... args) {
        SpringApplication.run(sb_rest.class, args);
        out.println("Hello World");
    }

    @GetMapping("/")
    public String hello() {
        out.println("Received: /");
        return "Hello JJUG!";
    }

    @GetMapping("/{name}")
    public String hello(@PathVariable("name") String name) {
        out.println("Received: " + name);
        return "Hello " + name + "!";
    }
}
