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
public interface IoTeXGRPCTestInterface {
	public void getAccount();

	public void getChainMeta();

	public void getServerMeta();

	public void GetEpochMeta();

	public void getBlockMetasByIndexLenghtOne();

	public void getBlockMetasByIndexLenghtTen();

	public void getBlockMetasByIndexLenghtZero();

	public void getBlockMetasByHash();

	public void getActionsByIndexOne();

	public void getActionsByIndexTen();

	public void getActionsByIndexZero();

	public void getActionsByHash();

	public void getActionsByBlockHash();

	public void getSuggestGasPrice();

	public void readContract();

	public void estimateGasForAction();

	public void readState();

	public void sendAction();
}
