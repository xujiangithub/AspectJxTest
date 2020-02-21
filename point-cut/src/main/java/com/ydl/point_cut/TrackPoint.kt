package com.ydl.point_cut


class TrackPoint{

    constructor()

    companion object {
        val INSTANCE = TrackPoint()
    }

    private var callback: TrackPointCallback? = null

    fun initSDK(trackPointCallback: TrackPointCallback) {
        callback = trackPointCallback
    }

    fun onClickCallback(pageName: String, viewIdName: String) {
        callback?.onClickCallback(pageName, viewIdName)
    }

    fun onPageOpenCallback(pageName: String) {
        callback?.onPageOpenCallback(pageName)
    }

    fun onPageCloseCallback(pageName: String) {
        callback?.onPageCloseCallback(pageName)
    }

}