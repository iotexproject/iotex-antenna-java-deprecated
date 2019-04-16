# IOTEX ANTENNA JAVA

## Usage

Into this library it used blocking gRPC API. This means that at most **one** RPC can be in progress at a time from the client. 

So you must use singleton class **IoTeXDispatcher** 

**Do not use Browser class!!!**

```
  IoTeXDispatcher.getInstance(HOST, PORT)
```

## Generate JAR (using maven)

```
mvn clean package
```

## GRPC Method (Working Progress)

* iotexapi.APIService.EstimateGasForAction (wip)
* iotexapi.APIService.GetAccount
* iotexapi.APIService.GetActions (hash, idx and blockhash)
* iotexapi.APIService.GetBlockMetas
* iotexapi.APIService.GetChainMeta
* iotexapi.APIService.GetEpochMeta
* iotexapi.APIService.GetReceiptByAction (wip)
* iotexapi.APIService.GetServerMeta
* iotexapi.APIService.ReadContract (wip)
* iotexapi.APIService.ReadState (wip)
* iotexapi.APIService.SendAction (wip)
* iotexapi.APIService.SuggestGasPrice
