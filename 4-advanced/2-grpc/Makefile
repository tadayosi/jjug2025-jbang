OS ?= osx
ARCH ?= aarch_64
GRPC_VERSION ?= 1.73.0

# protocとgrpc-javaを使って
# protoファイルからスタブ実装を生成する
protoc:
	# Protobufインタフェースの生成
	protoc --java_out=. ./hello.proto
	# gRPC Javaスタブの生成
	protoc \
		--plugin=protoc-gen-grpc-java=./protoc-gen-grpc-java-$(GRPC_VERSION)-$(OS)-$(ARCH).exe \
		--grpc-java_out=. \
		./hello.proto
