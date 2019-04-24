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
 * 
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
