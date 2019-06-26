package io.iotex.antennaj.rpc;

public class CallOptionBuilder {
  private static final String MAIN_NET_INSECURE_ENDPOINT = "api.iotex.one:80";
  private static final String TEST_NET_INSECURE_ENDPOINT = "api.testnet.iotex.one:80";

  private CallOption opt;

  public static CallOptionBuilder forEndpoint(String endpoint) {
    CallOptionBuilder builder = new CallOptionBuilder();
    builder.opt = new CallOption();
    builder.opt.endpoint = endpoint;
    return builder;
  }

  public static CallOptionBuilder forMainNet() {
    return forEndpoint(MAIN_NET_INSECURE_ENDPOINT);
  }

  public static CallOptionBuilder forTestNet() {
    return forEndpoint(TEST_NET_INSECURE_ENDPOINT);
  }

  private CallOptionBuilder() {}

  public CallOptionBuilder setSecure(boolean secure) {
    opt.secure = secure;
    return this;
  }

  public CallOptionBuilder setAsync(boolean async) {
    opt.async = async;
    return this;
  }
}
