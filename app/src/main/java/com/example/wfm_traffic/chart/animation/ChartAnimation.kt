package com.example.wfm_traffic.chart.animation

import android.view.animation.DecelerateInterpolator
import android.view.animation.Interpolator

abstract class ChartAnimation<T> {

    var duration: Long = DEFAULT_DURATION
    var interpolator: Interpolator = DecelerateInterpolator()

    abstract fun animateFrom(
        startPosition: Float,
        entries: List<T>,
        callback: () -> Unit
    ): ChartAnimation<T>

    companion object {
        private const val DEFAULT_DURATION = 2000L
    }
}
