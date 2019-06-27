package io.iotex.antennaj.example;

import io.iotex.antennaj.method.BlockMetaQueryMethod;
import io.iotex.antennaj.rpc.Api.GetBlockMetasResponse;
import io.iotex.antennaj.rpc.CallOptionBuilder;

public class BlockMetaQuery {
  public static void main(String[] argv) {
    // Query block by block number (or index)
    BlockMetaQueryMethod method = new BlockMetaQueryMethod(CallOptionBuilder.forTestNet().build());
    GetBlockMetasResponse res = method.byIndex().setStart(1).setCount(1).execute();
    System.out.println(res.getBlkMetas(0));

    // Query block by block hash
    method = new BlockMetaQueryMethod(CallOptionBuilder.forTestNet().build());
    res = method.byHash().setBlockHash(res.getBlkMetas(0).getHash()).execute();
    System.out.println(res.getBlkMetas(0));
  }
}
