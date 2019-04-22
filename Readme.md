# IOTEX ANTENNA JAVA

## Usage

Into this library it used blocking gRPC API. This means that at most **one** RPC can be in progress at a time from the client. 

So you must use singleton class **IoTeXDispatcher** 

**Do not use Browser class!!!**

```
  IoTeXDispatcher.getInstance(HOST, PORT)
```

The class syncronize the calls using a semaphore. Use this method to close the grpc connection:

```
  IoTeXDispatcher.getInstance(HOST, PORT).close()
```

## Generate JAR (using maven)

```
mvn clean package
```

## Run Integration Test (using maven)

```
mvn clean test
```

## GRPC Methods

### SuggestGasPrice

```
  IoTeXDispatcher.getInstance(HOST, PORT).getSuggestGasPrice()
```

### EstimateGasForAction

```
  IoTeXDispatcher.getInstance(HOST, PORT).estimateGasForAction(Action action)
```

### GetAccount

```
  IoTeXDispatcher.getInstance(HOST, PORT).getAccount(String address)
```

### GetActions

#### By Hash

```
  IoTeXDispatcher.getInstance(HOST, PORT).getActionsByHash(String hash, Boolean checkPending)
```


#### By Index

```
  IoTeXDispatcher.getInstance(HOST, PORT).getActionsByIndex(Long start, Long count)
```


#### By Block Hash

```
  IoTeXDispatcher.getInstance(HOST, PORT).getActionsByBlock(String hash, Long start, Long count)
```

### GetBlockMetas

#### By Index

```
  IoTeXDispatcher.getInstance(HOST, PORT).getBlockMetasByIndex(Long start, Long count)
```

#### By Hash

```
  IoTeXDispatcher.getInstance(HOST, PORT).getBlockMetasByHash(String hash)
```

### GetChainMeta

```
  IoTeXDispatcher.getInstance(HOST, PORT).getChainMeta()
```

### GetEpochMeta

```
  IoTeXDispatcher.getInstance(HOST, PORT).GetEpochMeta(Long epoch)
```

### getServerMeta

```
  IoTeXDispatcher.getInstance(HOST, PORT).getServerMeta()
```

## TODO

* iotexapi.APIService.EstimateGasForAction (TODO test)
* iotexapi.APIService.GetReceiptByAction (TODO test)
* iotexapi.APIService.ReadContract (TODO test)
* iotexapi.APIService.ReadState (TODO)
* iotexapi.APIService.SendAction (TODO)
