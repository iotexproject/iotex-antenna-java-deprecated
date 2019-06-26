package io.iotex.antennaj.method;

import io.iotex.antennaj.rpc.Call;
import io.iotex.antennaj.rpc.CallOption;

abstract class ReadMethod<Request, Response> {

  private CallOption opt;

  protected ReadMethod(CallOption opt) {
    this.opt = opt;
  }

  public Response execute() {
    try (Call call = new Call(opt)) {
      return executeInternal(call, composeRequest());
    }
  }

  protected abstract Request composeRequest();

  protected abstract Response executeInternal(Call call, Request req);
}
