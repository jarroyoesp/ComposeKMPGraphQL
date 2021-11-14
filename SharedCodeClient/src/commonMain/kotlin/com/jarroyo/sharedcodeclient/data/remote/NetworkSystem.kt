package src.commonMain.kotlin.com.jarroyo.sharedcodeclient.data.remote

abstract class NetworkSystem {
    abstract fun isNetworkAvailable(): Boolean
}