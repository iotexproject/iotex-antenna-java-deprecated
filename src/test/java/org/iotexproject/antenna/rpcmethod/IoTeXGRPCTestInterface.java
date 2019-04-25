package org.iotexproject.antenna.rpcmethod;

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

//	TODO
//	RpcMethod enableSsl
//	RpcMethod.getActionsByAddress
//	RpcMethod.getUnconfirmedActionsByAddress
//	RpcMethod.getActionsByBlock
//	RpcMethod.getReceiptByAction
//	RpcMethod.sendAction
//	RpcMethod.readState
//	RpcMethod.getDeadline

}
