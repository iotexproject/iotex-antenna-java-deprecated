package io.iotex.antennaj.rpc;

import static org.junit.jupiter.api.Assertions.*;

import io.iotex.antennaj.rpc.api.Api.GetChainMetaRequest;
import io.iotex.antennaj.rpc.api.Api.GetChainMetaResponse;
import org.junit.jupiter.api.Test;

public class CallTest {
  @Test
  public void testGetChainMeta() {
    Call call = new Call(CallOptionBuilder.forTestNet().build());
    GetChainMetaResponse res = call.getChainMeta(GetChainMetaRequest.newBuilder().build());
    assertTrue(res.getChainMeta().getHeight() > 0);
  }
}
