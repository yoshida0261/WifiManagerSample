package com.stah.wifimanagersample

import android.content.Context
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

        // こんな感じでサジェスチョンするらしい。
        // https://developer.android.com/guide/topics/connectivity/wifi-suggest?hl=ja

        val manager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager


    }
}
