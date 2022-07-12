package com.example.wfm_traffic.chart.animation

import com.example.wfm_traffic.chart.data.DataPoint


class NoAnimation : ChartAnimation<DataPoint>() {

    override fun animateFrom(
        startPosition: Float,
        entries: List<DataPoint>,
        callback: () -> Unit
    ): ChartAnimation<DataPoint> = this
}

