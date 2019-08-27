package io.iotex.antennaj.method;

import io.iotex.antennaj.rpc.CallOption;
import io.iotex.antennaj.rpc.api.Api.GetBlockMetaByHashRequest;
import io.iotex.antennaj.rpc.api.Api.GetBlockMetasRequest;

public class BlockMetaQueryByHashMethod extends BlockMetaQueryMethod {
  GetBlockMetaByHashRequest.Builder byHashBuilder = GetBlockMetaByHashRequest.newBuilder();

  BlockMetaQueryByHashMethod(GetBlockMetasRequest.Builder builder, CallOption opt) {
    super(opt);
    this.builder = builder;
  }

  @Override
  protected GetBlockMetasRequest composeRequest() {
    builder.setByHash(byHashBuilder.build());
    return super.composeRequest();
  }

  public BlockMetaQueryByHashMethod setBlockHash(String blkHash) {
    byHashBuilder.setBlkHash(blkHash);
    return this;
  }
}
