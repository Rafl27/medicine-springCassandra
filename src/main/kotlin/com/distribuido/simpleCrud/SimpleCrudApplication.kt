package com.distribuido.simpleCrud

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import io.stargate.grpc.StargateBearerToken
import io.stargate.proto.StargateGrpc
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.concurrent.TimeUnit

@SpringBootApplication
class SimpleCrudApplication

private const val ASTRA_DB_ID = "1ff8beff-07ba-47fd-9134-82d047d66ecb-1"
private const val ASTRA_DB_REGION = "us-east1"
private const val ASTRA_TOKEN = "AstraCS:NRYlqlZoGUsQUkePzvucsSqo:c916d08ecb82ce619a9be619521c918b36280a980372a348d5ab2099a8f97e93"
private const val ASTRA_KEYSPACE = "remedio"
//fun main(args: Array<String>) {
//	runApplication<SimpleCrudApplication>(*args)
//}

fun main(args: Array<String>) {
	runApplication<SimpleCrudApplication>(*args)
//-------------------------------------
// 1. Initializing Connectivity
//-------------------------------------
	val channel = ManagedChannelBuilder
		.forAddress("$ASTRA_DB_ID-$ASTRA_DB_REGION.apps.astra.datastax.com", 443)
		.useTransportSecurity()
		.build()

	// blocking stub version
	val blockingStub = StargateGrpc.newBlockingStub(channel)
		.withDeadlineAfter(10, TimeUnit.SECONDS)
		.withCallCredentials(StargateBearerToken(ASTRA_TOKEN))

}