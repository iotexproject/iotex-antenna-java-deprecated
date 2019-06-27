package io.iotex.antennaj.method;

import io.iotex.antennaj.rpc.Api.GetActionByHashRequest;
import io.iotex.antennaj.rpc.Api.GetActionsRequest;
import io.iotex.antennaj.rpc.CallOption;

public class ActionQueryByHashMethod extends ActionQueryMethod {
  private GetActionByHashRequest.Builder byHashBuilder = GetActionByHashRequest.newBuilder();

  ActionQueryByHashMethod(GetActionsRequest.Builder builder, CallOption opt) {
    super(opt);
    this.builder = builder;
  }

  public ActionQueryByHashMethod setActionHash(String actHash) {
    byHashBuilder.setActionHash(actHash);
    return this;
  }

  @Override
  protected GetActionsRequest composeRequest() {
    builder.setByHash(byHashBuilder.build());
    return super.composeRequest();
  }
}
