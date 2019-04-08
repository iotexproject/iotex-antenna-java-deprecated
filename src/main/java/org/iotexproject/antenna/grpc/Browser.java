/**
 * 
 */
package org.iotexproject.antenna.grpc;

import org.iotexproject.antenna.grpc.iotexapi.APIServiceGrpc;
import org.iotexproject.antenna.grpc.iotexapi.APIServiceGrpc.APIServiceBlockingStub;
import org.iotexproject.antenna.grpc.iotexapi.APIServiceGrpc.APIServiceStub;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsByIndexRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetaByHashRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasByIndexRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceResponse;
import org.iotexproject.antenna.grpc.iotextypes.Blockchain.AccountMeta;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author fabryprog
 *
 */
public class Browser {
	private final ManagedChannel channel;
	private final APIServiceBlockingStub blockingStub;
	private final APIServiceStub asyncStub;
	private AccountMeta result;
    
	public Browser(final String host, final Integer port) {
		this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
	}

	public Browser(ManagedChannelBuilder<?> channelBuilder) {
		channel = channelBuilder.build();
		blockingStub = APIServiceGrpc.newBlockingStub(channel);
		asyncStub = APIServiceGrpc.newStub(channel);
	}
	
	public GetChainMetaResponse getChainMeta() {
		GetChainMetaRequest req = GetChainMetaRequest.newBuilder().build();
	  	return blockingStub.getChainMeta(req);
	}
	public GetEpochMetaResponse getEpochMeta(Long epoch) {
		GetEpochMetaRequest req = GetEpochMetaRequest.newBuilder().setEpochNumber(epoch).build();
	  	return blockingStub.getEpochMeta(req);
	}
	public GetServerMetaResponse getServerMeta() {
		GetServerMetaRequest req = GetServerMetaRequest.newBuilder().build();
	  	return blockingStub.getServerMeta(req);
	}
	
	public GetBlockMetasResponse getBlockMetasByIndex(final Long start, final Long count) {
		GetBlockMetasByIndexRequest reqIdx = GetBlockMetasByIndexRequest.newBuilder().setStart(start).setCount(count).build();
		GetBlockMetasRequest req = GetBlockMetasRequest.newBuilder().setByIndex(reqIdx).build();
		
		return blockingStub.getBlockMetas(req);
	}
	
	public GetBlockMetasResponse getBlockMetasByHash(final String hash) {
		GetBlockMetaByHashRequest reqHash = GetBlockMetaByHashRequest.newBuilder().setBlkHash(hash).build();
		GetBlockMetasRequest req = GetBlockMetasRequest.newBuilder().setByHash(reqHash).build();
		
		return blockingStub.getBlockMetas(req);
	}

	public GetAccountResponse getAccount(final String address) {
		GetAccountRequest req = GetAccountRequest.newBuilder().setAddress(address).build();
		return blockingStub.getAccount(req);
	}
	
	public SuggestGasPriceResponse getSuggestGasPrice() {
		SuggestGasPriceRequest req = SuggestGasPriceRequest.newBuilder().build();
		return blockingStub.suggestGasPrice(req);
	}
	
	public GetActionsResponse getActionsByIndex(Long start, Long count) {
		GetActionsByIndexRequest reqIdx = GetActionsByIndexRequest.newBuilder().setStart(start).setCount(count).build();
		
		GetActionsRequest req = GetActionsRequest.newBuilder().setByIndex(reqIdx).build();
		return blockingStub.getActions(req);
	}
	
	public void close() {
		channel.shutdownNow();		
	}
}

