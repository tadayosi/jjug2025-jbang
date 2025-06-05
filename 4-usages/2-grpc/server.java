///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS com.google.protobuf:protobuf-java:4.31.1
//DEPS com.google.protobuf:protobuf-java-util:4.31.1
//DEPS io.grpc:grpc-bom:1.73.0@pom
//DEPS io.grpc:grpc-netty-shaded
//DEPS io.grpc:grpc-protobuf
//DEPS io.grpc:grpc-stub
//DEPS org.apache.tomcat:annotations-api:6.0.53

//SOURCES hello/Hello.java
//SOURCES hello/HelloServiceGrpc.java

import static java.lang.System.out;

import hello.Hello.HelloRequest;
import hello.Hello.HelloResponse;
import hello.HelloServiceGrpc.HelloServiceImplBase;
import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.stub.StreamObserver;

/**
 * Helloサービスを実装したgRPCサーバー。
 */
public class server {
    // サーバーのポート番号
    static int port = 50051;

    /**
     * gRPCサーバーを立ち上げる。
     * JVM終了時にサーバーを停止するシャットダウンフック
     * も登録している。
     */
    public static void main(String... args) throws Exception {
        var server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
                .addService(new HelloServiceImpl())
                .build();
        server.start();
        out.println("Server started, listening on port " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            out.println("Shutting down server");
            server.shutdown();
            out.println("Server shut down");
        }));
        server.awaitTermination();
    }

    /**
     * Helloサービスの実装。
     * 受け取ったリクエストの内容を標準出力に出力し、
     * メッセージを加えてレスポンスを返す。
     */
    static class HelloServiceImpl extends HelloServiceImplBase {
        @Override
        public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
            out.println("Received: " + request.getName());
            var response = HelloResponse.newBuilder()
                    .setMessage("Hello " + request.getName())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

    }
}
