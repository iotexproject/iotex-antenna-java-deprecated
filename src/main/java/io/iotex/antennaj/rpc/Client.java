package io.iotex.antennaj.rpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.iotex.antennaj.api.APIServiceGrpc;
import io.iotex.antennaj.api.APIServiceGrpc.APIServiceBlockingStub;
import io.iotex.antennaj.api.Api.*;
import io.iotex.antennaj.exception.AntennaRuntimeException;

public class Client {

  private APIServiceBlockingStub blockingStub;

  public Client(ClientOption opt) {
    ManagedChannelBuilder<?> channelBuilder = ManagedChannelBuilder.forTarget(opt.getEndpoint());
    if (opt.isSecure()) {
      channelBuilder = channelBuilder.useTransportSecurity();
    } else {
      channelBuilder = channelBuilder.usePlaintext();
    }
    ManagedChannel channel = channelBuilder.build();
    if (opt.isAsync()) {
      // TODO: support async stub
      throw new AntennaRuntimeException("");
    } else {
      blockingStub = APIServiceGrpc.newBlockingStub(channel);
    }
  }

  public GetAccountResponse getAccount(GetAccountRequest request) {
    return blockingStub.getAccount(request);
  }

  public GetActionsResponse getActions(GetActionsRequest request) {
    return blockingStub.getActions(request);
  }

  public GetBlockMetasResponse getBlockMetas(GetBlockMetasRequest request) {
    return blockingStub.getBlockMetas(request);
  }

  public GetChainMetaResponse getChainMeta(GetChainMetaRequest request) {
    return blockingStub.getChainMeta(request);
  }

  public GetServerMetaResponse getServerMeta(GetServerMetaRequest request) {
    return blockingStub.getServerMeta(request);
  }

  public SendActionResponse sendAction(SendActionRequest request) {
    return blockingStub.sendAction(request);
  }

  public GetReceiptByActionResponse getReceiptByAction(GetReceiptByActionRequest request) {
    return blockingStub.getReceiptByAction(request);
  }

  public ReadContractResponse readContract(ReadContractRequest request) {
    return blockingStub.readContract(request);
  }

  public SuggestGasPriceResponse suggestGasPrice(SuggestGasPriceRequest request) {
    return blockingStub.suggestGasPrice(request);
  }

  public EstimateGasForActionResponse estimateGasForAction(EstimateGasForActionRequest request) {
    return blockingStub.estimateGasForAction(request);
  }

  public ReadStateResponse readState(ReadStateRequest request) {
    return blockingStub.readState(request);
  }

  public GetEpochMetaResponse getEpochMeta(GetEpochMetaRequest request) {
    return blockingStub.getEpochMeta(request);
  }

  public GetRawBlocksResponse getRawBlocks(GetRawBlocksRequest request) {
    return blockingStub.getRawBlocks(request);
  }

  public GetLogsResponse getLogs(GetLogsRequest request) {
    return blockingStub.getLogs(request);
  }

  public java.util.Iterator<StreamBlocksResponse> streamBlocks(StreamBlocksRequest request) {
    return blockingStub.streamBlocks(request);
  }

  public java.util.Iterator<io.iotex.antennaj.types.ActionOuterClass.Log> streamLogs(
      StreamLogsRequest request) {
    return blockingStub.streamLogs(request);
  }
}
