package com.berkay.grpc_playground.sec06;

import com.berkay.models.sec06.AccountBalance;
import com.berkay.models.sec06.BalanceCheckRequest;
import com.berkay.models.sec06.BankServiceGrpc;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrpcClient {

    private static final Logger logger = LoggerFactory.getLogger(GrpcClient.class);

    public static void main(String[] args) throws InterruptedException {

        var channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()
                .build();

        // BLOCKING STUB
        /*var stub = BankServiceGrpc.newBlockingStub(channel);

        var balance = stub.getAccountBalance(BalanceCheckRequest.newBuilder().setAccountNumber(2).build());
        logger.info("{}", balance);
        */
        // -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*

        //ASYNC STUB

        var stub = BankServiceGrpc.newStub(channel);

        stub.getAccountBalance(BalanceCheckRequest.newBuilder().setAccountNumber(2).build(), new StreamObserver<AccountBalance>() {
            @Override
            public void onNext(AccountBalance accountBalance) {
                logger.info("{}", accountBalance);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                logger.info("Completed");
            }
        });

        logger.info("done");
        Thread.sleep(2000);

    }

}
