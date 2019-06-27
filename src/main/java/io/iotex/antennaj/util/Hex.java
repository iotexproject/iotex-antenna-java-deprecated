package io.iotex.antennaj.util;

public class Hex {
  public static String encode(byte[] bytes) {
    return org.bouncycastle.util.encoders.Hex.toHexString(bytes);
  }

  public static byte[] decode(String str) {
    return org.bouncycastle.util.encoders.Hex.decode(str);
  }
}
