/**
 * 
 */
package org.iotexproject.antenna.grpc;

import org.iotexproject.antenna.grpc.iotexapi.Api.ActionInfo;
import org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionResponse;
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
public class BrowserTest {

	private static final String HOST = "api.iotex.one";
	private static final Integer PORT = 80;
	
	@Test
	public void getAccount() {
		final String address = "io126xcrjhtp27end76ac9nmx6px2072c3vgz6suw";
		Browser browser = new Browser(HOST, PORT);
		try {
			GetAccountResponse response = browser.getAccount(address);
		    Logger.info(response);
	
			Assert.assertNotNull(response);
			Assert.assertNotNull(response.getAccountMeta());
			Assert.assertEquals(address, response.getAccountMeta().getAddress());
			
			Assert.assertNotNull(response.getAccountMeta().getBalance());
			Assert.assertNotNull(response.getAccountMeta().getNonce());
			Assert.assertNotNull(response.getAccountMeta().getPendingNonce());
		} finally {
			browser.close();
		}
	}
	
	@Test
	public void getChainMeta() {
		Browser browser = new Browser(HOST, PORT);
		try {
			GetChainMetaResponse response = browser.getChainMeta();
		    Logger.info(response);
			
			Assert.assertNotNull(response);
		} finally {
			browser.close();
		}
	}
	
	@Test
	public void GetEpochMeta() {
		final long epoch = 1;
		Browser browser = new Browser(HOST, PORT);
		try {
			GetEpochMetaResponse response = browser.getEpochMeta(epoch);
		    Logger.info(response);
			
			Assert.assertNotNull(response);
			Assert.assertNotNull(response.getEpochData());
			Assert.assertEquals(epoch, response.getEpochData().getNum());
		} finally {
			browser.close();
		}
	}
	
	@Test
	public void getServerMeta() {
		Browser browser = new Browser(HOST, PORT);
		try {
			GetServerMetaResponse response = browser.getServerMeta();
		    Logger.info(response);

			Assert.assertNotNull(response);
			Assert.assertNotNull(response.getServerMeta());
			Assert.assertNotNull(response.getServerMeta().getPackageVersion());
			Assert.assertNotNull(response.getServerMeta().getPackageCommitID());
			Assert.assertNotNull(response.getServerMeta().getGitStatus());
			Assert.assertNotNull(response.getServerMeta().getGoVersion());
			Assert.assertNotNull(response.getServerMeta().getBuildTime());
			
		} finally {
			browser.close();
		}
	}
	
	@Test
	public void getBlockMetasByIndexLenghtOne() {
		//INDEX
		Browser browser = new Browser(HOST, PORT);
		try {
			GetBlockMetasResponse response = browser.getBlockMetasByIndex(10L, 1L);
		    Logger.info(response);

			Assert.assertNotNull(response);
			Assert.assertEquals(response.getBlkMetasList().size(), 1);
		} finally {
			browser.close();
		}
	}

	@Test
	public void getBlockMetasByIndexLenghtTen() {
		//INDEX
		Browser browser = new Browser(HOST, PORT);
		try {
			GetBlockMetasResponse response = browser.getBlockMetasByIndex(10L, 10L);
		    Logger.info(response);
			Assert.assertNotNull(response);
			Assert.assertEquals(response.getBlkMetasList().size(), 10);
		} finally {
			browser.close();
		}
	}

	@Test
	public void getBlockMetasByIndexLenghtZero() {
		//INDEX
		Browser browser = new Browser(HOST, PORT);
		try {
			GetBlockMetasResponse response = browser.getBlockMetasByIndex(10L, 0L);
		    Logger.info(response);
		    
			Assert.assertNotNull(response);
			Assert.assertEquals(response.getBlkMetasList().size(), 0);
		} finally {
			browser.close();
		}
	}

	@Test
	public void getBlockMetasByHash() {
		String hash = null;
		//Retrieve hash from blockchain
		Browser browser = new Browser(HOST, PORT);
		try {
			GetBlockMetasResponse response = browser.getBlockMetasByIndex(10L, 1L);
			hash = response.getBlkMetas(0).getHash();

			//force close stream
			browser.close();
			//reopen same stream
			browser = new Browser(HOST, PORT);
			response = browser.getBlockMetasByHash(hash);
		    Logger.info(response);
			
			Assert.assertNotNull(response);
			Assert.assertEquals(response.getBlkMetasList().size(), 1);
			Assert.assertEquals(response.getBlkMetas(0).getHash(), hash);
		} finally {
			browser.close();
		}
	}
	
