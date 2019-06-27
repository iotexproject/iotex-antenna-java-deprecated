package io.iotex.antennaj.account;

import io.iotex.antennaj.exception.AddressFormatException;
import io.iotex.antennaj.exception.AntennaRuntimeException;
import io.iotex.antennaj.util.Bech32;
import io.iotex.antennaj.util.Bech32.Bech32Data;
import java.util.Arrays;
import org.web3j.crypto.Hash;

public class Address {
  private static final String AddressPrefix = "io";

  private byte[] payload;

  public static Address fromBytes(byte[] payload) {
    if (payload.length != 20) {
      throw new AntennaRuntimeException("Invalid byte array length");
    }
    return new Address(payload);
  }

  public static Address fromPublicKey(byte[] pkBytes) {
    byte[] hash256 = Hash.sha3(Arrays.copyOfRange(pkBytes, 1, pkBytes.length));
    byte[] hash160 = Arrays.copyOfRange(hash256, 12, hash256.length);
    return fromBytes(hash160);
  }

  public static Address fromString(String str) {
    try {
      Bech32Data bech32 = Bech32.decode(str);
      if (!bech32.hrp.equals(AddressPrefix)) {
        throw new AddressFormatException("Invalid address prefix");
      }
      byte[] payload = Bech32.convertBits(bech32.data, 0, bech32.data.length, 5, 8, false);
      return new Address(payload);
    } catch (AddressFormatException e) {
      throw new AntennaRuntimeException(e);
    }
  }

  private Address(byte[] payload) {
    this.payload = payload;
  }

  public byte[] getBytes() {
    return payload;
  }

  @Override
  public String toString() {
    byte[] data = Bech32.convertBits(payload, 0, payload.length, 8, 5, true);
    return Bech32.encode(AddressPrefix, data);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Arrays.equals(payload, address.payload);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(payload);
  }
}
