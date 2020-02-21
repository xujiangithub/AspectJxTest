package com.ydl.point_cut

import android.view.View
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut


@Aspect
public class TrackPointAspectJx {

    @Pointcut("execution(* onClick(..))")
    fun onClickPointCut() {}

    @Pointcut("execution(* android.support.v7.app.AppCompatActivity.onCreate(..))")
    fun onPageOpenPointCut() {}

    @Around("onClickPointCut()")
    fun aroundJoinOnClickPointCut(joinPoint: ProceedingJoinPoint) {
        val target: Any = joinPoint.target
        val className = target.javaClass.name
        var viewIdName = ""
        //获取点击事件view对象及名称，可以对不同按钮的点击事件进行统计
        val args = joinPoint.args
        if (args.isNotEmpty() && args[0] is View) {
            val view = args[0] as View
            val id = view.id
            val entryName = view.resources.getResourceEntryName(id)
            TrackPoint.INSTANCE.onClickCallback(className, entryName)
        }
        joinPoint.proceed()
    }

    @Around("onPageOpenPointCut()")
    fun aroundJoinOnPageOpenPointCut(joinPoint: ProceedingJoinPoint) {
        val target: Any = joinPoint.target
        val className = target.javaClass.name
        TrackPoint.INSTANCE.onPageOpenCallback(className)
        joinPoint.proceed()
    }
}