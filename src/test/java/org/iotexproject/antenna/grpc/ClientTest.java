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
import org.iotexproject.antenna.rpcmethod.Client;
import org.junit.Assert;
import org.junit.Test;
import org.pmw.tinylog.Logger;

/**
 *  Copyright (c) 2019 IoTeX
 *  This is an alpha (internal) release and is not suitable for production. This source code is provided 'as is' and no
 *  warranties are given as to title or non-infringement, merchantability or fitness for purpose and, to the extent
 *  permitted by law, all liability for your use of the code is disclaimed. This source code is governed by Apache
 *  License 2.0 that can be found in the LICENSE file.
 * 
 * @author Fabrizio Spataro <fabryprog@gmail.com>
 */
public class ClientTest {

	private static final String HOST = "api.iotex.one";
	private static final Integer PORT = 80;
	
	@Test
	public void getAccount() {
		final String address = "io126xcrjhtp27end76ac9nmx6px2072c3vgz6suw";
		
		GetAccountResponse response = Client.getInstance(HOST, PORT).getAccount(address);
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
		GetChainMetaResponse response = Client.getInstance(HOST, PORT).getChainMeta();
	    Logger.info(response);
		
		Assert.assertNotNull(response);
	}
	
	@Test
	public void GetEpochMeta() {
		final long epoch = 1;
		GetEpochMetaResponse response = Client.getInstance(HOST, PORT).getEpochMeta(epoch);
	    Logger.info(response);
		
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getEpochData());
		Assert.assertEquals(epoch, response.getEpochData().getNum());
	}
	
	@Test
	public void getServerMeta() {
		GetServerMetaResponse response = Client.getInstance(HOST, PORT).getServerMeta();
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
		GetBlockMetasResponse response = Client.getInstance(HOST, PORT).getBlockMetasByIndex(10L, 1L);
	    Logger.info(response);

		Assert.assertNotNull(response);
		Assert.assertEquals(1, response.getBlkMetasList().size());
	}

	@Test
	public void getBlockMetasByIndexLenghtTen() {
		//INDEX
		GetBlockMetasResponse response = Client.getInstance(HOST, PORT).getBlockMetasByIndex(10L, 10L);
	    Logger.info(response);
		Assert.assertNotNull(response);
		Assert.assertEquals(10, response.getBlkMetasList().size());
	}

	@Test
	public void getBlockMetasByIndexLenghtZero() {
		//INDEX
		GetBlockMetasResponse response = Client.getInstance(HOST, PORT).getBlockMetasByIndex(10L, 0L);
	    Logger.info(response);
	    
		Assert.assertNotNull(response);
		Assert.assertEquals(0, response.getBlkMetasList().size());
	}

	@Test
	public void getBlockMetasByHash() {
		String hash = null;
		//Retrieve hash from blockchain
		GetBlockMetasResponse response = Client.getInstance(HOST, PORT).getBlockMetasByIndex(10L, 1L);
		hash = response.getBlkMetas(0).getHash();

		response = Client.getInstance(HOST, PORT).getBlockMetasByHash(hash);
	    Logger.info(response);
		
		Assert.assertNotNull(response);
		Assert.assertEquals(1, response.getBlkMetasList().size());
		Assert.assertEquals(hash, response.getBlkMetas(0).getHash());
	}
	
	@Test
	public void getSuggestGasPrice() {
		SuggestGasPriceResponse response = Client.getInstance(HOST, PORT).getSuggestGasPrice();
	    Logger.info(response);
	    
		Assert.assertNotNull(response);
		Assert.assertEquals(1000000000000L, response.getGasPrice());
	}
	
	@Test
	public void readContract() {
		Long start = 0L;
		Long count = 30L;
		GetActionsResponse response = Client.getInstance(HOST, PORT).getActionsByIndex(start, count);
	    Logger.info(response);
	    
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getActionInfoList());
		Assert.assertEquals(count.intValue(), response.getActionInfoList().size());
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
		GetActionsResponse response = Client.getInstance(HOST, PORT).getActionsByIndex(10L, 1L);
	    Logger.info(response);
	    
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getActionInfoList());
		Assert.assertEquals(1, response.getActionInfoList().size());
	}
	@Test
	public void getActionsByIndexTen() {
		GetActionsResponse response = Client.getInstance(HOST, PORT).getActionsByIndex(10L, 10L);
	    Logger.info(response);
	    
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getActionInfoList());
		Assert.assertEquals(10, response.getActionInfoList().size());
	}
	@Test
	public void getActionsByIndexZero() {
		GetActionsResponse response = Client.getInstance(HOST, PORT).getActionsByIndex(10L, 0L);
	    Logger.info(response);
	    
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getActionInfoList());
		Assert.assertEquals(0, response.getActionInfoList().size());
	}
	@Test
	public void getActionsByHash() {
		GetActionsResponse response = Client.getInstance(HOST, PORT).getActionsByHash("eb0bab335c3ab0d43020cbe3aa494933ee473394d75a52fd5112cff6af2a5d92", false);
	    Logger.info(response);
	    
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getActionInfoList());
		Assert.assertEquals(1, response.getActionInfoList().size());
	}
	@Test
	public void getActionsByBlockHash() {
		GetBlockMetasResponse response = Client.getInstance(HOST, PORT).getBlockMetasByIndex(10L, 1L);
	    Logger.info(response);
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getBlkMetasList());
		Assert.assertEquals(1, response.getBlkMetasList().size());
		String hash = response.getBlkMetasList().get(0).getHash();
		GetActionsResponse respAction = Client.getInstance(HOST, PORT).getActionsByBlock(hash, 0L, 1L);
	    
		Assert.assertNotNull(respAction);
		Assert.assertNotNull(respAction.getActionInfoList());
		Assert.assertEquals(1, respAction.getActionInfoList().size());
	}
	//TODO TEST
	public void estimateGasForAction() {
		GetBlockMetasResponse respBlock = Client.getInstance(HOST, PORT).getBlockMetasByIndex(10L, 1L);
		Assert.assertNotNull(respBlock);
		Assert.assertNotNull(respBlock.getBlkMetasList());
		Assert.assertEquals(1, respBlock.getBlkMetasList().size());
		
		GetActionsResponse respAction = Client.getInstance(HOST, PORT).getActionsByBlock(respBlock.getBlkMetasList().get(0).getHash(), 0L, 1L);
		Assert.assertNotNull(respAction);
		Assert.assertNotNull(respAction.getActionInfoList());
		Assert.assertEquals(1, respAction.getActionInfoList().size());
		
		EstimateGasForActionResponse response = Client.getInstance(HOST, PORT).estimateGasForAction(respAction.getActionInfoList().get(0).getAction());
		
	    Logger.info(response);
	    
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getGas());
		Assert.assertEquals(10400L, response.getGas());
	}
}
