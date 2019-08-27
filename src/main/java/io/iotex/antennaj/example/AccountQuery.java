package io.iotex.antennaj.example;

import io.iotex.antennaj.account.Address;
import io.iotex.antennaj.method.AccountQueryMethod;
import io.iotex.antennaj.rpc.CallOptionBuilder;
import io.iotex.antennaj.rpc.api.Api.GetAccountResponse;

public class AccountQuery {
  public static void main(String[] argv) {
    AccountQueryMethod method = new AccountQueryMethod(CallOptionBuilder.forTestNet().build());
    GetAccountResponse res =
        method
            .setAddress(Address.fromString("io15sdanq6wv490hcjf75yv4gdvueupxr5e0a262n"))
            .execute();
    System.out.println(res);
  }
}
