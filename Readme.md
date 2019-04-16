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

## Run Integration Test (using maven)

```
mvn clean test
```

## GRPC Method (Working Progress)

* iotexapi.APIService.EstimateGasForAction (TODO test)
* iotexapi.APIService.GetAccount
* iotexapi.APIService.GetActions (hash, idx and blockhash)
* iotexapi.APIService.GetBlockMetas
* iotexapi.APIService.GetChainMeta
* iotexapi.APIService.GetEpochMeta
* iotexapi.APIService.GetReceiptByAction (TODO test)
* iotexapi.APIService.GetServerMeta
* iotexapi.APIService.ReadContract (TODO test)
* iotexapi.APIService.ReadState (TODO)
* iotexapi.APIService.SendAction (TODO)
* iotexapi.APIService.SuggestGasPrice
