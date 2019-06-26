package io.iotex.antennaj.util;

import java.math.BigInteger;

public final class UnitConverter {
  public static BigInteger toRau(String number, Unit unit) {
    return toRau(new BigInteger(number), unit);
  }

  public static BigInteger toRau(BigInteger number, Unit unit) {
    return number.multiply(unit.getFactor());
  }
}
