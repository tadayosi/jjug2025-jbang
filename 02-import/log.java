///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS org.slf4j:slf4j-api:2.0.17
//DEPS org.slf4j:slf4j-simple:2.0.17

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class log {
    static final Logger log = LoggerFactory.getLogger(log.class);

    public static void main(String... args) {
        log.info("Hello World");
    }
}
