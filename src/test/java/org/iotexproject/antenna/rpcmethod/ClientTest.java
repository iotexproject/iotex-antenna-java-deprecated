package org.iotexproject.antenna.rpcmethod;

import org.iotexproject.antenna.grpc.iotexapi.Api.ActionInfo;
import org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.SendActionResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceResponse;
import org.iotexproject.antenna.grpc.iotextypes.ActionOuterClass.Transfer;
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
public class ClientTest implements IoTeXGRPCTestInterface {

	@Override
	@Test
	public void getAccount() {
		GetAccountResponse response = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getAccount(TestConstants.ADDRESS);
		Logger.info(response);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getAccountMeta());
		Assert.assertEquals(TestConstants.ADDRESS, response.getAccountMeta().getAddress());

		Assert.assertNotNull(response.getAccountMeta().getBalance());
		Assert.assertNotNull(response.getAccountMeta().getNonce());
		Assert.assertNotNull(response.getAccountMeta().getPendingNonce());
	}

	@Override
	@Test
	public void getChainMeta() {
		GetChainMetaResponse response = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getChainMeta();
		Logger.info(response);

		Assert.assertNotNull(response);
	}

	@Override
	@Test
	public void GetEpochMeta() {
		final long epoch = 1;
		GetEpochMetaResponse response = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getEpochMeta(epoch);
		Logger.info(response);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getEpochData());
		Assert.assertEquals(epoch, response.getEpochData().getNum());
	}

	@Override
	@Test
	public void getServerMeta() {
		GetServerMetaResponse response = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getServerMeta();
		Logger.info(response);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getServerMeta());
		Assert.assertNotNull(response.getServerMeta().getPackageVersion());
		Assert.assertNotNull(response.getServerMeta().getPackageCommitID());
		Assert.assertNotNull(response.getServerMeta().getGitStatus());
		Assert.assertNotNull(response.getServerMeta().getGoVersion());
		Assert.assertNotNull(response.getServerMeta().getBuildTime());
	}

	@Override
	@Test
	public void getBlockMetasByIndexLenghtOne() {
		// INDEX
		GetBlockMetasResponse response = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getBlockMetasByIndex(10L, 1L);
		Logger.info(response);

		Assert.assertNotNull(response);
		Assert.assertEquals(1, response.getBlkMetasList().size());
	}

	@Override
	@Test
	public void getBlockMetasByIndexLenghtTen() {
		// INDEX
		GetBlockMetasResponse response = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getBlockMetasByIndex(10L, 10L);
		Logger.info(response);
		Assert.assertNotNull(response);
		Assert.assertEquals(10, response.getBlkMetasList().size());
	}

	@Override
	@Test
	public void getBlockMetasByIndexLenghtZero() {
		// INDEX
		GetBlockMetasResponse response = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getBlockMetasByIndex(10L, 0L);
		Logger.info(response);

		Assert.assertNotNull(response);
		Assert.assertEquals(0, response.getBlkMetasList().size());
	}

	@Override
	@Test
	public void getBlockMetasByHash() {
		String hash = null;
		// Retrieve hash from blockchain
		GetBlockMetasResponse response = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getBlockMetasByIndex(10L, 1L);
		hash = response.getBlkMetas(0).getHash();

		response = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getBlockMetasByHash(hash);
		Logger.info(response);

		Assert.assertNotNull(response);
		Assert.assertEquals(1, response.getBlkMetasList().size());
		Assert.assertEquals(hash, response.getBlkMetas(0).getHash());
	}

	@Test
	@Override
	public void getSuggestGasPrice() {
		SuggestGasPriceResponse response = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getSuggestGasPrice();
		Logger.info(response);

		Assert.assertNotNull(response);
		Assert.assertEquals(TestConstants.GAS_PRICE, response.getGasPrice());
	}

	@Override
	@Test
	public void readContract() {
		Long start = 0L;
		Long count = 30L;
		GetActionsResponse response = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getActionsByIndex(start, count);
		Logger.info(response);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getActionInfoList());
		Assert.assertEquals(count.intValue(), response.getActionInfoList().size());
		for (ActionInfo item : response.getActionInfoList()) {
			Assert.assertNotNull(item.getActHash());
			Assert.assertNotNull(item.getBlkHash());
			Assert.assertNotNull(item.getAction());
			Assert.assertNotNull(item.getAction().getCore());
			Assert.assertNotNull(item.getAction().getSenderPubKey());
			Assert.assertNotNull(item.getAction().getSignature());
		}
	}

	@Override
	@Test
	public void getActionsByIndexOne() {
		GetActionsResponse response = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getActionsByIndex(10L, 1L);
		Logger.info(response);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getActionInfoList());
		Assert.assertEquals(1, response.getActionInfoList().size());
	}

	@Override
	@Test
	public void getActionsByIndexTen() {
		GetActionsResponse response = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getActionsByIndex(10L, 10L);
		Logger.info(response);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getActionInfoList());
		Assert.assertEquals(10, response.getActionInfoList().size());
	}

	@Override
	@Test
	public void getActionsByIndexZero() {
		GetActionsResponse response = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getActionsByIndex(10L, 0L);
		Logger.info(response);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getActionInfoList());
		Assert.assertEquals(0, response.getActionInfoList().size());
	}

	@Override
	@Test
	public void getActionsByHash() {
		GetActionsResponse response = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getActionsByHash(TestConstants.ACTION_HASH, false);
		Logger.info(response);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getActionInfoList());
		Assert.assertEquals(1, response.getActionInfoList().size());
	}

	@Override
	@Test
	public void getActionsByBlockHash() {
		GetBlockMetasResponse response = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getBlockMetasByIndex(10L, 1L);
		Logger.info(response);
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getBlkMetasList());
		Assert.assertEquals(1, response.getBlkMetasList().size());
		String hash = response.getBlkMetasList().get(0).getHash();
		GetActionsResponse respAction = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getActionsByBlock(hash, 0L, 1L);

		Assert.assertNotNull(respAction);
		Assert.assertNotNull(respAction.getActionInfoList());
		Assert.assertEquals(1, respAction.getActionInfoList().size());
	}

	// @Test TODO
	@Override
	public void estimateGasForAction() {
		GetBlockMetasResponse respBlock = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getBlockMetasByIndex(10L, 1L);
		Assert.assertNotNull(respBlock);
		Assert.assertNotNull(respBlock.getBlkMetasList());
		Assert.assertEquals(1, respBlock.getBlkMetasList().size());

		GetActionsResponse respAction = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getActionsByBlock(respBlock.getBlkMetasList().get(0).getHash(), 0L, 1L);
		Assert.assertNotNull(respAction);
		Assert.assertNotNull(respAction.getActionInfoList());
		Assert.assertEquals(1, respAction.getActionInfoList().size());

		EstimateGasForActionResponse response = Client
				.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.estimateGasForAction(respAction.getActionInfoList().get(0).getAction());

		Logger.info(response);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getGas());
		Assert.assertEquals(10400L, response.getGas());
	}

	@Test
	public void getActionsByAddress() {
		GetBlockMetasResponse response = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getBlockMetasByIndex(10L, 1L);
		Logger.info(response);
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getBlkMetasList());
		Assert.assertEquals(1, response.getBlkMetasList().size());
		String hash = response.getBlkMetasList().get(0).getHash();

		GetActionsResponse respAction = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getActionsByBlock(hash, 0L, 15L);

		Assert.assertNotNull(respAction);
		Assert.assertNotNull(respAction.getActionInfoList());

		Transfer t = null;

		for (ActionInfo actionInfo : respAction.getActionInfoList()) {
			t = actionInfo.getAction().getCore().getTransfer();
			if (t != null && !"".equals(t.getRecipient())) {

				GetActionsResponse resp = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
						.getActionsByAddress(t.getRecipient(), 0L, 1L);

				Assert.assertNotNull(resp);
				Assert.assertNotNull(respAction.getActionInfoList());
				Assert.assertEquals(1, respAction.getActionInfoList().size());

				break;
			}
		}
	}

	@Override
	@Test
	public void readState() {
		ReadStateResponse resp = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.readState(TestConstants.METHOD_NAME, TestConstants.PROTOCOL_ID, TestConstants.ARGS_0);
		Assert.assertNotNull(resp);
		Assert.assertNotNull(resp.getData());
	}

	@Override
	@Test
	public void sendAction() {
		GetBlockMetasResponse response = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getBlockMetasByIndex(10L, 1L);
		Logger.info(response);
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getBlkMetasList());
		Assert.assertEquals(response.getBlkMetasList().size(), 1);
		String hash = response.getBlkMetasList().get(0).getHash();

		GetActionsResponse respAction = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getActionsByBlock(hash, 0L, 15L);

		Assert.assertNotNull(respAction);
		Assert.assertNotNull(respAction.getActionInfoList());

		for (ActionInfo info : respAction.getActionInfoList()) {
			if (info.getAction().getCore().getExecution() != null || info.getAction().getCore().getVote() != null) {

				SendActionResponse resp = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
						.sendAction(info.getAction());

				Logger.info(resp);

				Assert.assertNotNull(resp);
			}
		}
	}

	@Test
	public void getReceiptByAction() {
		GetReceiptByActionResponse response = Client
				.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getReceiptByAction(TestConstants.RECEIPT_ACTION_HASH);
		Logger.info(response);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getReceiptInfo());
	}

	@Test
	@Override
	public void getUnconfirmedActionsByAddress() {
		GetActionsResponse response = Client.getInstance(TestConstants.HOST, TestConstants.PORT, TestConstants.SSL)
				.getUnconfirmedActionsByAddress(TestConstants.UNCONFIRMED_ADDRESS, 0L, 1L);
		Logger.info(response);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getActionInfoList());
		Assert.assertEquals(0, response.getActionInfoList().size());
	}
}
