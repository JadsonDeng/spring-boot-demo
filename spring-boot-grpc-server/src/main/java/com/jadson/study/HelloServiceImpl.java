package com.jadson.study;

import com.jadson.study.proto.HelloServiceGrpc;
import com.jadson.study.proto.Request;
import com.jadson.study.proto.Response;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void sayHello(Request request, StreamObserver<Response> responseObserver) {
        Response response = Response.newBuilder()
                .setMessage("hello " + request.getUsername())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
