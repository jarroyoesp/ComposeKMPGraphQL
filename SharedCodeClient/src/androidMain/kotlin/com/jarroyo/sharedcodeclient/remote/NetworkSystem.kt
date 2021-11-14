package src.commonMain.kotlin.com.jarroyo.sharedcodeclient.data.remote

import android.content.Context
import android.net.ConnectivityManager

actual class NetworkSystem(private val context: Context) {

    actual fun isNetworkAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
    }
}