/**
 * 
 */
package org.iotexproject.antenna.grpc;

import java.util.concurrent.CountDownLatch;

import org.iotexproject.antenna.grpc.iotexapi.APIServiceGrpc;
import org.iotexproject.antenna.grpc.iotexapi.APIServiceGrpc.APIServiceBlockingStub;
import org.iotexproject.antenna.grpc.iotexapi.APIServiceGrpc.APIServiceStub;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetAccountResponse;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaRequest;
import org.iotexproject.antenna.grpc.iotexapi.Api.GetChainMetaResponse;
import org.iotexproject.antenna.grpc.iotextypes.Blockchain.AccountMeta;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

/**
 * @author fabryprog
 *
 */
public class Browser {
	private final ManagedChannel channel;
	private final APIServiceBlockingStub blockingStub;
	private final APIServiceStub asyncStub;
	private AccountMeta result;
    
	public Browser(final String host, final Integer port) {
		this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
	}

	public Browser(ManagedChannelBuilder<?> channelBuilder) {
		channel = channelBuilder.build();
		blockingStub = APIServiceGrpc.newBlockingStub(channel);
		asyncStub = APIServiceGrpc.newStub(channel);
	}
	
	public GetChainMetaResponse getChainMeta() {
		GetChainMetaRequest req = GetChainMetaRequest.newBuilder().build();
	  	return blockingStub.getChainMeta(req);
	}
	
	public AccountMeta getAccount(String address) {
		GetAccountRequest req = GetAccountRequest.newBuilder().setAddress(address).build();
		result = null;
		final CountDownLatch finishLatch = new CountDownLatch(1);

		asyncStub.getAccount(req, new StreamObserver<GetAccountResponse>() {
	          public void onNext(GetAccountResponse note) {
	        	  System.out.println("response? " + note);
	        	  result = note.getAccountMeta();
	          }
	          public void onError(Throwable t) {
	        	  System.out.println("errore?" + t);
	        	  
	        	  //TODO
	            finishLatch.countDown();
	          }

	          public void onCompleted() {
	        	  //TODO
	        	  System.out.println("completed!");
	            finishLatch.countDown();
	          }
	        });
	    
        try {
			Thread.sleep(2000 + 500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return result;
	}
}

