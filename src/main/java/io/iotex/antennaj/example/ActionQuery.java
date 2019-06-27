package io.iotex.antennaj.example;

import io.iotex.antennaj.account.Address;
import io.iotex.antennaj.method.ActionQueryMethod;
import io.iotex.antennaj.method.BlockMetaQueryMethod;
import io.iotex.antennaj.rpc.Api.ActionInfo;
import io.iotex.antennaj.rpc.Api.GetActionsResponse;
import io.iotex.antennaj.rpc.Api.GetBlockMetasResponse;
import io.iotex.antennaj.rpc.CallOption;
import io.iotex.antennaj.rpc.CallOptionBuilder;
import io.iotex.antennaj.util.Action;

public class ActionQuery {
  public static void main(String[] argv) {
    CallOption opt = CallOptionBuilder.forTestNet().build();
    // Get the transfer action sent from one address
    System.out.println("Get the transfer sent by one address");
    ActionQueryMethod method = new ActionQueryMethod(opt);
    GetActionsResponse res =
        method
            .byAddress()
            .setAddress(Address.fromString("io15sdanq6wv490hcjf75yv4gdvueupxr5e0a262n"))
            .setStart(0)
            .setCount(5)
            .execute();
    for (ActionInfo act : res.getActionInfoList()) {
      // Filter the actions by type
      if (act.getAction().getCore().getTransfer() == null) {
        continue;
      }
      // Filter the actions by the sender
      if (Action.getSenderAddress(act.getAction())
          .equals(Address.fromString("io15sdanq6wv490hcjf75yv4gdvueupxr5e0a262n"))) {
        System.out.println(act);
      }
    }

    // Get the action by hash
    System.out.println("Get the action by hash");
    method = new ActionQueryMethod(opt);
    res = method.byHash().setActionHash(res.getActionInfo(0).getActHash()).execute();
    System.out.println(res.getActionInfo(0));

    // Get the actions in one block
    System.out.println("Get the actions in one block");
    BlockMetaQueryMethod blkMethod = new BlockMetaQueryMethod(opt);
    GetBlockMetasResponse blkRes = blkMethod.byIndex().setStart(1).setCount(1).execute();
    method = new ActionQueryMethod(CallOptionBuilder.forTestNet().build());
    res =
        method
            .byBlock()
            .setBlockHash(blkRes.getBlkMetas(0).getHash())
            .setStart(0)
            .setCount(blkRes.getBlkMetas(0).getNumActions())
            .execute();
    for (ActionInfo act : res.getActionInfoList()) {
      System.out.println(act);
    }
  }
}
