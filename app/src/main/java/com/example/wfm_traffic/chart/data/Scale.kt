package com.example.wfm_traffic.chart.data

import com.example.wfm_traffic.chart.render.RendererConstants

data class Scale(val min: Float, val max: Float) {
    val size = max - min
}

fun Scale.notInitialized() = max == min && min == RendererConstants.NotInitialized