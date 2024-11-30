package com.berkay.grpc_playground.common;

import com.berkay.grpc_playground.sec06.BankService;

public class Demo {

    public static void main(String[] args) {
        GrpcServer.create(new BankService())
                .start()
                .await();
    }
}
