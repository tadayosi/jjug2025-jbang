///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS com.squareup.okhttp3:okhttp-bom:4.12.0@pom
//DEPS com.squareup.okhttp3:okhttp
//DEPS com.squareup.okhttp3:logging-interceptor
//DEPS org.slf4j:slf4j-api:2.0.17
//DEPS ch.qos.logback:logback-classic:1.5.18

//FILES logback.xml

import static okhttp3.logging.HttpLoggingInterceptor.Level.BASIC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

public class wttr {
    static final Logger log = LoggerFactory.getLogger(wttr.class);

    public static void main(String... args) throws Exception {
        var logging = new HttpLoggingInterceptor(log::debug)
                .setLevel(BASIC);
        var client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        var request = new Request.Builder()
                .url("https://wttr.in/Everest?format=4")
                .build();
        try (var response = client.newCall(request).execute()) {
            System.out.println(response.body().string());
        }
    }
}
