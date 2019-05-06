package org.iotexproject.antenna.rpcmethod;

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
public class TestConstants {
	public static final String HOST = "api.testnet.iotex.one";
	public static final Integer PORT = 443;
	public static final Boolean SSL = Boolean.TRUE;

	// getAccount()
	public static final String ADDRESS = "io126xcrjhtp27end76ac9nmx6px2072c3vgz6suw";

	// getActionsByHash()
	public static final String ACTION_HASH = "6f63cf29d818e8242dc06250d2522e90ada3c5744424f1dcc73afc760d2ec1cf";

	// getReceiptByAction()
	public static final String RECEIPT_ACTION_HASH = "30475f77fb932cf9ea9259f04efc8c2a933062173ae0d4d90a2190b5c33e03a5";

	// getState()
	public static final String PROTOCOL_ID = "rewarding";
	public static final String METHOD_NAME = "UnclaimedBalance";
	public static final String ARGS_0 = "io1ph0u2psnd7muq5xv9623rmxdsxc4uapxhzpg02";
}
