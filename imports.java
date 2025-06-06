///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS org.slf4j:slf4j-bom:2.0.17@pom
//DEPS org.slf4j:slf4j-api
//DEPS org.slf4j:slf4j-simple

//DEPS com.squareup.okhttp3:okhttp-bom:4.12.0@pom
//DEPS com.squareup.okhttp3:okhttp
//DEPS com.squareup.okhttp3:logging-interceptor
//DEPS ch.qos.logback:logback-classic:1.5.18

//DEPS io.quarkus.platform:quarkus-bom:3.22.3@pom
//DEPS io.quarkus:quarkus-rest

//DEPS org.springframework.boot:spring-boot-dependencies:3.4.6@pom
//DEPS org.springframework.boot:spring-boot-starter-web

//DEPS com.google.protobuf:protobuf-java:4.31.1
//DEPS com.google.protobuf:protobuf-java-util:4.31.1
//DEPS io.grpc:grpc-bom:1.73.0@pom
//DEPS io.grpc:grpc-netty-shaded
//DEPS io.grpc:grpc-protobuf
//DEPS io.grpc:grpc-stub
//DEPS org.apache.tomcat:annotations-api:6.0.53

//DEPS ai.djl:bom:0.33.0@pom
//DEPS ai.djl:api
//DEPS ai.djl:model-zoo
//DEPS ai.djl.pytorch:pytorch-engine

//DEPS dev.langchain4j:langchain4j-bom:1.0.0@pom
//DEPS dev.langchain4j:langchain4j
//DEPS dev.langchain4j:langchain4j-ollama

//DEPS info.picocli:picocli:4.6.3

import static java.lang.System.*;

/**
 * デモ用のインポートセット。
 * いちいちインポートをシンクロする必要がないように。
 */
public class imports {

    public static void main(String... args) {
        out.println("Hello World");
    }
}
