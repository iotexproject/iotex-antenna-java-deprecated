package io.iotex.antennaj.util;

import java.math.BigInteger;

public enum Unit {
  RAU("rau", 0),
  KRAU("krau", 3),
  MRAU("mrau", 6),
  GRAU("grau", 9),
  QEV("qev", 12),
  JIN("jin", 15),
  IOTX("iotx", 18);

  public static Unit getEnum(String value) {
    for (Unit v : values()) if (v.getValue().equalsIgnoreCase(value)) return v;
    throw new IllegalArgumentException();
  }

  private String name;
  private BigInteger factor;

  Unit(String name, int factor) {
    this.name = name;
    this.factor = BigInteger.TEN.pow(factor);
  }

  public BigInteger getFactor() {
    return factor;
  }

  @Override
  public String toString() {
    return name;
  }

  public String getValue() {
    return name;
  }
}
