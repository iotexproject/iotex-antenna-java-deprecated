package io.iotex.antennaj.method;

import io.iotex.antennaj.rpc.Call;
import io.iotex.antennaj.rpc.CallOption;
import io.iotex.antennaj.rpc.api.Api.GetChainMetaRequest;
import io.iotex.antennaj.rpc.api.Api.GetChainMetaResponse;

public class ChainMetaQueryMethod extends ReadMethod<GetChainMetaRequest, GetChainMetaResponse> {
  private GetChainMetaRequest.Builder builder = GetChainMetaRequest.newBuilder();

  public ChainMetaQueryMethod(CallOption opt) {
    super(opt);
  }

  @Override
  protected GetChainMetaRequest composeRequest() {
    return builder.build();
  }

  @Override
  protected GetChainMetaResponse executeInternal(Call call, GetChainMetaRequest req) {
    return call.getChainMeta(req);
  }
}
