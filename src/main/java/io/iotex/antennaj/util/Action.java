package io.iotex.antennaj.util;

import io.iotex.antennaj.account.Address;
import io.iotex.antennaj.type.ActionOuterClass;

public class Action {

  public static Address getSenderAddress(ActionOuterClass.Action act) {
    return Address.fromPublicKey(act.getSenderPubKey().toByteArray());
  }
}
