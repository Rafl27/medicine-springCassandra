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

private const val ASTRA_DB_ID = "28624d8c-f479-4478-8c65-5766b1858f54-1"
private const val ASTRA_DB_REGION = "us-east1"
private const val ASTRA_TOKEN = "AstraCS:JIpKsdAeqnZUHaHZIyLGrLPt:fa3d70874301826fc3abb0191cb553c08df1bcd4cef07474c8caa9ef3063febf"
private const val ASTRA_KEYSPACE = "medicine"
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