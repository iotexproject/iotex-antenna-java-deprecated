/**
 * 
 */
package org.iotexproject.antenna.grpc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceResponse;
import org.pmw.tinylog.Logger;

/**
 * 
 * 
 * @author Fabrizio Spataro <fabryprog@gmail.com>
 *
 */
public class IoTeXDispatcher implements IoTeXGRPCInterface {
	private final static Integer REQUEST_TIMEOUT_SEC = 5;
	
	private static Browser instance;
	private static Semaphore semaphore;
	
	public synchronized static Browser getInstance(final String host, final Integer port) {
		if(instance == null) {
			assert host != null;
			assert port != null;
			
			instance = new Browser(host, port);
			
			semaphore = new Semaphore(1);
		}
		return instance;
	}
	
	public synchronized GetChainMetaResponse getChainMeta() {
		GetChainMetaResponse result = null;
		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);
			
			result = instance.getChainMeta();
		} catch (InterruptedException e) {
			Logger.error(e);
		} finally {
			semaphore.release();
		}
		
		return result;
	}
	public GetEpochMetaResponse getEpochMeta(Long epoch) {
		GetEpochMetaResponse result = null;
		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);
			
			result = instance.getEpochMeta(epoch);
		} catch (InterruptedException e) {
			Logger.error(e);
		} finally {
			semaphore.release();
		}
		
		return result;
	}
	public GetServerMetaResponse getServerMeta() {
		GetServerMetaResponse result = null;
		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);
			
			result = instance.getServerMeta();
		} catch (InterruptedException e) {
			Logger.error(e);
		} finally {
			semaphore.release();
		}
		
		return result;
	}
	
	public GetBlockMetasResponse getBlockMetasByIndex(final Long start, final Long count) {
		GetBlockMetasResponse result = null;
		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);
			
			result = instance.getBlockMetasByIndex(start, count);
		} catch (InterruptedException e) {
			Logger.error(e);
		} finally {
			semaphore.release();
		}
		
		return result;
	}
	
	public GetBlockMetasResponse getBlockMetasByHash(final String hash) {
		GetBlockMetasResponse result = null;
		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);
			
			result = instance.getBlockMetasByHash(hash);
		} catch (InterruptedException e) {
			Logger.error(e);
		} finally {
			semaphore.release();
		}
		
		return result;
	}

	public GetAccountResponse getAccount(final String address) {
		GetAccountResponse result = null;
		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);
			
			result = instance.getAccount(address);
		} catch (InterruptedException e) {
			Logger.error(e);
		} finally {
			semaphore.release();
		}
		
		return result;
	}
	
	public SuggestGasPriceResponse getSuggestGasPrice() {
		SuggestGasPriceResponse result = null;
		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);
			
			result = instance.getSuggestGasPrice();
		} catch (InterruptedException e) {
			Logger.error(e);
		} finally {
			semaphore.release();
		}
		
		return result;
	}
	
	public GetActionsResponse getActionsByIndex(Long start, Long count) {
		GetActionsResponse result = null;
		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);
			
			result = instance.getActionsByIndex(start, count);
		} catch (InterruptedException e) {
			Logger.error(e);
		} finally {
			semaphore.release();
		}
		
		return result;
	}
	
	public void close() {
		instance.close();		
	}
}

