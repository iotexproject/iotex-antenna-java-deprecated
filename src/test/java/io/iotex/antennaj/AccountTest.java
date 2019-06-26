package io.iotex.antennaj;

import io.iotex.antennaj.account.Account;
import org.junit.jupiter.api.Test;

public class AccountTest {

  @Test
  public void testAccountCreate() throws Exception {
    Account account = Account.create();
    System.out.println(account.getAddress());
  }
}
