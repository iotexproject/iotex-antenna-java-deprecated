package io.iotex.antennaj.example;

import io.iotex.antennaj.account.Account;
import io.iotex.antennaj.account.Address;
import io.iotex.antennaj.method.*;
import io.iotex.antennaj.rpc.CallOptionBuilder;
import io.iotex.antennaj.rpc.api.Api.ReceiptInfo;
import io.iotex.antennaj.util.Hex;
import io.iotex.antennaj.util.Unit;
import io.iotex.antennaj.util.UnitConverter;

import java.math.BigInteger;
import java.util.concurrent.CountDownLatch;

public class Execution {
  public static void main(String[] argv) throws Exception {
    // Load the account
    String sk = "0ba6a6ce7712f69fbc560793f567f2c7c32b75ce83d37f565f184632c88d7fbb";
    Account account = Account.fromKey(Hex.decode(sk));
    System.out.printf("Account's address is %s\n", account.getAddress().toString());

    // Build the execution method
    ExecutionMethod method = new ExecutionMethod(account, CallOptionBuilder.forTestNet().build());
    PreparedWriteMethod preparedWriteMethod =
        method
            .setContract(Address.fromString("io186s45j3rgvhxh25ec6xk9wap0drtthk3jq4du7"))
            .setData(Hex.decode("60fe47b10000000000000000000000000000000000000000000000000000000000000065"))
            .build();
    System.out.println("execution to send:");

    // Execute method
    CountDownLatch latch = new CountDownLatch(1);
    preparedWriteMethod.execute(
        new ReceiptHandler() {
          @Override
          public void onReceipt(ReceiptInfo receipt) {
            System.out.println(receipt);
            latch.countDown();
          }

          @Override
          public void onException(Exception e) {
            e.printStackTrace();
            latch.countDown();
          }
        },
        CallbackOptionBuilder.forDefault().build());

    latch.await();
  }
}
