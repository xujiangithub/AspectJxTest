package com.ydl.xjaspectjx

import android.app.Application
import android.util.Log
import com.ydl.point_cut.TrackPoint
import com.ydl.point_cut.TrackPointCallback

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        TrackPoint.INSTANCE.initSDK(object : TrackPointCallback {
            override fun onClickCallback(pageName: String, viewIdName: String) {
                Log.i("track-point", "onClickCallback($pageName,$viewIdName)")
            }

            override fun onPageOpenCallback(pageName: String) {
                Log.i("track-point", "onPageOpenCallback($pageName)")
           }

            override fun onPageCloseCallback(pageName: String) {
                Log.i("track-point", "onPageCloseCallback($pageName)")
            }
        })
    }
}