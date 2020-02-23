package com.stah.wifimanagersample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.net.wifi.WifiNetworkSuggestion
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        println("wifi ${wifiManager.isWifiEnabled}")
        if(wifiManager.isWifiEnabled.not()){
            Snackbar.make(main, "Wi-Fi is disable!!", Snackbar.LENGTH_SHORT).show()
            return
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            suggestWifiNetwork(wifiManager)
        } else {
            TODO("VERSION.SDK_INT < Q")
        }
    }


    @RequiresApi(Build.VERSION_CODES.Q)
    fun suggestWifiNetwork(wifiManager:WifiManager){
        val suggestion1 =
            WifiNetworkSuggestion.Builder()
                .setSsid("stah")
                .setWpa2Passphrase("yoshida100314")
                //.setIsAppInteractionRequired() // Optional (Needs location permission)
                .build()


        val suggestionList = listOf(suggestion1)
        val status = wifiManager.addNetworkSuggestions(suggestionList)

        println("addNetworkSuggestion result $status")

    }
}
