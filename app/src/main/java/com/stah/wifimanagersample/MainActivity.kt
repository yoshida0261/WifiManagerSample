package com.stah.wifimanagersample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiConfiguration
import android.net.wifi.WifiManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // firebaseから値を取得


        // wifiチェック

        // offならOnにする。

        // フライトモードでも大丈夫だったはず(要確認

        // だめならdialogを出す

        // 接続スタート

        // こんな感じでサジェスチョンするらしい。(android 10 から）
        // https://developer.android.com/guide/topics/connectivity/wifi-suggest?hl=ja

        // versionごとの切り分けが必要そう￥・・・ひぇ、メンドクサ

        /*
        val suggestion1 = WifiNetworkSuggestion.
            .setSsid("test111111")
            .setIsAppInteractionRequired() // Optional (Needs location permission)
            .build()


         */


        // val suggestionsList = listOf(suggestion1)


        val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        println("wifi ${wifiManager.isWifiEnabled}")

        val config = WifiConfiguration()
        val status = wifiManager.addNetwork(config)
        if (status != WifiManager.STATUS_NETWORK_SUGGESTIONS_SUCCESS) {
            // do error handling here
            println(status)
            wifiManager.setWifiEnabled(true)
        }


// Optional (Wait for post connection broadcast to one of your suggestions)
        val intentFilter = IntentFilter(WifiManager.ACTION_WIFI_NETWORK_SUGGESTION_POST_CONNECTION);

        val broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                if (!intent.action.equals(WifiManager.ACTION_WIFI_NETWORK_SUGGESTION_POST_CONNECTION)) {
                    return;
                }
                // do post connect processing here
            }
        };
        applicationContext.registerReceiver(broadcastReceiver, intentFilter);


    }
}
