package com.berkay.grpc_playground.sec06;

import com.berkay.grpc_playground.sec06.repository.AccountRepository;
import com.berkay.models.sec06.AccountBalance;
import com.berkay.models.sec06.BalanceCheckRequest;
import com.berkay.models.sec06.BankServiceGrpc;
import io.grpc.stub.StreamObserver;

public class BankService extends BankServiceGrpc.BankServiceImplBase {

    @Override
    public void getAccountBalance(BalanceCheckRequest request, StreamObserver<AccountBalance> responseObserver) {

        var accountNumber = request.getAccountNumber();
        var balance = AccountRepository.getBalance(accountNumber);
        var accountBalance = AccountBalance.newBuilder()
                .setAccountNumber(accountNumber)
                .setBalance(balance)
                .build();

        responseObserver.onNext(accountBalance);
        responseObserver.onCompleted();

    }
}
