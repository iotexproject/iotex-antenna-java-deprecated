/**
 * 
 */
package org.iotexproject.antenna.rpcmethod;

import org.iotexproject.antenna.grpc.iotexapi.Api.ActionInfo;
import org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceResponse;
import org.iotexproject.antenna.rpcmethod.ClientImpl;
import org.junit.Assert;
import org.junit.Test;
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
 */
public class ClientImplTest implements IoTeXGRPCTestInterface {

	@Test
	public void getAccount() {
		ClientImpl browser = new ClientImpl(TestConstants.HOST, TestConstants.PORT);
		try {
			GetAccountResponse response = browser.getAccount(TestConstants.ADDRESS);
			Logger.info(response);

			Assert.assertNotNull(response);
			Assert.assertNotNull(response.getAccountMeta());
			Assert.assertEquals(TestConstants.ADDRESS, response.getAccountMeta().getAddress());

			Assert.assertNotNull(response.getAccountMeta().getBalance());
			Assert.assertNotNull(response.getAccountMeta().getNonce());
			Assert.assertNotNull(response.getAccountMeta().getPendingNonce());
		} finally {
			browser.close();
		}
	}

	@Test
	public void getChainMeta() {
		ClientImpl browser = new ClientImpl(TestConstants.HOST, TestConstants.PORT);
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
		ClientImpl browser = new ClientImpl(TestConstants.HOST, TestConstants.PORT);
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
		ClientImpl browser = new ClientImpl(TestConstants.HOST, TestConstants.PORT);
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
		// INDEX
		ClientImpl browser = new ClientImpl(TestConstants.HOST, TestConstants.PORT);
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
		// INDEX
		ClientImpl browser = new ClientImpl(TestConstants.HOST, TestConstants.PORT);
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
		// INDEX
		ClientImpl browser = new ClientImpl(TestConstants.HOST, TestConstants.PORT);
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
		// Retrieve hash from blockchain
		ClientImpl browser = new ClientImpl(TestConstants.HOST, TestConstants.PORT);
		try {
			GetBlockMetasResponse response = browser.getBlockMetasByIndex(10L, 1L);
			hash = response.getBlkMetas(0).getHash();

			// force close stream
			browser.close();
			// reopen same stream
			browser = new ClientImpl(TestConstants.HOST, TestConstants.PORT);
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
		ClientImpl browser = new ClientImpl(TestConstants.HOST, TestConstants.PORT);
		try {
			SuggestGasPriceResponse response = browser.getSuggestGasPrice();
			Logger.info(response);

			Assert.assertNotNull(response);
			Assert.assertEquals(response.getGasPrice(), 1000000000000L);
		} finally {
			browser.close();
		}
	}

	@Test
	public void readContract() {
		ClientImpl browser = new ClientImpl(TestConstants.HOST, TestConstants.PORT);
		try {
			Long start = 0L;
			Long count = 30L;
			GetActionsResponse response = browser.getActionsByIndex(start, count);
			Logger.info(response);

			Assert.assertNotNull(response);
			Assert.assertNotNull(response.getActionInfoList());
			Assert.assertEquals(response.getActionInfoList().size(), count.intValue());
			for (ActionInfo item : response.getActionInfoList()) {
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
		ClientImpl browser = new ClientImpl(TestConstants.HOST, TestConstants.PORT);
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
		ClientImpl browser = new ClientImpl(TestConstants.HOST, TestConstants.PORT);
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
		ClientImpl browser = new ClientImpl(TestConstants.HOST, TestConstants.PORT);
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
		ClientImpl browser = new ClientImpl(TestConstants.HOST, TestConstants.PORT);
		try {
			GetActionsResponse response = browser.getActionsByHash(TestConstants.ACTION_HASH, false);
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
		ClientImpl browser = new ClientImpl(TestConstants.HOST, TestConstants.PORT);
		try {
			GetBlockMetasResponse response = browser.getBlockMetasByIndex(10L, 1L);
			Logger.info(response);
			Assert.assertNotNull(response);
			Assert.assertNotNull(response.getBlkMetasList());
			Assert.assertEquals(response.getBlkMetasList().size(), 1);
			String hash = response.getBlkMetasList().get(0).getHash();
			browser.close();

			browser = new ClientImpl(TestConstants.HOST, TestConstants.PORT);
			GetActionsResponse respAction = browser.getActionsByBlock(hash, 0L, 1L);

			Assert.assertNotNull(respAction);
			Assert.assertNotNull(respAction.getActionInfoList());
			Assert.assertEquals(respAction.getActionInfoList().size(), 1);
		} finally {
			browser.close();
		}
	}

//	@Test TODO
	public void estimateGasForAction() {
		ClientImpl browser = new ClientImpl(TestConstants.HOST, TestConstants.PORT);
		try {
			GetBlockMetasResponse respBlock = browser.getBlockMetasByIndex(10L, 1L);
			Assert.assertNotNull(respBlock);
			Assert.assertNotNull(respBlock.getBlkMetasList());
			Assert.assertEquals(1, respBlock.getBlkMetasList().size());

			browser.close();
			browser = new ClientImpl(TestConstants.HOST, TestConstants.PORT);

			GetActionsResponse respAction = browser.getActionsByBlock(respBlock.getBlkMetasList().get(0).getHash(), 0L,
					1L);
			Assert.assertNotNull(respAction);
			Assert.assertNotNull(respAction.getActionInfoList());
			Assert.assertEquals(1, respAction.getActionInfoList().size());

			browser.close();
			browser = new ClientImpl(TestConstants.HOST, TestConstants.PORT);

			EstimateGasForActionResponse response = browser
					.estimateGasForAction(respAction.getActionInfoList().get(0).getAction());

			Logger.info(response);

			Assert.assertNotNull(response);
			Assert.assertNotNull(response.getGas());
			Assert.assertEquals(10400L, response.getGas());
		} finally {
			browser.close();
		}
	}
}