	@Test
	public void getSuggestGasPrice() {
		Browser browser = new Browser(HOST, PORT);
		try {
			SuggestGasPriceResponse response = browser.getSuggestGasPrice();
		    Logger.info(response);
		    
			Assert.assertNotNull(response);
			Assert.assertEquals(response.getGasPrice(), 1L);
		} finally {
			browser.close();
		}
	}
	
	@Test
	public void readContract() {
		Browser browser = new Browser(HOST, PORT);
		try {
			Long start = 0L;
			Long count = 30L;
			GetActionsResponse response = browser.getActionsByIndex(start, count);
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
		} finally {
			browser.close();
		}
	}

	@Test
	public void getActionsByIndexOne() {
		Browser browser = new Browser(HOST, PORT);
		try {
			GetActionsResponse response = browser.getActionsByIndex(10L, 1L);
		    Logger.info(response);
		    
			Assert.assertNotNull(response);
			Assert.assertNotNull(response.getActionInfoList());
			Assert.assertEquals(response.getActionInfoList().size(), 1);
		} finally {
			browser.close();
		}
	}
	@Test
	public void getActionsByIndexTen() {
		Browser browser = new Browser(HOST, PORT);
		try {
			GetActionsResponse response = browser.getActionsByIndex(10L, 10L);
		    Logger.info(response);
		    
			Assert.assertNotNull(response);
			Assert.assertNotNull(response.getActionInfoList());
			Assert.assertEquals(response.getActionInfoList().size(), 10);
		} finally {
			browser.close();
		}
	}
	@Test
	public void getActionsByIndexZero() {
		Browser browser = new Browser(HOST, PORT);
		try {
			GetActionsResponse response = browser.getActionsByIndex(10L, 0L);
		    Logger.info(response);
		    
			Assert.assertNotNull(response);
			Assert.assertNotNull(response.getActionInfoList());
			Assert.assertEquals(response.getActionInfoList().size(), 0);
		} finally {
			browser.close();
		}
	}
	@Test
	public void getActionsByHash() {
		Browser browser = new Browser(HOST, PORT);
		try {
			GetActionsResponse response = browser.getActionsByHash("65906dc502cc47237bab6c2a3d51c0fa31cce8d5c1608d9bb0e9cc843ba4af3c", false);
		    Logger.info(response);
		    
			Assert.assertNotNull(response);
			Assert.assertNotNull(response.getActionInfoList());
			Assert.assertEquals(response.getActionInfoList().size(), 1);
		} finally {
			browser.close();
		}
	}
	@Test
	public void getActionsByBlockHash() {
		Browser browser = new Browser(HOST, PORT);
		try {
			GetBlockMetasResponse response = browser.getBlockMetasByIndex(10L, 1L);
		    Logger.info(response);
			Assert.assertNotNull(response);
			Assert.assertNotNull(response.getBlkMetasList());
			Assert.assertEquals(response.getBlkMetasList().size(), 1);
			String hash = response.getBlkMetasList().get(0).getHash();
			browser.close();
			
			browser = new Browser(HOST, PORT);
			GetActionsResponse respAction = browser.getActionsByBlock(hash, 0L, 1L);
		    
			Assert.assertNotNull(respAction);
			Assert.assertNotNull(respAction.getActionInfoList());
			Assert.assertEquals(respAction.getActionInfoList().size(), 1);
		} finally {
			browser.close();
		}
	}
	//TODO TEST
	public void estimateGasForAction() {
		Browser browser = new Browser(HOST, PORT);
		try {
			GetBlockMetasResponse respBlock = browser.getBlockMetasByIndex(10L, 1L);
			Assert.assertNotNull(respBlock);
			Assert.assertNotNull(respBlock.getBlkMetasList());
			Assert.assertEquals(1, respBlock.getBlkMetasList().size());
			
			browser.close();
			browser = new Browser(HOST, PORT);
			
			GetActionsResponse respAction = browser.getActionsByBlock(respBlock.getBlkMetasList().get(0).getHash(), 0L, 1L);
			Assert.assertNotNull(respAction);
			Assert.assertNotNull(respAction.getActionInfoList());
			Assert.assertEquals(1, respAction.getActionInfoList().size());
			
			browser.close();
			browser = new Browser(HOST, PORT);
			
			EstimateGasForActionResponse response = browser.estimateGasForAction(respAction.getActionInfoList().get(0).getAction());
			
		    Logger.info(response);
		    
			Assert.assertNotNull(response);
			Assert.assertNotNull(response.getGas());
			Assert.assertEquals(10400L, response.getGas());
		} finally {
			browser.close();
		}
	}
}
