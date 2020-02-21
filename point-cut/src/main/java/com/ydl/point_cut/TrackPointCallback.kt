package com.ydl.point_cut

public interface TrackPointCallback {

    fun onClickCallback(pageName: String, viewIdName: String) //点击回调

    fun onPageOpenCallback(pageName: String) //页面打开回调

    fun onPageCloseCallback(pageName: String) // 页面关闭回调
}