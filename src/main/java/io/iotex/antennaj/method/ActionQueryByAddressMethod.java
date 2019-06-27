package io.iotex.antennaj.method;

import io.iotex.antennaj.account.Address;
import io.iotex.antennaj.rpc.Api.GetActionsByAddressRequest;
import io.iotex.antennaj.rpc.Api.GetActionsRequest;
import io.iotex.antennaj.rpc.CallOption;

public class ActionQueryByAddressMethod extends ActionQueryMethod {
  GetActionsByAddressRequest.Builder byAddressBulder = GetActionsByAddressRequest.newBuilder();

  ActionQueryByAddressMethod(GetActionsRequest.Builder builder, CallOption opt) {
    super(opt);
    this.builder = builder;
  }

  public ActionQueryByAddressMethod setAddress(Address address) {
    byAddressBulder.setAddress(address.toString());
    return this;
  }

  public ActionQueryByAddressMethod setStart(long start) {
    byAddressBulder.setStart(start);
    return this;
  }

  public ActionQueryByAddressMethod setCount(long count) {
    byAddressBulder.setCount(count);
    return this;
  }

  @Override
  protected GetActionsRequest composeRequest() {
    builder.setByAddr(byAddressBulder.build());
    return super.composeRequest();
  }
}
