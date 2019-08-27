package io.iotex.antennaj.method;

import io.iotex.antennaj.rpc.api.Api.ReceiptInfo;

public interface ReceiptHandler {
  void onReceipt(ReceiptInfo receipt);

  void onException(Exception e);
}
