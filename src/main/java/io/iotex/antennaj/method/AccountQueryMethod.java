package io.iotex.antennaj.method;

import io.iotex.antennaj.account.Address;
import io.iotex.antennaj.rpc.Api.GetAccountRequest;
import io.iotex.antennaj.rpc.Api.GetAccountResponse;
import io.iotex.antennaj.rpc.Call;
import io.iotex.antennaj.rpc.CallOption;

public class AccountQueryMethod extends ReadMethod<GetAccountRequest, GetAccountResponse> {
  private GetAccountRequest.Builder builder = GetAccountRequest.newBuilder();

  public AccountQueryMethod(CallOption opt) {
    super(opt);
  }

  public AccountQueryMethod setAddress(Address address) {
    builder.setAddress(address.toString());
    return this;
  }

  @Override
  protected GetAccountRequest composeRequest() {
    return builder.build();
  }

  @Override
  protected GetAccountResponse executeInternal(Call call, GetAccountRequest req) {
    return call.getAccount(req);
  }
}
