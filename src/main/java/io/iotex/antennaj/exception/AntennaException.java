package io.iotex.antennaj.exception;

public class AntennaException extends Exception {
  public AntennaException(String message) {
    super(message);
  }

  public AntennaException(String message, Throwable cause) {
    super(message, cause);
  }

  public AntennaException(Throwable cause) {
    super(cause);
  }

  protected AntennaException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
