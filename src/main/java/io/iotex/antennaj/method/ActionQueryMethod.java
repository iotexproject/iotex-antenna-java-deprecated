package io.iotex.antennaj.method;

import io.iotex.antennaj.rpc.Call;
import io.iotex.antennaj.rpc.CallOption;
import io.iotex.antennaj.rpc.api.Api.GetActionsRequest;
import io.iotex.antennaj.rpc.api.Api.GetActionsResponse;

public class ActionQueryMethod extends ReadMethod<GetActionsRequest, GetActionsResponse> {
  protected GetActionsRequest.Builder builder = GetActionsRequest.newBuilder();

  public ActionQueryMethod(CallOption opt) {
    super(opt);
  }

  public ActionQueryByHashMethod byHash() {
    return new ActionQueryByHashMethod(builder, getOpt());
  }

  public ActionQueryByAddressMethod byAddress() {
    return new ActionQueryByAddressMethod(builder, getOpt());
  }

  public ActionQueryByBlockMethod byBlock() {
    return new ActionQueryByBlockMethod(builder, getOpt());
  }

  @Override
  protected GetActionsRequest composeRequest() {
    return builder.build();
  }

  @Override
  protected GetActionsResponse executeInternal(Call call, GetActionsRequest req) {
    return call.getActions(req);
  }
}
