/**
 * 
 */
package org.iotexproject.antenna.grpc;

import org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaResponse;
import org.junit.Assert;
import org.junit.Test;
import org.pmw.tinylog.Logger;

/**
 * @author fabryprog
 *
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
		    Logger.info("<<< getAccount() >>>");
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
		    Logger.info("<<< getChainMeta() >>>");
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
		    Logger.info("<<< GetEpochMeta() >>>");
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
		    Logger.info("<<< getServerMeta() >>>");
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
		    Logger.info("<<< getBlockMetas() - 1>>>");
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
		    Logger.info("<<< getBlockMetasByIndexLenghtTen() >>>");
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
		    Logger.info("<<< getBlockMetasByIndexLenghtZero() >>>");
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
			
			Assert.assertNotNull(response);
			Assert.assertEquals(response.getBlkMetasList().size(), 1);
			Assert.assertEquals(response.getBlkMetas(0).getHash(), hash);
		} finally {
			browser.close();
		}
	}

}
