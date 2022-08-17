package com.jadson.study;

import com.jadson.study.proto.HelloServiceGrpc;
import com.jadson.study.proto.Request;
import com.jadson.study.proto.Response;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class SpringBootGrpcClientApplicationTests {


    @Test
    void test() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();
        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

        Request request = Request.newBuilder().setAge(10).setUsername("dengjunzhen").build();
        Response response = stub.sayHello(request);
        System.out.println(response);
    }

}
