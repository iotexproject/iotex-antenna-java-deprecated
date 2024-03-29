package io.iotex.antennaj.method;

import io.iotex.antennaj.rpc.Call;
import io.iotex.antennaj.rpc.CallOption;
import io.iotex.antennaj.rpc.api.Api.GetReceiptByActionRequest;
import io.iotex.antennaj.rpc.api.Api.GetReceiptByActionResponse;

public class ReceiptMethod
    extends ReadMethod<GetReceiptByActionRequest, GetReceiptByActionResponse> {
  private GetReceiptByActionRequest.Builder builder = GetReceiptByActionRequest.newBuilder();

  public ReceiptMethod(CallOption opt) {
    super(opt);
  }

  public ReceiptMethod set(String actionHash) {
    builder.setActionHash(actionHash);
    return this;
  }

  @Override
  protected GetReceiptByActionRequest composeRequest() {
    return builder.build();
  }

  @Override
  protected GetReceiptByActionResponse executeInternal(Call call, GetReceiptByActionRequest req) {
    return call.getReceiptByAction(req);
  }
}
