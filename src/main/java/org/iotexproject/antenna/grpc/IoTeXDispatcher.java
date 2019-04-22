/**
 * 
 */
package org.iotexproject.antenna.grpc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceResponse;
import org.iotexproject.antenna.grpc.iotextypes.ActionOuterClass.Action;
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
	public synchronized GetEpochMetaResponse getEpochMeta(Long epoch) {
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
	public synchronized GetServerMetaResponse getServerMeta() {
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
	
	public synchronized GetBlockMetasResponse getBlockMetasByIndex(final Long start, final Long count) {
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
	
	public synchronized GetBlockMetasResponse getBlockMetasByHash(final String hash) {
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

	public synchronized GetAccountResponse getAccount(final String address) {
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
	
	public synchronized SuggestGasPriceResponse getSuggestGasPrice() {
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
	
	public synchronized GetActionsResponse getActionsByIndex(Long start, Long count) {
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
	
	public synchronized GetActionsResponse getActionsByHash(String hash, Boolean checkPending) {
		GetActionsResponse result = null;
		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);
			
			result = instance.getActionsByHash(hash, checkPending);
		} catch (InterruptedException e) {
			Logger.error(e);
		} finally {
			semaphore.release();
		}
		
		return result;
	}
	
	public synchronized GetActionsResponse getActionsByBlock(String hash, Long start, Long count) {
		GetActionsResponse result = null;
		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);
			
			result = instance.getActionsByBlock(hash, start, count);
		} catch (InterruptedException e) {
			Logger.error(e);
		} finally {
			semaphore.release();
		}
		
		return result;
	}
	
	public synchronized EstimateGasForActionResponse estimateGasForAction(Action action) {
		EstimateGasForActionResponse result = null;
		
		try {
			semaphore.tryAcquire(REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS);
			
			result = instance.estimateGasForAction(action);
		}catch (InterruptedException e) {
			Logger.error(e);
		} finally {
			semaphore.release();
		}
		return result;
	}
	
	public synchronized void close() {
		instance.close();
		
		instance = null;
	}
}

