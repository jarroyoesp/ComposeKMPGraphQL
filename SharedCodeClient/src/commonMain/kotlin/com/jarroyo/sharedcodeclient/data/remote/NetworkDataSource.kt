package src.commonMain.kotlin.com.jarroyo.sharedcodeclient.data.remote

import android.accounts.NetworkErrorException
import android.util.Log
import arrow.core.Either
import com.jarroyo.graphqlexample.data.remote.ApolloAPI
import com.jarroyo.sharedcodeclient.domain.model.CharacterUIModel

interface NetworkDataSource {
    suspend fun getHomeData(): Either<Exception, List<CharacterUIModel>?>
}

class NetworkDataSourceImpl(private val apolloAPI: ApolloAPI,
    /*private val networkSystem: NetworkSystem*/
) : NetworkDataSource {

    companion object {
        private val TAG = NetworkDataSourceImpl::class.java.simpleName
    }

    override suspend fun getHomeData(): Either<Exception, List<CharacterUIModel>?> {
        return try {
            apolloAPI.getHomeData()
        } catch (e: Exception) {
            Either.Left(NetworkErrorException())
        }
    }
}