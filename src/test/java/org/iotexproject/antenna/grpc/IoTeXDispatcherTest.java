/**
 * 
 */
package org.iotexproject.antenna.grpc;

import org.iotexproject.antenna.grpc.iotexapi.Api.ActionInfo;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceResponse;
import org.junit.Assert;
import org.junit.Test;
import org.pmw.tinylog.Logger;

/**
 * 
 * @author Fabrizio Spataro <fabryprog@gmail.com>
 */
public class IoTeXDispatcherTest {

	private static final String HOST = "api.iotex.one";
	private static final Integer PORT = 80;
	
	@Test
	public void getAccount() {
		final String address = "io126xcrjhtp27end76ac9nmx6px2072c3vgz6suw";
		
		GetAccountResponse response = IoTeXDispatcher.getInstance(HOST, PORT).getAccount(address);
	    Logger.info(response);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getAccountMeta());
		Assert.assertEquals(address, response.getAccountMeta().getAddress());
		
		Assert.assertNotNull(response.getAccountMeta().getBalance());
		Assert.assertNotNull(response.getAccountMeta().getNonce());
		Assert.assertNotNull(response.getAccountMeta().getPendingNonce());
	}
	
	@Test
	public void getChainMeta() {
		GetChainMetaResponse response = IoTeXDispatcher.getInstance(HOST, PORT).getChainMeta();
	    Logger.info(response);
		
		Assert.assertNotNull(response);
	}
	
	@Test
	public void GetEpochMeta() {
		final long epoch = 1;
		GetEpochMetaResponse response = IoTeXDispatcher.getInstance(HOST, PORT).getEpochMeta(epoch);
	    Logger.info(response);
		
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getEpochData());
		Assert.assertEquals(epoch, response.getEpochData().getNum());
	}
	
	@Test
	public void getServerMeta() {
		GetServerMetaResponse response = IoTeXDispatcher.getInstance(HOST, PORT).getServerMeta();
	    Logger.info(response);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getServerMeta());
		Assert.assertNotNull(response.getServerMeta().getPackageVersion());
		Assert.assertNotNull(response.getServerMeta().getPackageCommitID());
		Assert.assertNotNull(response.getServerMeta().getGitStatus());
		Assert.assertNotNull(response.getServerMeta().getGoVersion());
		Assert.assertNotNull(response.getServerMeta().getBuildTime());
	}
	
	@Test
	public void getBlockMetasByIndexLenghtOne() {
		//INDEX
		GetBlockMetasResponse response = IoTeXDispatcher.getInstance(HOST, PORT).getBlockMetasByIndex(10L, 1L);
	    Logger.info(response);

		Assert.assertNotNull(response);
		Assert.assertEquals(response.getBlkMetasList().size(), 1);
	}

	@Test
	public void getBlockMetasByIndexLenghtTen() {
		//INDEX
		GetBlockMetasResponse response = IoTeXDispatcher.getInstance(HOST, PORT).getBlockMetasByIndex(10L, 10L);
	    Logger.info(response);
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getBlkMetasList().size(), 10);
	}

	@Test
	public void getBlockMetasByIndexLenghtZero() {
		//INDEX
		GetBlockMetasResponse response = IoTeXDispatcher.getInstance(HOST, PORT).getBlockMetasByIndex(10L, 0L);
	    Logger.info(response);
	    
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getBlkMetasList().size(), 0);
	}

	@Test
	public void getBlockMetasByHash() {
		String hash = null;
		//Retrieve hash from blockchain
		GetBlockMetasResponse response = IoTeXDispatcher.getInstance(HOST, PORT).getBlockMetasByIndex(10L, 1L);
		hash = response.getBlkMetas(0).getHash();

		response = IoTeXDispatcher.getInstance(HOST, PORT).getBlockMetasByHash(hash);
	    Logger.info(response);
		
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getBlkMetasList().size(), 1);
		Assert.assertEquals(response.getBlkMetas(0).getHash(), hash);
	}
	
	@Test
	public void getSuggestGasPrice() {
		SuggestGasPriceResponse response = IoTeXDispatcher.getInstance(HOST, PORT).getSuggestGasPrice();
	    Logger.info(response);
	    
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getGasPrice(), 1L);
	}
	
	@Test
	public void readContract() {
		Long start = 0L;
		Long count = 30L;
		GetActionsResponse response = IoTeXDispatcher.getInstance(HOST, PORT).getActionsByIndex(start, count);
	    Logger.info(response);
	    
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getActionInfoList());
		Assert.assertEquals(response.getActionInfoList().size(), count.intValue());
		for(ActionInfo item : response.getActionInfoList()) {
			Assert.assertNotNull(item.getActHash());
			Assert.assertNotNull(item.getBlkHash());
			Assert.assertNotNull(item.getAction());
			Assert.assertNotNull(item.getAction().getCore());
			Assert.assertNotNull(item.getAction().getSenderPubKey());
			Assert.assertNotNull(item.getAction().getSignature());
		}
	}

	@Test
	public void getActionsByIndexOne() {
		GetActionsResponse response = IoTeXDispatcher.getInstance(HOST, PORT).getActionsByIndex(10L, 1L);
	    Logger.info(response);
	    
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getActionInfoList());
		Assert.assertEquals(response.getActionInfoList().size(), 1);
	}
	@Test
	public void getActionsByIndexTen() {
		GetActionsResponse response = IoTeXDispatcher.getInstance(HOST, PORT).getActionsByIndex(10L, 10L);
	    Logger.info(response);
	    
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getActionInfoList());
		Assert.assertEquals(response.getActionInfoList().size(), 10);
	}
	@Test
	public void getActionsByIndexZero() {
		GetActionsResponse response = IoTeXDispatcher.getInstance(HOST, PORT).getActionsByIndex(10L, 0L);
	    Logger.info(response);
	    
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getActionInfoList());
		Assert.assertEquals(response.getActionInfoList().size(), 0);
	}
	@Test
	public void getActionsByHash() {
		GetActionsResponse response = IoTeXDispatcher.getInstance(HOST, PORT).getActionsByHash("65906dc502cc47237bab6c2a3d51c0fa31cce8d5c1608d9bb0e9cc843ba4af3c", false);
	    Logger.info(response);
	    
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getActionInfoList());
		Assert.assertEquals(response.getActionInfoList().size(), 1);
	}
	@Test
	public void getActionsByBlockHash() {
		GetBlockMetasResponse response = IoTeXDispatcher.getInstance(HOST, PORT).getBlockMetasByIndex(10L, 1L);
	    Logger.info(response);
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getBlkMetasList());
		Assert.assertEquals(response.getBlkMetasList().size(), 1);
		String hash = response.getBlkMetasList().get(0).getHash();
		GetActionsResponse respAction = IoTeXDispatcher.getInstance(HOST, PORT).getActionsByBlock(hash, 0L, 1L);
	    
		Assert.assertNotNull(respAction);
		Assert.assertNotNull(respAction.getActionInfoList());
		Assert.assertEquals(respAction.getActionInfoList().size(), 1);
	}
}
