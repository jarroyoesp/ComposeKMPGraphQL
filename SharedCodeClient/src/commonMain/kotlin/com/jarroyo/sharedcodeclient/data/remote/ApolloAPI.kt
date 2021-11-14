package com.jarroyo.graphqlexample.data.remote

import android.util.Log
import arrow.core.Either
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.exception.ApolloException
import com.jarroyo.GetCharactersQuery
import com.jarroyo.sharedcodeclient.domain.model.CharacterUIModel
import kotlinx.coroutines.flow.single
import com.jarroyo.sharedcodeclient.domain.model.toUIModel

interface ApolloAPI {
    suspend fun getHomeData(): Either<Exception, List<CharacterUIModel>?>
}

internal class ApolloAPIImpl(private val apolloClient: ApolloClient): ApolloAPI {

    override suspend fun getHomeData(): Either<Exception, List<CharacterUIModel>?> {
        return try {
            val response = apolloClient.query(GetCharactersQuery()).execute().single()
             Either.Right(response.data?.characters?.toUIModel())
        } catch (e: ApolloException) {
            Either.Left(e)
        }
    }

}