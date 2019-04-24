package org.iotexproject.antenna.rpcmethod;

import org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsByIndexRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceResponse;

/**
 *  Copyright (c) 2019 IoTeX
 *  This is an alpha (internal) release and is not suitable for production. This source code is provided 'as is' and no
 *  warranties are given as to title or non-infringement, merchantability or fitness for purpose and, to the extent
 *  permitted by law, all liability for your use of the code is disclaimed. This source code is governed by Apache
 *  License 2.0 that can be found in the LICENSE file.
 * 
 * @author Fabrizio Spataro <fabryprog@gmail.com>
 *
 */
public interface IoTeXGRPCInterface {
	public GetChainMetaResponse getChainMeta();

	public GetEpochMetaResponse getEpochMeta(Long epoch);

	public GetServerMetaResponse getServerMeta();

	public GetBlockMetasResponse getBlockMetasByIndex(final Long start, final Long count);

	public GetBlockMetasResponse getBlockMetasByHash(final String hash);

	public GetAccountResponse getAccount(final String address);

	public SuggestGasPriceResponse getSuggestGasPrice();

	public GetActionsResponse getActionsByIndex(Long start, Long count);

	public void close();
}
