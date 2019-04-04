package org.iotexproject.antenna.grpc.iotexapi;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.19.0)",
    comments = "Source: api.proto")
public final class APIServiceGrpc {

  private APIServiceGrpc() {}

  public static final String SERVICE_NAME = "iotexapi.APIService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountRequest,
      org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountResponse> getGetAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccount",
      requestType = org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountRequest.class,
      responseType = org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountRequest,
      org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountResponse> getGetAccountMethod() {
    io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountRequest, org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountResponse> getGetAccountMethod;
    if ((getGetAccountMethod = APIServiceGrpc.getGetAccountMethod) == null) {
      synchronized (APIServiceGrpc.class) {
        if ((getGetAccountMethod = APIServiceGrpc.getGetAccountMethod) == null) {
          APIServiceGrpc.getGetAccountMethod = getGetAccountMethod = 
              io.grpc.MethodDescriptor.<org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountRequest, org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "iotexapi.APIService", "GetAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new APIServiceMethodDescriptorSupplier("GetAccount"))
                  .build();
          }
        }
     }
     return getGetAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsRequest,
      org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsResponse> getGetActionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetActions",
      requestType = org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsRequest.class,
      responseType = org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsRequest,
      org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsResponse> getGetActionsMethod() {
    io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsRequest, org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsResponse> getGetActionsMethod;
    if ((getGetActionsMethod = APIServiceGrpc.getGetActionsMethod) == null) {
      synchronized (APIServiceGrpc.class) {
        if ((getGetActionsMethod = APIServiceGrpc.getGetActionsMethod) == null) {
          APIServiceGrpc.getGetActionsMethod = getGetActionsMethod = 
              io.grpc.MethodDescriptor.<org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsRequest, org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "iotexapi.APIService", "GetActions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new APIServiceMethodDescriptorSupplier("GetActions"))
                  .build();
          }
        }
     }
     return getGetActionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasRequest,
      org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasResponse> getGetBlockMetasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBlockMetas",
      requestType = org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasRequest.class,
      responseType = org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasRequest,
      org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasResponse> getGetBlockMetasMethod() {
    io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasRequest, org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasResponse> getGetBlockMetasMethod;
    if ((getGetBlockMetasMethod = APIServiceGrpc.getGetBlockMetasMethod) == null) {
      synchronized (APIServiceGrpc.class) {
        if ((getGetBlockMetasMethod = APIServiceGrpc.getGetBlockMetasMethod) == null) {
          APIServiceGrpc.getGetBlockMetasMethod = getGetBlockMetasMethod = 
              io.grpc.MethodDescriptor.<org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasRequest, org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "iotexapi.APIService", "GetBlockMetas"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new APIServiceMethodDescriptorSupplier("GetBlockMetas"))
                  .build();
          }
        }
     }
     return getGetBlockMetasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaRequest,
      org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaResponse> getGetChainMetaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetChainMeta",
      requestType = org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaRequest.class,
      responseType = org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaRequest,
      org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaResponse> getGetChainMetaMethod() {
    io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaRequest, org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaResponse> getGetChainMetaMethod;
    if ((getGetChainMetaMethod = APIServiceGrpc.getGetChainMetaMethod) == null) {
      synchronized (APIServiceGrpc.class) {
        if ((getGetChainMetaMethod = APIServiceGrpc.getGetChainMetaMethod) == null) {
          APIServiceGrpc.getGetChainMetaMethod = getGetChainMetaMethod = 
              io.grpc.MethodDescriptor.<org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaRequest, org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "iotexapi.APIService", "GetChainMeta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new APIServiceMethodDescriptorSupplier("GetChainMeta"))
                  .build();
          }
        }
     }
     return getGetChainMetaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaRequest,
      org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaResponse> getGetServerMetaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetServerMeta",
      requestType = org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaRequest.class,
      responseType = org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaRequest,
      org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaResponse> getGetServerMetaMethod() {
    io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaRequest, org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaResponse> getGetServerMetaMethod;
    if ((getGetServerMetaMethod = APIServiceGrpc.getGetServerMetaMethod) == null) {
      synchronized (APIServiceGrpc.class) {
        if ((getGetServerMetaMethod = APIServiceGrpc.getGetServerMetaMethod) == null) {
          APIServiceGrpc.getGetServerMetaMethod = getGetServerMetaMethod = 
              io.grpc.MethodDescriptor.<org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaRequest, org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "iotexapi.APIService", "GetServerMeta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new APIServiceMethodDescriptorSupplier("GetServerMeta"))
                  .build();
          }
        }
     }
     return getGetServerMetaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.SendActionRequest,
      org.iotexproject.antenna.grpc.iotexapi.Api.SendActionResponse> getSendActionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendAction",
      requestType = org.iotexproject.antenna.grpc.iotexapi.Api.SendActionRequest.class,
      responseType = org.iotexproject.antenna.grpc.iotexapi.Api.SendActionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.SendActionRequest,
      org.iotexproject.antenna.grpc.iotexapi.Api.SendActionResponse> getSendActionMethod() {
    io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.SendActionRequest, org.iotexproject.antenna.grpc.iotexapi.Api.SendActionResponse> getSendActionMethod;
    if ((getSendActionMethod = APIServiceGrpc.getSendActionMethod) == null) {
      synchronized (APIServiceGrpc.class) {
        if ((getSendActionMethod = APIServiceGrpc.getSendActionMethod) == null) {
          APIServiceGrpc.getSendActionMethod = getSendActionMethod = 
              io.grpc.MethodDescriptor.<org.iotexproject.antenna.grpc.iotexapi.Api.SendActionRequest, org.iotexproject.antenna.grpc.iotexapi.Api.SendActionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "iotexapi.APIService", "SendAction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.iotexproject.antenna.grpc.iotexapi.Api.SendActionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.iotexproject.antenna.grpc.iotexapi.Api.SendActionResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new APIServiceMethodDescriptorSupplier("SendAction"))
                  .build();
          }
        }
     }
     return getSendActionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionRequest,
      org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionResponse> getGetReceiptByActionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReceiptByAction",
      requestType = org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionRequest.class,
      responseType = org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionRequest,
      org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionResponse> getGetReceiptByActionMethod() {
    io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionRequest, org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionResponse> getGetReceiptByActionMethod;
    if ((getGetReceiptByActionMethod = APIServiceGrpc.getGetReceiptByActionMethod) == null) {
      synchronized (APIServiceGrpc.class) {
        if ((getGetReceiptByActionMethod = APIServiceGrpc.getGetReceiptByActionMethod) == null) {
          APIServiceGrpc.getGetReceiptByActionMethod = getGetReceiptByActionMethod = 
              io.grpc.MethodDescriptor.<org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionRequest, org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "iotexapi.APIService", "GetReceiptByAction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new APIServiceMethodDescriptorSupplier("GetReceiptByAction"))
                  .build();
          }
        }
     }
     return getGetReceiptByActionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractRequest,
      org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractResponse> getReadContractMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadContract",
      requestType = org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractRequest.class,
      responseType = org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractRequest,
      org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractResponse> getReadContractMethod() {
    io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractRequest, org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractResponse> getReadContractMethod;
    if ((getReadContractMethod = APIServiceGrpc.getReadContractMethod) == null) {
      synchronized (APIServiceGrpc.class) {
        if ((getReadContractMethod = APIServiceGrpc.getReadContractMethod) == null) {
          APIServiceGrpc.getReadContractMethod = getReadContractMethod = 
              io.grpc.MethodDescriptor.<org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractRequest, org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "iotexapi.APIService", "ReadContract"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new APIServiceMethodDescriptorSupplier("ReadContract"))
                  .build();
          }
        }
     }
     return getReadContractMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceRequest,
      org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceResponse> getSuggestGasPriceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SuggestGasPrice",
      requestType = org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceRequest.class,
      responseType = org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceRequest,
      org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceResponse> getSuggestGasPriceMethod() {
    io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceRequest, org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceResponse> getSuggestGasPriceMethod;
    if ((getSuggestGasPriceMethod = APIServiceGrpc.getSuggestGasPriceMethod) == null) {
      synchronized (APIServiceGrpc.class) {
        if ((getSuggestGasPriceMethod = APIServiceGrpc.getSuggestGasPriceMethod) == null) {
          APIServiceGrpc.getSuggestGasPriceMethod = getSuggestGasPriceMethod = 
              io.grpc.MethodDescriptor.<org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceRequest, org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "iotexapi.APIService", "SuggestGasPrice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new APIServiceMethodDescriptorSupplier("SuggestGasPrice"))
                  .build();
          }
        }
     }
     return getSuggestGasPriceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionRequest,
      org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionResponse> getEstimateGasForActionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EstimateGasForAction",
      requestType = org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionRequest.class,
      responseType = org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionRequest,
      org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionResponse> getEstimateGasForActionMethod() {
    io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionRequest, org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionResponse> getEstimateGasForActionMethod;
    if ((getEstimateGasForActionMethod = APIServiceGrpc.getEstimateGasForActionMethod) == null) {
      synchronized (APIServiceGrpc.class) {
        if ((getEstimateGasForActionMethod = APIServiceGrpc.getEstimateGasForActionMethod) == null) {
          APIServiceGrpc.getEstimateGasForActionMethod = getEstimateGasForActionMethod = 
              io.grpc.MethodDescriptor.<org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionRequest, org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "iotexapi.APIService", "EstimateGasForAction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new APIServiceMethodDescriptorSupplier("EstimateGasForAction"))
                  .build();
          }
        }
     }
     return getEstimateGasForActionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateRequest,
      org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateResponse> getReadStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadState",
      requestType = org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateRequest.class,
      responseType = org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateRequest,
      org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateResponse> getReadStateMethod() {
    io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateRequest, org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateResponse> getReadStateMethod;
    if ((getReadStateMethod = APIServiceGrpc.getReadStateMethod) == null) {
      synchronized (APIServiceGrpc.class) {
        if ((getReadStateMethod = APIServiceGrpc.getReadStateMethod) == null) {
          APIServiceGrpc.getReadStateMethod = getReadStateMethod = 
              io.grpc.MethodDescriptor.<org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateRequest, org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "iotexapi.APIService", "ReadState"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new APIServiceMethodDescriptorSupplier("ReadState"))
                  .build();
          }
        }
     }
     return getReadStateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaRequest,
      org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaResponse> getGetEpochMetaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEpochMeta",
      requestType = org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaRequest.class,
      responseType = org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaRequest,
      org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaResponse> getGetEpochMetaMethod() {
    io.grpc.MethodDescriptor<org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaRequest, org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaResponse> getGetEpochMetaMethod;
    if ((getGetEpochMetaMethod = APIServiceGrpc.getGetEpochMetaMethod) == null) {
      synchronized (APIServiceGrpc.class) {
        if ((getGetEpochMetaMethod = APIServiceGrpc.getGetEpochMetaMethod) == null) {
          APIServiceGrpc.getGetEpochMetaMethod = getGetEpochMetaMethod = 
              io.grpc.MethodDescriptor.<org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaRequest, org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "iotexapi.APIService", "GetEpochMeta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new APIServiceMethodDescriptorSupplier("GetEpochMeta"))
                  .build();
          }
        }
     }
     return getGetEpochMetaMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static APIServiceStub newStub(io.grpc.Channel channel) {
    return new APIServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static APIServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new APIServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static APIServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new APIServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class APIServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * get the address detail of an address
     * </pre>
     */
    public void getAccount(org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountRequest request,
        io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAccountMethod(), responseObserver);
    }

    /**
     * <pre>
     * get action(s) by:
     * 1. start index and action count
     * 2. action hash
     * 3. address with start index and action count
     * 4. get unconfirmed actions by address with start index and action count
     * 5. block hash with start index and action count
     * </pre>
     */
    public void getActions(org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsRequest request,
        io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetActionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * get block metadata(s) by:
     * 1. start index and block count
     * 2. block hash
     * </pre>
     */
    public void getBlockMetas(org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasRequest request,
        io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBlockMetasMethod(), responseObserver);
    }

    /**
     * <pre>
     * get chain metadata
     * </pre>
     */
    public void getChainMeta(org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaRequest request,
        io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetChainMetaMethod(), responseObserver);
    }

    /**
     * <pre>
     * get server version
     * </pre>
     */
    public void getServerMeta(org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaRequest request,
        io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetServerMetaMethod(), responseObserver);
    }

    /**
     * <pre>
     * sendAction
     * </pre>
     */
    public void sendAction(org.iotexproject.antenna.grpc.iotexapi.Api.SendActionRequest request,
        io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.SendActionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendActionMethod(), responseObserver);
    }

    /**
     * <pre>
     * get receipt by action Hash
     * </pre>
     */
    public void getReceiptByAction(org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionRequest request,
        io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetReceiptByActionMethod(), responseObserver);
    }

    /**
     * <pre>
     * TODO: read contract
     * </pre>
     */
    public void readContract(org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractRequest request,
        io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getReadContractMethod(), responseObserver);
    }

    /**
     * <pre>
     * suggest gas price
     * </pre>
     */
    public void suggestGasPrice(org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceRequest request,
        io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSuggestGasPriceMethod(), responseObserver);
    }

    /**
     * <pre>
     * estimate gas for action
     * </pre>
     */
    public void estimateGasForAction(org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionRequest request,
        io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getEstimateGasForActionMethod(), responseObserver);
    }

    /**
     * <pre>
     * read state from blockchain
     * </pre>
     */
    public void readState(org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateRequest request,
        io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getReadStateMethod(), responseObserver);
    }

    /**
     * <pre>
     * get epoch metadata
     * </pre>
     */
    public void getEpochMeta(org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaRequest request,
        io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetEpochMetaMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAccountMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountRequest,
                org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountResponse>(
                  this, METHODID_GET_ACCOUNT)))
          .addMethod(
            getGetActionsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsRequest,
                org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsResponse>(
                  this, METHODID_GET_ACTIONS)))
          .addMethod(
            getGetBlockMetasMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasRequest,
                org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasResponse>(
                  this, METHODID_GET_BLOCK_METAS)))
          .addMethod(
            getGetChainMetaMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaRequest,
                org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaResponse>(
                  this, METHODID_GET_CHAIN_META)))
          .addMethod(
            getGetServerMetaMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaRequest,
                org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaResponse>(
                  this, METHODID_GET_SERVER_META)))
          .addMethod(
            getSendActionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.iotexproject.antenna.grpc.iotexapi.Api.SendActionRequest,
                org.iotexproject.antenna.grpc.iotexapi.Api.SendActionResponse>(
                  this, METHODID_SEND_ACTION)))
          .addMethod(
            getGetReceiptByActionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionRequest,
                org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionResponse>(
                  this, METHODID_GET_RECEIPT_BY_ACTION)))
          .addMethod(
            getReadContractMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractRequest,
                org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractResponse>(
                  this, METHODID_READ_CONTRACT)))
          .addMethod(
            getSuggestGasPriceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceRequest,
                org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceResponse>(
                  this, METHODID_SUGGEST_GAS_PRICE)))
          .addMethod(
            getEstimateGasForActionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionRequest,
                org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionResponse>(
                  this, METHODID_ESTIMATE_GAS_FOR_ACTION)))
          .addMethod(
            getReadStateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateRequest,
                org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateResponse>(
                  this, METHODID_READ_STATE)))
          .addMethod(
            getGetEpochMetaMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaRequest,
                org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaResponse>(
                  this, METHODID_GET_EPOCH_META)))
          .build();
    }
  }

  /**
   */
  public static final class APIServiceStub extends io.grpc.stub.AbstractStub<APIServiceStub> {
    private APIServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private APIServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected APIServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new APIServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * get the address detail of an address
     * </pre>
     */
    public void getAccount(org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountRequest request,
        io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * get action(s) by:
     * 1. start index and action count
     * 2. action hash
     * 3. address with start index and action count
     * 4. get unconfirmed actions by address with start index and action count
     * 5. block hash with start index and action count
     * </pre>
     */
    public void getActions(org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsRequest request,
        io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetActionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * get block metadata(s) by:
     * 1. start index and block count
     * 2. block hash
     * </pre>
     */
    public void getBlockMetas(org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasRequest request,
        io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBlockMetasMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * get chain metadata
     * </pre>
     */
    public void getChainMeta(org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaRequest request,
        io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetChainMetaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * get server version
     * </pre>
     */
    public void getServerMeta(org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaRequest request,
        io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetServerMetaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * sendAction
     * </pre>
     */
    public void sendAction(org.iotexproject.antenna.grpc.iotexapi.Api.SendActionRequest request,
        io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.SendActionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendActionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * get receipt by action Hash
     * </pre>
     */
    public void getReceiptByAction(org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionRequest request,
        io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetReceiptByActionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * TODO: read contract
     * </pre>
     */
    public void readContract(org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractRequest request,
        io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadContractMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * suggest gas price
     * </pre>
     */
    public void suggestGasPrice(org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceRequest request,
        io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSuggestGasPriceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * estimate gas for action
     * </pre>
     */
    public void estimateGasForAction(org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionRequest request,
        io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEstimateGasForActionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * read state from blockchain
     * </pre>
     */
    public void readState(org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateRequest request,
        io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadStateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * get epoch metadata
     * </pre>
     */
    public void getEpochMeta(org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaRequest request,
        io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetEpochMetaMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class APIServiceBlockingStub extends io.grpc.stub.AbstractStub<APIServiceBlockingStub> {
    private APIServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private APIServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected APIServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new APIServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * get the address detail of an address
     * </pre>
     */
    public org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountResponse getAccount(org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAccountMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * get action(s) by:
     * 1. start index and action count
     * 2. action hash
     * 3. address with start index and action count
     * 4. get unconfirmed actions by address with start index and action count
     * 5. block hash with start index and action count
     * </pre>
     */
    public org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsResponse getActions(org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetActionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * get block metadata(s) by:
     * 1. start index and block count
     * 2. block hash
     * </pre>
     */
    public org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasResponse getBlockMetas(org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetBlockMetasMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * get chain metadata
     * </pre>
     */
    public org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaResponse getChainMeta(org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetChainMetaMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * get server version
     * </pre>
     */
    public org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaResponse getServerMeta(org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetServerMetaMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * sendAction
     * </pre>
     */
    public org.iotexproject.antenna.grpc.iotexapi.Api.SendActionResponse sendAction(org.iotexproject.antenna.grpc.iotexapi.Api.SendActionRequest request) {
      return blockingUnaryCall(
          getChannel(), getSendActionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * get receipt by action Hash
     * </pre>
     */
    public org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionResponse getReceiptByAction(org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetReceiptByActionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * TODO: read contract
     * </pre>
     */
    public org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractResponse readContract(org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadContractMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * suggest gas price
     * </pre>
     */
    public org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceResponse suggestGasPrice(org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceRequest request) {
      return blockingUnaryCall(
          getChannel(), getSuggestGasPriceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * estimate gas for action
     * </pre>
     */
    public org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionResponse estimateGasForAction(org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionRequest request) {
      return blockingUnaryCall(
          getChannel(), getEstimateGasForActionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * read state from blockchain
     * </pre>
     */
    public org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateResponse readState(org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadStateMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * get epoch metadata
     * </pre>
     */
    public org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaResponse getEpochMeta(org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetEpochMetaMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class APIServiceFutureStub extends io.grpc.stub.AbstractStub<APIServiceFutureStub> {
    private APIServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private APIServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected APIServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new APIServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * get the address detail of an address
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountResponse> getAccount(
        org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAccountMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * get action(s) by:
     * 1. start index and action count
     * 2. action hash
     * 3. address with start index and action count
     * 4. get unconfirmed actions by address with start index and action count
     * 5. block hash with start index and action count
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsResponse> getActions(
        org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetActionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * get block metadata(s) by:
     * 1. start index and block count
     * 2. block hash
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasResponse> getBlockMetas(
        org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBlockMetasMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * get chain metadata
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaResponse> getChainMeta(
        org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetChainMetaMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * get server version
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaResponse> getServerMeta(
        org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetServerMetaMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * sendAction
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.iotexproject.antenna.grpc.iotexapi.Api.SendActionResponse> sendAction(
        org.iotexproject.antenna.grpc.iotexapi.Api.SendActionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSendActionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * get receipt by action Hash
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionResponse> getReceiptByAction(
        org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetReceiptByActionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * TODO: read contract
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractResponse> readContract(
        org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadContractMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * suggest gas price
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceResponse> suggestGasPrice(
        org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSuggestGasPriceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * estimate gas for action
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionResponse> estimateGasForAction(
        org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getEstimateGasForActionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * read state from blockchain
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateResponse> readState(
        org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadStateMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * get epoch metadata
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaResponse> getEpochMeta(
        org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetEpochMetaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ACCOUNT = 0;
  private static final int METHODID_GET_ACTIONS = 1;
  private static final int METHODID_GET_BLOCK_METAS = 2;
  private static final int METHODID_GET_CHAIN_META = 3;
  private static final int METHODID_GET_SERVER_META = 4;
  private static final int METHODID_SEND_ACTION = 5;
  private static final int METHODID_GET_RECEIPT_BY_ACTION = 6;
  private static final int METHODID_READ_CONTRACT = 7;
  private static final int METHODID_SUGGEST_GAS_PRICE = 8;
  private static final int METHODID_ESTIMATE_GAS_FOR_ACTION = 9;
  private static final int METHODID_READ_STATE = 10;
  private static final int METHODID_GET_EPOCH_META = 11;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final APIServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(APIServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ACCOUNT:
          serviceImpl.getAccount((org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountRequest) request,
              (io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountResponse>) responseObserver);
          break;
        case METHODID_GET_ACTIONS:
          serviceImpl.getActions((org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsRequest) request,
              (io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.GetActionsResponse>) responseObserver);
          break;
        case METHODID_GET_BLOCK_METAS:
          serviceImpl.getBlockMetas((org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasRequest) request,
              (io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.GetBlockMetasResponse>) responseObserver);
          break;
        case METHODID_GET_CHAIN_META:
          serviceImpl.getChainMeta((org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaRequest) request,
              (io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaResponse>) responseObserver);
          break;
        case METHODID_GET_SERVER_META:
          serviceImpl.getServerMeta((org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaRequest) request,
              (io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.GetServerMetaResponse>) responseObserver);
          break;
        case METHODID_SEND_ACTION:
          serviceImpl.sendAction((org.iotexproject.antenna.grpc.iotexapi.Api.SendActionRequest) request,
              (io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.SendActionResponse>) responseObserver);
          break;
        case METHODID_GET_RECEIPT_BY_ACTION:
          serviceImpl.getReceiptByAction((org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionRequest) request,
              (io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.GetReceiptByActionResponse>) responseObserver);
          break;
        case METHODID_READ_CONTRACT:
          serviceImpl.readContract((org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractRequest) request,
              (io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.ReadContractResponse>) responseObserver);
          break;
        case METHODID_SUGGEST_GAS_PRICE:
          serviceImpl.suggestGasPrice((org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceRequest) request,
              (io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.SuggestGasPriceResponse>) responseObserver);
          break;
        case METHODID_ESTIMATE_GAS_FOR_ACTION:
          serviceImpl.estimateGasForAction((org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionRequest) request,
              (io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.EstimateGasForActionResponse>) responseObserver);
          break;
        case METHODID_READ_STATE:
          serviceImpl.readState((org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateRequest) request,
              (io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.ReadStateResponse>) responseObserver);
          break;
        case METHODID_GET_EPOCH_META:
          serviceImpl.getEpochMeta((org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaRequest) request,
              (io.grpc.stub.StreamObserver<org.iotexproject.antenna.grpc.iotexapi.Api.GetEpochMetaResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class APIServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    APIServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.iotexproject.antenna.grpc.iotexapi.Api.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("APIService");
    }
  }

  private static final class APIServiceFileDescriptorSupplier
      extends APIServiceBaseDescriptorSupplier {
    APIServiceFileDescriptorSupplier() {}
  }

  private static final class APIServiceMethodDescriptorSupplier
      extends APIServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    APIServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (APIServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new APIServiceFileDescriptorSupplier())
              .addMethod(getGetAccountMethod())
              .addMethod(getGetActionsMethod())
              .addMethod(getGetBlockMetasMethod())
              .addMethod(getGetChainMetaMethod())
              .addMethod(getGetServerMetaMethod())
              .addMethod(getSendActionMethod())
              .addMethod(getGetReceiptByActionMethod())
              .addMethod(getReadContractMethod())
              .addMethod(getSuggestGasPriceMethod())
              .addMethod(getEstimateGasForActionMethod())
              .addMethod(getReadStateMethod())
              .addMethod(getGetEpochMetaMethod())
              .build();
        }
      }
    }
    return result;
  }
}
