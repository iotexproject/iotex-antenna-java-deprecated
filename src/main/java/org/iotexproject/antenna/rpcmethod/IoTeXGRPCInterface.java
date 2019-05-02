package org.iotexproject.antenna.rpcmethod;

import org.iotexproject.antenna.exceptions.RPCException;
import org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceResponse;
import org.iotexproject.antenna.grpc.iotextypes.ActionOuterClass.Action;

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
public interface IoTeXGRPCInterface {
	public GetChainMetaResponse getChainMeta() throws RPCException;

	public GetEpochMetaResponse getEpochMeta(final Long epoch) throws RPCException;

	public GetServerMetaResponse getServerMeta() throws RPCException;

	public GetBlockMetasResponse getBlockMetasByIndex(final Long start, final Long count) throws RPCException;

	public GetBlockMetasResponse getBlockMetasByHash(final String hash) throws RPCException;

	public GetAccountResponse getAccount(final String address) throws RPCException;

	public SuggestGasPriceResponse getSuggestGasPrice() throws RPCException;

	public GetActionsResponse getActionsByIndex(final Long start, final Long count) throws RPCException;

	public GetActionsResponse getActionsByHash(final String hash, final Boolean checkPending) throws RPCException;

	public GetActionsResponse getActionsByBlock(final String hash, final Long start, final Long count) throws RPCException;

	public EstimateGasForActionResponse estimateGasForAction(final Action action) throws RPCException;

	public GetReceiptByActionResponse getReceiptByAction(final String hash) throws RPCException;

	public ReadContractResponse readContract(final Action action) throws RPCException;

	public GetActionsResponse getActionsByAddress(final String address, final Long start, final Long count) throws RPCException;

	public ReadStateResponse readState(final String methodName, final String protocolID, final String... args) throws RPCException;

	public void close() throws RPCException;
}
