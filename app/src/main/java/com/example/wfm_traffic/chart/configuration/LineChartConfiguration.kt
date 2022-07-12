package com.example.wfm_traffic.chart.configuration

import com.example.wfm_traffic.chart.data.AxisType
import com.example.wfm_traffic.chart.data.Paddings
import com.example.wfm_traffic.chart.data.Scale

data class LineChartConfiguration(
    override val width: Int,
    override val height: Int,
    override val paddings: Paddings,
    override val axis: AxisType,
    override val labelsSize: Float,
    override val scale: Scale,
    override val labelsFormatter: (Int) -> String = { it.toString() },
    val lineThickness: Float,
    val pointsDrawableWidth: Int,
    val pointsDrawableHeight: Int,
    val fillColor: Int,
    val gradientFillColors: IntArray,
    val clickableRadius: Int
) : ChartConfiguration(
    width = width,
    height = height,
    paddings = paddings,
    axis = axis,
    labelsSize = labelsSize,
    scale = scale,
    labelsFormatter = labelsFormatter
)
