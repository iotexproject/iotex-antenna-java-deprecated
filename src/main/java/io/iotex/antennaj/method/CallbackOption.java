package io.iotex.antennaj.method;

public class CallbackOption {
  long intervalMillis;
  int numPolls;

  public long getIntervalMillis() {
    return intervalMillis;
  }

  public int getNumPolls() {
    return numPolls;
  }
}
