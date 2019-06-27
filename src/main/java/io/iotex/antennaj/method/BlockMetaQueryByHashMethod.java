package io.iotex.antennaj.method;

import io.iotex.antennaj.rpc.Api.GetBlockMetaByHashRequest;
import io.iotex.antennaj.rpc.Api.GetBlockMetasRequest;
import io.iotex.antennaj.rpc.CallOption;

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
