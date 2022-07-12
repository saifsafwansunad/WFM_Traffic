package com.example.wfm_traffic.chart.data

import android.graphics.drawable.Drawable

data class DataPoint(
    val drawable: Drawable?=null,
    val label: String,
    val value: Float,
    var screenPositionX: Float = 0f,
    var screenPositionY: Float = 0f,
    var drawableScreenPositionX: Float=0f,
    var drawableScreenPositionY: Float=0f
)