package io.iotex.antennaj.rpc;

public class CallOption {

  String endpoint;

  boolean secure;

  boolean async;

  public String getEndpoint() {
    return endpoint;
  }

  public boolean isSecure() {
    return secure;
  }

  public boolean isAsync() {
    return async;
  }
}
