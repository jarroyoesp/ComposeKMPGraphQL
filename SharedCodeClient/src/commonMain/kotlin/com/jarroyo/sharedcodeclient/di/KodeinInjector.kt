package com.jarroyo.sharedcodeclient.di

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response.Companion.builder
import com.apollographql.apollo.network.http.ApolloHttpNetworkTransport
import com.jarroyo.graphqlexample.data.remote.ApolloAPI
import com.jarroyo.graphqlexample.data.remote.ApolloAPIImpl
import com.jarroyo.sharedcodeclient.domain.repository.HomeRepository
import com.jarroyo.sharedcodeclient.domain.usecase.GetHomeDataUsecase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.kodein.di.*
import src.commonMain.kotlin.com.jarroyo.sharedcodeclient.data.remote.NetworkDataSource
import src.commonMain.kotlin.com.jarroyo.sharedcodeclient.data.remote.NetworkDataSourceImpl
import src.commonMain.kotlin.com.jarroyo.sharedcodeclient.data.repository.HomeRepositoryImpl


val KodeinInjector = DI {
    bind<CoroutineDispatcher>() with provider { Dispatchers.IO }

    /**
     * USECASES
     */
    bind<GetHomeDataUsecase>() with provider { GetHomeDataUsecase(instance()) }

    /**
     * REPOSITORIES
     */
    bind<HomeRepository>() with provider { HomeRepositoryImpl(instance(), instance()) }

    /**
     * NETWORK DATA SOURCE
     */
    bind<NetworkDataSource>() with provider { NetworkDataSourceImpl(instance()) }


    bind<ApolloClient>() with provider {
        ApolloClient(
            networkTransport = ApolloHttpNetworkTransport(
                serverUrl = "https://rickandmortyapi.com/graphql",
                headers = mapOf(
                    "Accept" to "application/json",
                    "Content-Type" to "application/json",
                )
            )
        )
    }

    bind<ApolloAPI>() with provider { ApolloAPIImpl(instance()) }

}

class Injector {
    val getHomeDataUsecase: GetHomeDataUsecase by KodeinInjector.instance()
}