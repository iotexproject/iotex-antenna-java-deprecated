package io.iotex.antennaj.method;

import com.google.protobuf.ByteString;
import io.iotex.antennaj.account.Address;
import io.iotex.antennaj.rpc.Call;
import io.iotex.antennaj.rpc.CallOption;
import io.iotex.antennaj.rpc.api.Api;

public class ReadContractMethod extends ReadMethod<Api.ReadContractRequest, Api.ReadContractResponse> {
  private Api.ReadContractRequest.Builder builder = Api.ReadContractRequest.newBuilder();

  public ReadContractMethod(CallOption opt) {
    super(opt);
  }

  public ReadContractMethod setCallerAddress(Address address) {
    this.builder.setCallerAddress(address.toString());
    return this;
  }

  public ReadContractMethod setContract(Address address) {
    this.builder.getExecutionBuilder().setContract(address.toString());
    return this;
  }

  public ReadContractMethod setData(byte[] data) {
    this.builder.getExecutionBuilder().setData(ByteString.copyFrom(data));
    return this;
  }

  @Override
  protected Api.ReadContractRequest composeRequest() {
    return builder.build();
  }

  @Override
  protected Api.ReadContractResponse executeInternal(Call call, Api.ReadContractRequest req) {
    return call.readContract(req);
  }
}
