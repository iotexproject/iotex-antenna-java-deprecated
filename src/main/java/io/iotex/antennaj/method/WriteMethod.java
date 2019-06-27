package io.iotex.antennaj.method;

import com.google.protobuf.ByteString;
import io.iotex.antennaj.account.Account;
import io.iotex.antennaj.rpc.Api.GetAccountResponse;
import io.iotex.antennaj.rpc.CallOption;
import io.iotex.antennaj.type.ActionOuterClass.Action;
import io.iotex.antennaj.type.ActionOuterClass.ActionCore;
import java.math.BigInteger;

abstract class WriteMethod {

  private ActionCore.Builder coreBuilder = ActionCore.newBuilder();
  private Account caller;
  private CallOption opt;

  protected WriteMethod(Account caller, CallOption opt) {
    this.caller = caller;
    this.opt = opt;
  }

  public WriteMethod setGasPrice(BigInteger gasPrice) {
    coreBuilder.setGasPrice(gasPrice.toString());
    return this;
  }

  public WriteMethod setGasLimit(long gasLimit) {
    coreBuilder.setGasLimit(gasLimit);
    return this;
  }

  public WriteMethod setNonce(long nonce) {
    coreBuilder.setNonce(nonce);
    return this;
  }

  protected abstract void overrideCoreBuilder(ActionCore.Builder coreBuilder);

  public PreparedWriteMethod build() {
    if (coreBuilder.getNonce() == 0) {
      AccountQueryMethod method = new AccountQueryMethod(opt);
      GetAccountResponse res = method.setAddress(caller.getAddress()).execute();
      coreBuilder.setNonce(res.getAccountMeta().getPendingNonce());
    }
    if (coreBuilder.getGasPrice() == null || coreBuilder.getGasPrice() == "") {
      coreBuilder.setGasPrice(DefaultSetting.GAS_PRICE.toString());
    }
    coreBuilder.setVersion(DefaultSetting.VERSION);
    overrideCoreBuilder(coreBuilder);
    ActionCore actionCore = coreBuilder.build();
    byte[] sig = caller.sign(actionCore.toByteArray());
    Action action =
        Action.newBuilder()
            .setCore(actionCore)
            .setSenderPubKey(ByteString.copyFrom(caller.getPublicKey()))
            .setSignature(ByteString.copyFrom(sig))
            .build();
    return new PreparedWriteMethod(action, opt);
  }
}
