/**
 * 
 */
package org.iotexproject.antenna.grpc;

import org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaResponse;
import org.iotexproject.antenna.grpc.iotextypes.Blockchain.AccountMeta;
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
			AccountMeta response = browser.getAccount(address);
		    Logger.info("<<< getAccount() >>>");
		    Logger.info(response);
	
			Assert.assertNotNull(response);
			Assert.assertEquals(address, response.getAddress());
			
			Assert.assertNotNull(response.getBalance());
			Assert.assertNotNull(response.getNonce());
			Assert.assertNotNull(response.getPendingNonce());
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
	
}
