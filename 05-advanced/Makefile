OS ?= osx
ARCH ?= aarch_64
GRPC_VERSION ?= 1.73.0

grpc-protoc-hello:
	protoc --java_out=./grpc ./grpc/hello.proto
	protoc \
		--plugin=protoc-gen-grpc-java=./protoc-gen-grpc-java-$(GRPC_VERSION)-$(OS)-$(ARCH).exe \
		--grpc-java_out=./grpc \
		./grpc/hello.proto
