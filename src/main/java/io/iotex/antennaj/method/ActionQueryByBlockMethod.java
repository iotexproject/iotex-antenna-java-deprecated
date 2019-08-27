package io.iotex.antennaj.method;

import io.iotex.antennaj.rpc.CallOption;
import io.iotex.antennaj.rpc.api.Api.GetActionsByBlockRequest;
import io.iotex.antennaj.rpc.api.Api.GetActionsRequest;

public class ActionQueryByBlockMethod extends ActionQueryMethod {
  GetActionsByBlockRequest.Builder byBlockBuilder = GetActionsByBlockRequest.newBuilder();

  public ActionQueryByBlockMethod(GetActionsRequest.Builder builder, CallOption opt) {
    super(opt);
    this.builder = builder;
  }

  public ActionQueryByBlockMethod setBlockHash(String blockHash) {
    byBlockBuilder.setBlkHash(blockHash);
    return this;
  }

  public ActionQueryByBlockMethod setStart(long start) {
    byBlockBuilder.setStart(start);
    return this;
  }

  public ActionQueryByBlockMethod setCount(long count) {
    byBlockBuilder.setCount(count);
    return this;
  }

  @Override
  protected GetActionsRequest composeRequest() {
    builder.setByBlk(byBlockBuilder.build());
    return super.composeRequest();
  }
}
