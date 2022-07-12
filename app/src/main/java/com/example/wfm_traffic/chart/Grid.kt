package com.example.wfm_traffic.chart

import android.graphics.Canvas
import com.example.wfm_traffic.chart.data.Frame


interface Grid {
    fun draw(
        canvas: Canvas,
        innerFrame: Frame,
        xLabelsPositions: List<Float>,
        yLabelsPositions: List<Float>
    )
}
