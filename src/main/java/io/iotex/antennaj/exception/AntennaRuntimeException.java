package io.iotex.antennaj.exception;

public class AntennaRuntimeException extends RuntimeException {

  public AntennaRuntimeException(String message) {
    super(message);
  }

  public AntennaRuntimeException(String message, Throwable cause) {
    super(message, cause);
  }

  public AntennaRuntimeException(Throwable cause) {
    super(cause);
  }

  protected AntennaRuntimeException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
