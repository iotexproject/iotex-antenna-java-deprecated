package io.iotex.antennaj.example;

import io.iotex.antennaj.method.ChainMetaQueryMethod;
import io.iotex.antennaj.rpc.CallOptionBuilder;
import io.iotex.antennaj.rpc.api.Api.GetChainMetaResponse;

public class ChainMetaQuery {
  public static void main(String[] argv) {
    ChainMetaQueryMethod method = new ChainMetaQueryMethod(CallOptionBuilder.forTestNet().build());
    GetChainMetaResponse res = method.execute();
    System.out.println(res.getChainMeta());
  }
}
