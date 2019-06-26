package io.iotex.antennaj.method;

import com.google.protobuf.ByteString;
import io.iotex.antennaj.account.Account;
import io.iotex.antennaj.rpc.CallOption;
import io.iotex.antennaj.type.ActionOuterClass;
import io.iotex.antennaj.type.ActionOuterClass.ActionCore;
import io.iotex.antennaj.type.ActionOuterClass.Transfer.Builder;
import java.math.BigInteger;

public class TransferMethod extends WriteMethod {
  private static final long BASE_GAS = 10000;
  private static final long GAS_PER_BYTE = 100;

  private Builder tsfBuilder = ActionOuterClass.Transfer.newBuilder();

  public TransferMethod(Account caller, CallOption opt) {
    super(caller, opt);
  }

  public TransferMethod setAmount(BigInteger amount) {
    tsfBuilder.setAmount(amount.toString());
    return this;
  }

  public TransferMethod setRecipient(String recipient) {
    tsfBuilder.setRecipient(recipient);
    return this;
  }

  public TransferMethod setPayload(byte[] payload) {
    tsfBuilder.setPayload(ByteString.copyFrom(payload));
    return this;
  }

  @Override
  protected void overrideCoreBuilder(ActionCore.Builder coreBuilder) {
    if (coreBuilder.getGasLimit() == 0) {
      // Overflow will only cause transfer failing to be accepted
      coreBuilder.setGasLimit(BASE_GAS + GAS_PER_BYTE * tsfBuilder.getPayload().size());
    }
    coreBuilder.setTransfer(tsfBuilder.build());
  }
}
