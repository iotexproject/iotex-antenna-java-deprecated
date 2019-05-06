# IOTEX ANTENNA JAVA

## Usage

Into this library it used blocking gRPC API. This means that at most **one** RPC can be in progress at a time from the client. 

So you must use singleton class **Client** 

The class syncronize the calls using a semaphore. Use this method to close the grpc connection:

```
  Client.getInstance(HOST, PORT) (http mode)
  or
  Client.getInstance(HOST, PORT, true) (https mode)
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
  Client.getInstance(HOST, PORT).getSuggestGasPrice()
```

### EstimateGasForAction

```
  Client.getInstance(HOST, PORT).estimateGasForAction(Action action)
```

### GetAccount

```
  Client.getInstance(HOST, PORT).getAccount(String address)
```

### GetActions

#### By Hash

```
  Client.getInstance(HOST, PORT).getActionsByHash(String hash, Boolean checkPending)
```


#### By Index

```
  Client.getInstance(HOST, PORT).getActionsByIndex(Long start, Long count)
```

#### By Block Hash

```
  Client.getInstance(HOST, PORT).getActionsByBlock(String hash, Long start, Long count)
```

#### By Address

```
  Client.getInstance(HOST, PORT).getActionsByAddress(String address)
```

#### (Unconfirmed) By Address

```
  Client.getInstance(HOST, PORT).getUnconfirmedActionsByAddress(String address, Long start, Long count)
```

### GetBlockMetas

#### By Index

```
  Client.getInstance(HOST, PORT).getBlockMetasByIndex(Long start, Long count)
```

#### By Hash

```
  Client.getInstance(HOST, PORT).getBlockMetasByHash(String hash)
```

### Meta info

#### GetChainMeta

```
  Client.getInstance(HOST, PORT).getChainMeta()
```

#### GetEpochMeta

```
  Client.getInstance(HOST, PORT).GetEpochMeta(Long epoch)
```

#### getServerMeta

```
  Client.getInstance(HOST, PORT).getServerMeta()
```

### getReceiptByAction

```
  Client.getInstance(HOST, PORT).getReceiptByAction(String hash)
```

### readContract

```
  Client.getInstance(HOST, PORT).readContract(Action action)
```

### sendAction

```
  Client.getInstance(HOST, PORT).sendAction(Action action)
```

### readState

```
  Client.getInstance(HOST, PORT).readState(String methodName, String protocolID, String... args)
```