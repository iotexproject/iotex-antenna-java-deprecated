package io.iotex.antennaj.method;

import io.iotex.antennaj.util.Unit;
import io.iotex.antennaj.util.UnitConverter;
import java.math.BigInteger;

public final class DefaultSetting {
  public static final BigInteger GAS_PRICE = UnitConverter.toRau("1", Unit.QEV);
  public static final int VERSION = 1;
}
