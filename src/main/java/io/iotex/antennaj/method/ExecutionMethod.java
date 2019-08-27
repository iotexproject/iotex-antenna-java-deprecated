package io.iotex.antennaj.method;

import com.google.protobuf.ByteString;
import io.iotex.antennaj.account.Account;
import io.iotex.antennaj.account.Address;
import io.iotex.antennaj.rpc.CallOption;
import io.iotex.antennaj.rpc.type.ActionOuterClass;
import io.iotex.antennaj.rpc.type.ActionOuterClass.ActionCore;
import io.iotex.antennaj.rpc.type.ActionOuterClass.Execution.Builder;

import java.math.BigInteger;

public class ExecutionMethod extends WriteMethod {
  private static final long BASE_GAS = 10000;
  private static final long GAS_PER_BYTE = 100;

  private Builder tsfBuilder = ActionOuterClass.Execution.newBuilder();

  public ExecutionMethod(Account caller, CallOption opt) {
    super(caller, opt);
  }

  public ExecutionMethod setAmount(BigInteger amount) {
    tsfBuilder.setAmount(amount.toString());
    return this;
  }

  public ExecutionMethod setContract(Address contract) {
    tsfBuilder.setContract(contract.toString());
    return this;
  }

  public ExecutionMethod setData(byte[] data) {
    tsfBuilder.setData(ByteString.copyFrom(data));
    return this;
  }

  @Override
  protected void overrideCoreBuilder(ActionCore.Builder coreBuilder) {
    if (coreBuilder.getGasLimit() == 0) {
      // Overflow will only cause execution failing to be accepted
      coreBuilder.setGasLimit(BASE_GAS + GAS_PER_BYTE * tsfBuilder.getData().size());
    }
    coreBuilder.setExecution(tsfBuilder.build());
  }
}
