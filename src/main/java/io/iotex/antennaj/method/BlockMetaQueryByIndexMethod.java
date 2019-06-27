package io.iotex.antennaj.method;

import io.iotex.antennaj.rpc.Api.GetBlockMetasByIndexRequest;
import io.iotex.antennaj.rpc.Api.GetBlockMetasRequest;
import io.iotex.antennaj.rpc.CallOption;

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
