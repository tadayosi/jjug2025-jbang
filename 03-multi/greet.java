///usr/bin/env jbang "$0" "$@" ; exit $?

//SOURCES service/GreetingService.java

import static java.lang.System.out;

import service.GreetingService;

public class greet {
    static GreetingService service = new GreetingService();

    public static void main(String... args) {
        var name = args.length > 0 ? args[0] : "JJUG";
        var message = service.hello(name);
        out.println(message);
    }
}
