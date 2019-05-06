package org.iotexproject.antenna.rpcmethod;

import org.iotexproject.antenna.grpc.iotexapi.APIServiceGrpc;
import org.iotexproject.antenna.grpc.iotexapi.APIServiceGrpc.APIServiceBlockingStub;
import org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetActionByHashRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsByAddressRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsByBlockRequest;
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
import org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetUnconfirmedActionsByAddressRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.SendActionRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.SendActionResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceResponse;
import org.iotexproject.antenna.grpc.iotextypes.ActionOuterClass.Action;

import com.google.protobuf.ByteString;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * Copyright (c) 2019 IoTeX This is an alpha (internal) release and is not
 * suitable for production. This source code is provided 'as is' and no
 * warranties are given as to title or non-infringement, merchantability or
 * fitness for purpose and, to the extent permitted by law, all liability for
 * your use of the code is disclaimed. This source code is governed by Apache
 * License 2.0 that can be found in the LICENSE file.
 * 
 * @author Fabrizio Spataro <fabryprog@gmail.com>
 *
 */
public class ClientImpl implements IoTeXGRPCInterface {
	private final ManagedChannel channel;
	private final APIServiceBlockingStub blockingStub;

	public ClientImpl(final String host, final Integer port) {
		this(host, port, false);
	}

	public ClientImpl(final String host, final Integer port, final Boolean ssl) {
		if (Boolean.TRUE.equals(ssl)) {
			channel = ManagedChannelBuilder.forAddress(host, port).build();
		} else {
			channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		}

		blockingStub = APIServiceGrpc.newBlockingStub(channel);
	}

	@Override
	public GetChainMetaResponse getChainMeta() {
		GetChainMetaRequest req = GetChainMetaRequest.newBuilder().build();
		return blockingStub.getChainMeta(req);
	}

	@Override
	public GetEpochMetaResponse getEpochMeta(final Long epoch) {
		GetEpochMetaRequest req = GetEpochMetaRequest.newBuilder().setEpochNumber(epoch).build();
		return blockingStub.getEpochMeta(req);
	}

	@Override
	public GetServerMetaResponse getServerMeta() {
		GetServerMetaRequest req = GetServerMetaRequest.newBuilder().build();
		return blockingStub.getServerMeta(req);
	}

	@Override
	public GetBlockMetasResponse getBlockMetasByIndex(final Long start, final Long count) {
		GetBlockMetasByIndexRequest reqIdx = GetBlockMetasByIndexRequest.newBuilder().setStart(start).setCount(count)
				.build();
		GetBlockMetasRequest req = GetBlockMetasRequest.newBuilder().setByIndex(reqIdx).build();

		return blockingStub.getBlockMetas(req);
	}

	@Override
	public GetBlockMetasResponse getBlockMetasByHash(final String hash) {
		GetBlockMetaByHashRequest reqHash = GetBlockMetaByHashRequest.newBuilder().setBlkHash(hash).build();
		GetBlockMetasRequest req = GetBlockMetasRequest.newBuilder().setByHash(reqHash).build();

		return blockingStub.getBlockMetas(req);
	}

	@Override
	public GetAccountResponse getAccount(final String address) {
		GetAccountRequest req = GetAccountRequest.newBuilder().setAddress(address).build();
		return blockingStub.getAccount(req);
	}

	@Override
	public SuggestGasPriceResponse getSuggestGasPrice() {
		SuggestGasPriceRequest req = SuggestGasPriceRequest.newBuilder().build();
		return blockingStub.suggestGasPrice(req);
	}

	@Override
	public GetActionsResponse getActionsByIndex(final Long start, final Long count) {
		GetActionsByIndexRequest reqIdx = GetActionsByIndexRequest.newBuilder().setStart(start).setCount(count).build();

		GetActionsRequest req = GetActionsRequest.newBuilder().setByIndex(reqIdx).build();
		return blockingStub.getActions(req);
	}

	@Override
	public GetActionsResponse getActionsByHash(final String hash, final Boolean checkPending) {
		GetActionByHashRequest reqHash = GetActionByHashRequest.newBuilder().setActionHash(hash)
				.setCheckPending(checkPending).build();

		GetActionsRequest req = GetActionsRequest.newBuilder().setByHash(reqHash).build();
		return blockingStub.getActions(req);
	}

	@Override
	public GetActionsResponse getActionsByBlock(final String hash, Long start, final Long count) {
		GetActionsByBlockRequest reqBlock = GetActionsByBlockRequest.newBuilder().setBlkHash(hash).setStart(start)
				.setCount(count).build();

		GetActionsRequest req = GetActionsRequest.newBuilder().setByBlk(reqBlock).build();
		return blockingStub.getActions(req);
	}

	@Override
	public EstimateGasForActionResponse estimateGasForAction(final Action action) {
		EstimateGasForActionRequest req = EstimateGasForActionRequest.newBuilder().setAction(action).build();

		return blockingStub.estimateGasForAction(req);
	}

	@Override
	public GetReceiptByActionResponse getReceiptByAction(final String hash) {
		GetReceiptByActionRequest req = GetReceiptByActionRequest.newBuilder().setActionHash(hash).build();

		return blockingStub.getReceiptByAction(req);
	}

	@Override
	public ReadContractResponse readContract(final Action action) {
		ReadContractRequest req = ReadContractRequest.newBuilder().setAction(action).build();

		return blockingStub.readContract(req);
	}

	@Override
	public GetActionsResponse getActionsByAddress(final String address, final Long start, final Long count) {
		GetActionsByAddressRequest reqByAddr = GetActionsByAddressRequest.newBuilder().setAddress(address)
				.setStart(start).setCount(count).build();

		GetActionsRequest req = GetActionsRequest.newBuilder().setByAddr(reqByAddr).build();

		return blockingStub.getActions(req);
	}

	@Override
	public ReadStateResponse readState(final String methodName, final String protocolID, final String... args) {
		ReadStateRequest.Builder builder = ReadStateRequest.newBuilder()
				.setMethodName(ByteString.copyFrom(methodName.getBytes()))
				.setProtocolID(ByteString.copyFrom(protocolID.getBytes()));

		for (String a : args) {
			builder.addArguments(ByteString.copyFrom(a.getBytes()));
		}

		ReadStateRequest req = builder.build();

		return blockingStub.readState(req);
	}

	@Override
	public SendActionResponse sendAction(final Action action) {
		SendActionRequest req = SendActionRequest.newBuilder().setAction(action).build();

		return blockingStub.sendAction(req);
	}

	@Override
	public GetActionsResponse getUnconfirmedActionsByAddress(final String address, final Long start, final Long count) {
		GetUnconfirmedActionsByAddressRequest reqUnconfirm = GetUnconfirmedActionsByAddressRequest.newBuilder()
				.setAddress(address).setStart(start).setCount(count).build();
		GetActionsRequest req = GetActionsRequest.newBuilder().setUnconfirmedByAddr(reqUnconfirm).build();

		return blockingStub.getActions(req);
	}

	@Override
	public void close() {
		channel.shutdownNow();
	}
}
