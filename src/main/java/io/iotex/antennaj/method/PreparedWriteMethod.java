package io.iotex.antennaj.method;

import io.iotex.antennaj.rpc.Api.GetReceiptByActionResponse;
import io.iotex.antennaj.rpc.Api.SendActionRequest;
import io.iotex.antennaj.rpc.Api.SendActionResponse;
import io.iotex.antennaj.rpc.Call;
import io.iotex.antennaj.rpc.CallOption;
import io.iotex.antennaj.type.ActionOuterClass.Action;

public class PreparedWriteMethod {
  private Action action;
  private CallOption opt;

  PreparedWriteMethod(Action action, CallOption opt) {
    this.action = action;
    this.opt = opt;
  }

  public String execute() {
    try (Call call = new Call(opt)) {
      SendActionResponse response =
          call.sendAction(SendActionRequest.newBuilder().setAction(action).build());
      return response.getActionHash();
    }
  }

  public void execute(ReceiptHandler handler, CallbackOption callbackOpt) {
    try (Call call = new Call(opt)) {
      SendActionResponse response =
          call.sendAction(SendActionRequest.newBuilder().setAction(action).build());
      final String actionHash = response.getActionHash();
      Thread callbackThread =
          new Thread(
              () -> {
                Exception lastException = null;
                for (int i = 0; i < callbackOpt.getNumPolls(); i++) {
                  try {
                    GetReceiptByActionResponse res =
                        new ReceiptMethod(opt).set(actionHash).execute();
                    handler.onReceipt(res.getReceiptInfo());
                    return;
                  } catch (RuntimeException e) {
                    lastException = e;
                    try {
                      Thread.sleep(callbackOpt.getIntervalMillis());
                    } catch (InterruptedException ie) {
                      lastException = ie;
                      break;
                    }
                  }
                }
                handler.onException(lastException);
              });
      callbackThread.setDaemon(true);
      callbackThread.start();
    }
  }

  public Action getAction() {
    return action;
  }
}
