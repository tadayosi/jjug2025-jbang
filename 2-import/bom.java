///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS org.slf4j:slf4j-bom:2.0.17@pom
//DEPS org.slf4j:slf4j-api
//DEPS org.slf4j:slf4j-simple

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SLF4Jを使ってINFOログにメッセージを
 * 出力しているが、依存の指定にBOMを
 * 使っている。
 */
public class bom {
    static final Logger log = LoggerFactory.getLogger(bom.class);

    public static void main(String... args) {
        log.info("Hello World");
    }
}
