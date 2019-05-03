package org.iotexproject.antenna.rpcmethod;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

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
import org.iotexproject.antenna.grpc.iotexapi.Api.SendActionResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceResponse;
import org.iotexproject.antenna.grpc.iotextypes.ActionOuterClass.Action;
import org.pmw.tinylog.Logger;

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
public class Client implements IoTeXGRPCInterface {
	private final static Integer REQUEST_TIMEOUT_SEC = 5;

	private static ClientImpl instance;
	private static Semaphore semaphore;

	public synchronized static ClientImpl getInstance(final String host, final Integer port) {
		return Client.getInstance(host, port, false);
	}

	public synchronized static ClientImpl getInstance(final String host, final Integer port, final Boolean ssl) {
		if (instance == null) {
			assert host != null;
			assert port != null;

			instance = new ClientImpl(host, port, ssl);

			semaphore = new Semaphore(1);
		}
		return instance;
	}

	@Override
	public synchronized GetChainMetaResponse getChainMeta() throws RPCException {
		GetChainMetaResponse result = null;
		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);

			result = instance.getChainMeta();
		} catch (InterruptedException e) {
			Logger.error(e);
			throw new RPCException(e);
		} finally {
			semaphore.release();
		}

		return result;
	}

	@Override
	public synchronized GetEpochMetaResponse getEpochMeta(final Long epoch) throws RPCException {
		GetEpochMetaResponse result = null;
		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);

			result = instance.getEpochMeta(epoch);
		} catch (InterruptedException e) {
			Logger.error(e);
			throw new RPCException(e);
		} finally {
			semaphore.release();
		}

		return result;
	}

	@Override
	public synchronized GetServerMetaResponse getServerMeta() throws RPCException {
		GetServerMetaResponse result = null;
		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);

			result = instance.getServerMeta();
		} catch (InterruptedException e) {
			Logger.error(e);
			throw new RPCException(e);
		} finally {
			semaphore.release();
		}

		return result;
	}

	@Override
	public synchronized GetBlockMetasResponse getBlockMetasByIndex(final Long start, final Long count)
			throws RPCException {
		GetBlockMetasResponse result = null;
		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);

			result = instance.getBlockMetasByIndex(start, count);
		} catch (InterruptedException e) {
			Logger.error(e);
			throw new RPCException(e);
		} finally {
			semaphore.release();
		}

		return result;
	}

	@Override
	public synchronized GetBlockMetasResponse getBlockMetasByHash(final String hash) throws RPCException {
		GetBlockMetasResponse result = null;
		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);

			result = instance.getBlockMetasByHash(hash);
		} catch (InterruptedException e) {
			Logger.error(e);
			throw new RPCException(e);
		} finally {
			semaphore.release();
		}

		return result;
	}

	@Override
	public synchronized GetAccountResponse getAccount(final String address) throws RPCException {
		GetAccountResponse result = null;
		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);

			result = instance.getAccount(address);
		} catch (InterruptedException e) {
			Logger.error(e);
			throw new RPCException(e);
		} finally {
			semaphore.release();
		}

		return result;
	}

	@Override
	public synchronized SuggestGasPriceResponse getSuggestGasPrice() throws RPCException {
		SuggestGasPriceResponse result = null;
		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);

			result = instance.getSuggestGasPrice();
		} catch (InterruptedException e) {
			Logger.error(e);
			throw new RPCException(e);
		} finally {
			semaphore.release();
		}

		return result;
	}

	@Override
	public synchronized GetActionsResponse getActionsByIndex(final Long start, final Long count) throws RPCException {
		GetActionsResponse result = null;
		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);

			result = instance.getActionsByIndex(start, count);
		} catch (InterruptedException e) {
			Logger.error(e);
			throw new RPCException(e);
		} finally {
			semaphore.release();
		}

		return result;
	}

	@Override
	public synchronized GetActionsResponse getActionsByHash(final String hash, final Boolean checkPending)
			throws RPCException {
		GetActionsResponse result = null;
		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);

			result = instance.getActionsByHash(hash, checkPending);
		} catch (InterruptedException e) {
			Logger.error(e);
			throw new RPCException(e);
		} finally {
			semaphore.release();
		}

		return result;
	}

	@Override
	public synchronized GetActionsResponse getActionsByBlock(final String hash, final Long start, final Long count)
			throws RPCException {
		GetActionsResponse result = null;
		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);

			result = instance.getActionsByBlock(hash, start, count);
		} catch (InterruptedException e) {
			Logger.error(e);
			throw new RPCException(e);
		} finally {
			semaphore.release();
		}

		return result;
	}

	@Override
	public synchronized EstimateGasForActionResponse estimateGasForAction(final Action action) throws RPCException {
		EstimateGasForActionResponse result = null;

		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);

			result = instance.estimateGasForAction(action);
		} catch (InterruptedException e) {
			Logger.error(e);
			throw new RPCException(e);
		} finally {
			semaphore.release();
		}
		return result;
	}

	@Override
	public synchronized ReadContractResponse readContract(final Action action) throws RPCException {
		ReadContractResponse result = null;

		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);

			result = instance.readContract(action);
		} catch (InterruptedException e) {
			Logger.error(e);
			throw new RPCException(e);
		} finally {
			semaphore.release();
		}
		return result;
	}

	@Override
	public synchronized GetReceiptByActionResponse getReceiptByAction(final String hash) throws RPCException {
		GetReceiptByActionResponse result = null;

		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);

			result = instance.getReceiptByAction(hash);
		} catch (InterruptedException e) {
			Logger.error(e);
			throw new RPCException(e);
		} finally {
			semaphore.release();
		}
		return result;
	}

	@Override
	public synchronized GetActionsResponse getActionsByAddress(final String address, final Long start, final Long count)
			throws RPCException {
		GetActionsResponse result = null;

		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);

			result = instance.getActionsByAddress(address, start, count);
		} catch (InterruptedException e) {
			Logger.error(e);
			throw new RPCException(e);
		} finally {
			semaphore.release();
		}
		return result;
	}

	@Override
	public ReadStateResponse readState(final String methodName, final String protocolID, final String... args)
			throws RPCException {
		ReadStateResponse result = null;

		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);

			result = instance.readState(methodName, protocolID, args);
		} catch (InterruptedException e) {
			Logger.error(e);
			throw new RPCException(e);
		} finally {
			semaphore.release();
		}
		return result;
	}

	@Override
	public synchronized SendActionResponse sendAction(final Action action) throws RPCException {
		SendActionResponse result = null;

		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);

			result = instance.sendAction(action);
		} catch (InterruptedException e) {
			Logger.error(e);
			throw new RPCException(e);
		} finally {
			semaphore.release();
		}
		return result;
	}

	@Override
	public synchronized void close() {
		if (instance != null) {
			instance.close();
			instance = null;
		}
	}
}
