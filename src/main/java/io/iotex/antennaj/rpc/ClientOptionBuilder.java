package io.iotex.antennaj.rpc;

public class ClientOptionBuilder {
  private static final String MAIN_NET_INSECURE_ENDPOINT = "api.iotex.one:80";
  private static final String TEST_NET_INSECURE_ENDPOINT = "api.testnet.iotex.one:80";

  private ClientOption opt;

  public static ClientOptionBuilder forEndpoint(String endpoint) {
    ClientOptionBuilder builder = new ClientOptionBuilder();
    builder.opt = new ClientOption();
    builder.opt.endpoint = endpoint;
    return builder;
  }

  public static ClientOptionBuilder forMainNet() {
    return forEndpoint(MAIN_NET_INSECURE_ENDPOINT);
  }

  public static ClientOptionBuilder forTestNet() {
    return forEndpoint(TEST_NET_INSECURE_ENDPOINT);
  }

  private ClientOptionBuilder() {

  }

  public ClientOptionBuilder setSecure(boolean secure) {
    opt.secure = secure;
    return this;
  }

  public ClientOptionBuilder setAsync(boolean async) {
    opt.async = async;
    return this;
  }
}
