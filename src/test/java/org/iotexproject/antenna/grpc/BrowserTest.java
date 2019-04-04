/**
 * 
 */
package org.iotexproject.antenna.grpc;

import org.iotexproject.antenna.grpc.iotextypes.Blockchain.AccountMeta;
import org.junit.Test;

/**
 * @author fabryprog
 *
 */

public class BrowserTest {
	@Test
	public void getAccount() {
		AccountMeta response = new Browser("api.iotex.one", 80).getAccount("io126xcrjhtp27end76ac9nmx6px2072c3vgz6suw");
		System.out.println("response" + response);
	}
	
	public void getChainMeta() {
		new Browser("api.iotex.one", 80).getChainMeta();

	}
//		  const client = new RpcMethod('http://35.230.103.170:10000');
//		  const resp = await client.getAccount({address: 'io126xcrjhtp27end76ac9nmx6px2072c3vgz6suw'}, {});
//		  t.deepEqual(resp, {
//		    accountMeta: {
//		      address: 'io126xcrjhtp27end76ac9nmx6px2072c3vgz6suw',
//		      balance: '0',
//		      nonce: 0,
//		      pendingNonce: 1,
//		    },
//		  });
//		});
}
