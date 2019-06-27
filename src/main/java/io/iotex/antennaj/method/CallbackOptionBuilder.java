package io.iotex.antennaj.method;

public class CallbackOptionBuilder {
  private CallbackOption opt = new CallbackOption();

  public static CallbackOptionBuilder forDefault() {
    CallbackOptionBuilder builder = new CallbackOptionBuilder();
    builder.opt.numPolls = 10;
    builder.opt.intervalMillis = 2000;
    return builder;
  }

  public CallbackOptionBuilder() {}

  public CallbackOptionBuilder setNumPolls(int numPolls) {
    opt.numPolls = numPolls;
    return this;
  }

  public CallbackOptionBuilder setIntervalMillis(long intervalMillis) {
    opt.intervalMillis = intervalMillis;
    return this;
  }

  public CallbackOption build() {
    return opt;
  }
}
