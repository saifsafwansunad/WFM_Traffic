package com.example.wfm_traffic.chart.configuration

import com.example.wfm_traffic.chart.data.AxisType
import com.example.wfm_traffic.chart.data.Frame
import com.example.wfm_traffic.chart.data.Paddings
import com.example.wfm_traffic.chart.data.Scale

open class ChartConfiguration(
    open val width: Int,
    open val height: Int,
    open val paddings: Paddings,
    open val axis: AxisType,
    open val labelsSize: Float,
    open val scale: Scale,
    open val labelsFormatter: (Int) -> String
)

internal fun ChartConfiguration.toOuterFrame(): Frame {
    return Frame(
        left = paddings.left,
        top = paddings.top,
        right = width - paddings.right,
        bottom = height - paddings.bottom
    )
}
