package io.iotex.antennaj.account;

import io.iotex.antennaj.exception.AntennaException;
import io.iotex.antennaj.method.TransferMethod;
import io.iotex.antennaj.rpc.CallOption;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.crypto.Sign;
import org.web3j.crypto.Sign.SignatureData;
import org.web3j.crypto.WalletUtils;

public class Account {
  private ECKeyPair keyPair;

  public static Account create() throws AntennaException {
    try {
      return new Account(Keys.createEcKeyPair());
    } catch (InvalidAlgorithmParameterException
        | NoSuchAlgorithmException
        | NoSuchProviderException e) {
      throw new AntennaException(e);
    }
  }

  public static Account fromKey(byte[] skBytes) {
    return new Account(ECKeyPair.create(skBytes));
  }

  public static Account fromKeyStore(File path, String password) throws AntennaException {
    try {
      Credentials credentials = WalletUtils.loadCredentials(password, path);
      return new Account(credentials.getEcKeyPair());
    } catch (IOException | CipherException e) {
      throw new AntennaException(e);
    }
  }

  Account(ECKeyPair keyPair) {

    this.keyPair = keyPair;
  }

  public byte[] getPublicKey() {
    byte[] pkBytes = keyPair.getPublicKey().toByteArray();
    byte[] fixedPkBytes = new byte[pkBytes.length + 1];
    fixedPkBytes[0] = 0x04;
    System.arraycopy(pkBytes, 0, fixedPkBytes, 1, pkBytes.length);
    return fixedPkBytes;
  }

  public byte[] getPrivateKey() {
    return keyPair.getPrivateKey().toByteArray();
  }

  public Address getAddress() {
    return Address.fromPublicKey(getPublicKey());
  }

  public byte[] sign(byte[] msgHash) {
    SignatureData sigData = Sign.signMessage(msgHash, keyPair);
    byte[] result = new byte[65];
    System.arraycopy(sigData.getR(), 0, result, 0, 32);
    System.arraycopy(sigData.getS(), 0, result, 32, 32);
    result[64] = (byte) (sigData.getV()[0] - 27);
    return result;
  }

  public TransferMethod transfer(CallOption opt) {
    return new TransferMethod(this, opt);
  }
}
