package src.commonMain.kotlin.com.jarroyo.sharedcodeclient.data.remote

expect class NetworkSystem {
    fun isNetworkAvailable(): Boolean
}