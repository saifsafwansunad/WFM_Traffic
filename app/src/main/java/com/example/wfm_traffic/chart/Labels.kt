package com.example.wfm_traffic.chart

import android.graphics.Canvas
import android.graphics.Paint
import androidx.annotation.ColorInt
import com.example.wfm_traffic.chart.data.Label


interface Labels {
    fun draw(canvas: Canvas, paint: Paint, xLabels: List<Label>, @ColorInt labelColor: Int)
}
