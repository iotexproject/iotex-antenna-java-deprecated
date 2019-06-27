package io.iotex.antennaj.method;

import io.iotex.antennaj.rpc.Api.GetBlockMetasRequest;
import io.iotex.antennaj.rpc.Api.GetBlockMetasResponse;
import io.iotex.antennaj.rpc.Call;
import io.iotex.antennaj.rpc.CallOption;

public class BlockMetaQueryMethod extends ReadMethod<GetBlockMetasRequest, GetBlockMetasResponse> {
  protected GetBlockMetasRequest.Builder builder = GetBlockMetasRequest.newBuilder();

  public BlockMetaQueryMethod(CallOption opt) {
    super(opt);
  }

  @Override
  protected GetBlockMetasRequest composeRequest() {
    return builder.build();
  }

  public BlockMetaQueryByIndexMethod byIndex() {
    return new BlockMetaQueryByIndexMethod(builder, getOpt());
  }

  public BlockMetaQueryByHashMethod byHash() {
    return new BlockMetaQueryByHashMethod(builder, getOpt());
  }

  @Override
  protected GetBlockMetasResponse executeInternal(Call call, GetBlockMetasRequest req) {
    return call.getBlockMetas(req);
  }
}
