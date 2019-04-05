/**
 * 
 */
package org.iotexproject.antenna.grpc;

import org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaResponse;
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
	
	private Browser browser;
	
	public BrowserTest() {
		this.browser = new Browser(HOST, 80);
	}
	
	@Test
	public void getAccount() {
		final String address = "io126xcrjhtp27end76ac9nmx6px2072c3vgz6suw";
		AccountMeta response = this.browser.getAccount(address);
	    Logger.info("<<< getAccount() >>>");
	    Logger.info(response);

		Assert.assertNotNull(response);
		Assert.assertEquals(address, response.getAddress());
		
		Assert.assertNotNull(response.getBalance());
		Assert.assertNotNull(response.getNonce());
		Assert.assertNotNull(response.getPendingNonce());
	}
	
	@Test
	public void getChainMeta() {
		GetChainMetaResponse response = browser.getChainMeta();
	    Logger.info("<<< getChainMeta() >>>");
	    Logger.info(response);
		
		Assert.assertNotNull(response);
	}
}
