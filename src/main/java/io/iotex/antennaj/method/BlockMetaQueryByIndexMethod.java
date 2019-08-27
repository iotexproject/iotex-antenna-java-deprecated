package io.iotex.antennaj.method;

import io.iotex.antennaj.rpc.CallOption;
import io.iotex.antennaj.rpc.api.Api.GetBlockMetasByIndexRequest;
import io.iotex.antennaj.rpc.api.Api.GetBlockMetasRequest;

public class BlockMetaQueryByIndexMethod extends BlockMetaQueryMethod {
  GetBlockMetasByIndexRequest.Builder byIndexBuilder = GetBlockMetasByIndexRequest.newBuilder();

  BlockMetaQueryByIndexMethod(GetBlockMetasRequest.Builder builder, CallOption opt) {
    super(opt);
    this.builder = builder;
  }

  @Override
  protected GetBlockMetasRequest composeRequest() {
    builder.setByIndex(byIndexBuilder.build());
    return super.composeRequest();
  }

  public BlockMetaQueryByIndexMethod setStart(long start) {
    byIndexBuilder.setStart(start);
    return this;
  }

  public BlockMetaQueryByIndexMethod setCount(long count) {
    byIndexBuilder.setCount(count);
    return this;
  }
}
