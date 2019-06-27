package io.iotex.antennaj.example;

import io.iotex.antennaj.account.Account;
import io.iotex.antennaj.account.Address;
import io.iotex.antennaj.method.CallbackOptionBuilder;
import io.iotex.antennaj.method.PreparedWriteMethod;
import io.iotex.antennaj.method.ReceiptHandler;
import io.iotex.antennaj.method.TransferMethod;
import io.iotex.antennaj.rpc.Api.ReceiptInfo;
import io.iotex.antennaj.rpc.CallOptionBuilder;
import io.iotex.antennaj.util.Hex;
import io.iotex.antennaj.util.Unit;
import io.iotex.antennaj.util.UnitConverter;
import java.util.concurrent.CountDownLatch;

public class Transfer {
  public static void main(String[] argv) throws Exception {
    // Load the account
    String sk = "You Private Key Hex String";
    Account account = Account.fromKey(Hex.decode(sk));
    System.out.printf("Account's address is %s\n", account.getAddress().toString());

    // Build the transfer method
    TransferMethod method = new TransferMethod(account, CallOptionBuilder.forTestNet().build());
    PreparedWriteMethod preparedWriteMethod =
        method
            .setAmount(UnitConverter.toRau("1", Unit.IOTX))
            .setRecipient(Address.fromString("io15sdanq6wv490hcjf75yv4gdvueupxr5e0a262n"))
            .build();
    System.out.println("Transfer to send:");
    System.out.println(preparedWriteMethod.getAction());

    // Execute the transfer method and
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
