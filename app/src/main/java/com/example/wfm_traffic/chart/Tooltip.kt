package com.example.wfm_traffic.chart

import android.view.ViewGroup

interface Tooltip {
    fun onCreateTooltip(parentView: ViewGroup)
    fun onDataPointTouch(x: Float, yTouch: Float,yPoint:Float)
    fun onDataPointClick(x: Float, y: Float)
    fun onActionUp()
}
