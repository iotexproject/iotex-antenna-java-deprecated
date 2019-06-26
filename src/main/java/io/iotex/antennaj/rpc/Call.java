package io.iotex.antennaj.rpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.iotex.antennaj.exception.AntennaRuntimeException;
import io.iotex.antennaj.rpc.APIServiceGrpc.APIServiceBlockingStub;
import io.iotex.antennaj.rpc.Api.*;
import io.iotex.antennaj.type.ActionOuterClass.Log;

public class Call implements AutoCloseable {
  private ManagedChannel channel;
  private APIServiceBlockingStub blockingStub;

  public Call(CallOption opt) {
    ManagedChannelBuilder<?> channelBuilder = ManagedChannelBuilder.forTarget(opt.getEndpoint());
    if (opt.isSecure()) {
      channelBuilder = channelBuilder.useTransportSecurity();
    } else {
      channelBuilder = channelBuilder.usePlaintext();
    }
    channel = channelBuilder.build();
    if (opt.isAsync()) {
      // TODO: support async stub
      throw new AntennaRuntimeException("Async grpc call isn't supported yet");
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

  public java.util.Iterator<Log> streamLogs(StreamLogsRequest request) {
    return blockingStub.streamLogs(request);
  }

  @Override
  public void close() {
    channel.shutdown();
  }
}
