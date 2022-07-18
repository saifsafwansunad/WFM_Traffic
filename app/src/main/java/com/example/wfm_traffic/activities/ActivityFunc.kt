package com.example.wfm_traffic.activities

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.wfm_traffic.R
import com.example.wfm_traffic.chart.extensions.Value
import com.example.wfm_traffic.chart.extensions.convertToLinearChartData
import com.example.wfm_traffic.chart.extensions.getMonthAndDay
import com.example.wfm_traffic.chart.extensions.toOralHygieneChart
import com.example.wfm_traffic.chart.tooltip.SliderTooltip
import com.example.wfm_traffic.databinding.ActivityMainBinding

import java.util.*
import kotlin.collections.HashMap

class ActivityFunc {

//    public fun setupLinearChart(sliderTooltip: SliderTooltip, binding: ActivityMainBinding, context:Context) {
//        // Chart datav
//        val currentDate = Date()
//        val calendar = Calendar.getInstance()
//        calendar.time = currentDate
//        //Create a fake data for one month
//        val remoteData = HashMap<String, List<String?>>()
//        remoteData["1"] = listOf("11")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["2"] = listOf("11")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["3"] = listOf("11")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["4"] = listOf("10" )
//        calendar.add(Calendar.DATE, -1)
//        remoteData["5"] = listOf("11")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["6"] = listOf("7")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["7"] = listOf("9")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["8"] = listOf("4")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["9"] = listOf("5")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["10"] = listOf("6")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["11"] = listOf("6")
//        remoteData["12"] = listOf("6")
//        remoteData["13"] = listOf("6")
//        remoteData["14"] = listOf("6")
//        remoteData["15"] = listOf("6")
//        remoteData["16"] = listOf("6")
//        remoteData["17"] = listOf("6")
//        remoteData["18"] = listOf("6")
//        remoteData["19"] = listOf("6")
//        remoteData["20"] = listOf("6")
//
//        Log.d("chartremotedata", remoteData.toString())
//
//        // Convert data to chart input
//        val lineChartData = remoteData.toOralHygieneChart()
//        Log.d("chartremotedata", lineChartData.toString())
//        val convertedData = lineChartData.convertToLinearChartData()
//        Log.d("chartremotedata", convertedData.toString())
//        // Setup tooltip and chart color
//        // In the triple data:
//        // first = Drawable
//        // second = date
//        // third = score
//        var isDataFake = false
//        sliderTooltip.apply {
//            // Get the first date that has a value
//            val isDataSizeIsOne = convertedData.filter { it.third != 0.0f }.size == 1
//            val firstData = convertedData.reversed().firstOrNull { it.third != 0.0f }
//            if (isDataSizeIsOne && convertedData.reversed().first().third == 0.0f) {
//                isDataFake = true
//                convertedData[convertedData.size - 1] = Triple(
//                    ColorDrawable(Color.RED),
//                    firstData!!.second,
//                    firstData.third
//                )
//            }
//            var firstChartData: Value? = null
//            var scoreAverage = ""
//            var date = ""
//            if (firstData != null) {
//                // Get first score average
//                scoreAverage = firstData.third.toInt().toString()
//                // Get first date
//                date = firstData.second
//                // Get all score if score are more then one
//                firstChartData = lineChartData.first().value.reversed().firstOrNull {
//                    it.score.size > 1 && it.date.toLong().getMonthAndDay() == firstData.second
//                }
//            }
//            // Set the first two score to show on screen
//            var scoreOne = ""
//            var scoreTwo = ""
//            if (firstChartData != null) {
//                scoreOne = firstChartData.score[0].toString()
//                scoreTwo = firstChartData.score[1].toString()
//            }
//            // Set tooltip data
//            this.scoreAverage = scoreAverage
//            this.date = date
//            if (scoreOne != "")
//                this.scoreOne = scoreOne
//            if (scoreTwo != "")
//                this.scoreTwo = scoreTwo
//        }
//        binding.included.linearChartViewOralHygiene.apply {
//            isTooltipDraw = false
//            tooltip = sliderTooltip
//            isFake = isDataFake
//            // Change colors of chart
//            gradientFillColors = intArrayOf(
//                ContextCompat.getColor(context, R.color.light_violet),
//                ContextCompat.getColor(context, R.color.white)
//            )
//            lineColor = ContextCompat.getColor(context, R.color.light_violet)
//            // Set animation duration to draw the chart
//            animation.duration = CHART_ANIMATION_DURATION
//        }
//
//        // If you are using view pager you can disable input touch to avoid
//        // getting conflict with chart touch
////        binding.linearChartViewOralHygiene.onDataPointUnTouchListener = { _, _, _ ->
////            FragmentHome.viewPager2.isUserInputEnabled = true
////        }
//        binding.included.linearChartViewOralHygiene.onDataPointTouchListener = { index, _, _ ->
////            FragmentHome.viewPager2.isUserInputEnabled = false
//            val isFake = convertedData[index].first != null
//            val scoreAverage = convertedData[index].third.toInt().toString()
//            val date = convertedData[index].second
//            var scoreOne = ""
//            var scoreTwo = ""
//            if (lineChartData.first().value[index].score.size > 1) {
//                scoreOne = lineChartData.first().value[index].score[0].toString()
//                scoreTwo = lineChartData.first().value[index].score[1].toString()
//            }
//            binding.included.linearChartViewOralHygiene.tooltip = sliderTooltip.apply {
//                this.isFake = isFake
//                this.scoreAverage = scoreAverage
//                this.date = date
//                if (scoreOne != "") {
//                    this.scoreOne = scoreOne
//                }
//
//                this.scoreTwo = scoreTwo
//            }
//        }
//
//        binding.included.linearChartViewOralHygiene.animate(convertedData)
//    }
//
//    public fun setupLinearChart1(sliderTooltip: SliderTooltip, binding: ActivityMainBinding, context:Context) {
//        // Chart datav
//        val currentDate = Date()
//        val calendar = Calendar.getInstance()
//        calendar.time = currentDate
//        //Create a fake data for one month
//        val remoteData = HashMap<String, List<String?>>()
//        remoteData["1"] = listOf("12")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["2"] = listOf("11")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["3"] = listOf("11")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["4"] = listOf("10" )
//        calendar.add(Calendar.DATE, -1)
//        remoteData["5"] = listOf("11")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["6"] = listOf("7")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["7"] = listOf("2")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["8"] = listOf("3")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["9"] = listOf("5")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["10"] = listOf("4")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["11"] = listOf("4")
//        remoteData["12"] = listOf("7")
//        remoteData["13"] = listOf("6")
//        remoteData["14"] = listOf("10")
//        remoteData["15"] = listOf("18")
//        remoteData["16"] = listOf("20")
//        remoteData["17"] = listOf("13")
//        remoteData["18"] = listOf("11")
//        remoteData["19"] = listOf("11")
//        remoteData["20"] = listOf("12")
//
//        Log.d("chartremotedata", remoteData.toString())
//
//        // Convert data to chart input
//        val lineChartData = remoteData.toOralHygieneChart()
//        Log.d("chartremotedata", lineChartData.toString())
//        val convertedData = lineChartData.convertToLinearChartData()
//        Log.d("chartremotedata", convertedData.toString())
//        // Setup tooltip and chart color
//        // In the triple data:
//        // first = Drawable
//        // second = date
//        // third = score
//        var isDataFake = false
//        sliderTooltip.apply {
//            // Get the first date that has a value
//            val isDataSizeIsOne = convertedData.filter { it.third != 0.0f }.size == 1
//            val firstData = convertedData.reversed().firstOrNull { it.third != 0.0f }
//            if (isDataSizeIsOne && convertedData.reversed().first().third == 0.0f) {
//                isDataFake = true
//                convertedData[convertedData.size - 1] = Triple(
//                    ColorDrawable(Color.RED),
//                    firstData!!.second,
//                    firstData.third
//                )
//            }
//            var firstChartData: Value? = null
//            var scoreAverage = ""
//            var date = ""
//            if (firstData != null) {
//                // Get first score average
//                scoreAverage = firstData.third.toInt().toString()
//                // Get first date
//                date = firstData.second
//                // Get all score if score are more then one
//                firstChartData = lineChartData.first().value.reversed().firstOrNull {
//                    it.score.size > 1 && it.date.toLong().getMonthAndDay() == firstData.second
//                }
//            }
//            // Set the first two score to show on screen
//            var scoreOne = ""
//            var scoreTwo = ""
//            if (firstChartData != null) {
//                scoreOne = firstChartData.score[0].toString()
//                scoreTwo = firstChartData.score[1].toString()
//            }
//            // Set tooltip data
//            this.scoreAverage = scoreAverage
//            this.date = date
//            if (scoreOne != "")
//                this.scoreOne = scoreOne
//            if (scoreTwo != "")
//                this.scoreTwo = scoreTwo
//        }
//
//        binding.included.linearChartViewOralHygiene1.apply {
//            isTooltipDraw = false
//            tooltip = sliderTooltip
//            isFake = isDataFake
//            // Change colors of chart
//            gradientFillColors = intArrayOf(
//                ContextCompat.getColor(context, R.color.teal_200),
//                ContextCompat.getColor(context, R.color.white)
//            )
//            lineColor = ContextCompat.getColor(context, R.color.teal_700)
//            // Set animation duration to draw the chart
//            animation.duration = CHART_ANIMATION_DURATION
//        }
//
//        // If you are using view pager you can disable input touch to avoid
//        // getting conflict with chart touch
////        binding.linearChartViewOralHygiene.onDataPointUnTouchListener = { _, _, _ ->
////            FragmentHome.viewPager2.isUserInputEnabled = true
////        }
//        binding.included.linearChartViewOralHygiene1.onDataPointTouchListener = { index, _, _ ->
////            FragmentHome.viewPager2.isUserInputEnabled = false
//            val isFake = convertedData[index].first != null
//            val scoreAverage = convertedData[index].third.toInt().toString()
//            val date = convertedData[index].second
//            var scoreOne = ""
//            var scoreTwo = ""
//            if (lineChartData.first().value[index].score.size > 1) {
//                scoreOne = lineChartData.first().value[index].score[0].toString()
//                scoreTwo = lineChartData.first().value[index].score[1].toString()
//            }
//            binding.included.linearChartViewOralHygiene1.tooltip = sliderTooltip.apply {
//                this.isFake = isFake
//                this.scoreAverage = scoreAverage
//                this.date = date
//                if (scoreOne != "") {
//                    this.scoreOne = scoreOne
//                }
//
//                this.scoreTwo = scoreTwo
//            }
//        }
//
//        binding.included.linearChartViewOralHygiene1.animate(convertedData)
//    }
//
//    public fun setupLinearChart2(sliderTooltip: SliderTooltip, binding: ActivityMainBinding, context:Context) {
//        // Chart datav
//        val currentDate = Date()
//        val calendar = Calendar.getInstance()
//        calendar.time = currentDate
//        //Create a fake data for one month
//        val remoteData = HashMap<String, List<String?>>()
//        remoteData["1"] = listOf("11")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["2"] = listOf("20")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["3"] = listOf("19")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["4"] = listOf("18" )
//        calendar.add(Calendar.DATE, -1)
//        remoteData["5"] = listOf("17")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["6"] = listOf("16")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["7"] = listOf("15")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["8"] = listOf("13")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["9"] = listOf("12")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["10"] = listOf("11")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["11"] = listOf("10")
//        remoteData["12"] = listOf("9")
//        remoteData["13"] = listOf("8")
//        remoteData["14"] = listOf("7")
//        remoteData["15"] = listOf("6")
//        remoteData["16"] = listOf("5")
//        remoteData["17"] = listOf("4")
//        remoteData["18"] = listOf("3")
//        remoteData["19"] = listOf("2")
//        remoteData["20"] = listOf("1")
//
//        Log.d("chartremotedata", remoteData.toString())
//
//        // Convert data to chart input
//        val lineChartData = remoteData.toOralHygieneChart()
//        Log.d("chartremotedata", lineChartData.toString())
//        val convertedData = lineChartData.convertToLinearChartData()
//        Log.d("chartremotedata", convertedData.toString())
//        // Setup tooltip and chart color
//        // In the triple data:
//        // first = Drawable
//        // second = date
//        // third = score
//        var isDataFake = false
//        sliderTooltip.apply {
//            // Get the first date that has a value
//            val isDataSizeIsOne = convertedData.filter { it.third != 0.0f }.size == 1
//            val firstData = convertedData.reversed().firstOrNull { it.third != 0.0f }
//            if (isDataSizeIsOne && convertedData.reversed().first().third == 0.0f) {
//                isDataFake = true
//                convertedData[convertedData.size - 1] = Triple(
//                    ColorDrawable(Color.RED),
//                    firstData!!.second,
//                    firstData.third
//                )
//            }
//            var firstChartData: Value? = null
//            var scoreAverage = ""
//            var date = ""
//            if (firstData != null) {
//                // Get first score average
//                scoreAverage = firstData.third.toInt().toString()
//                // Get first date
//                date = firstData.second
//                // Get all score if score are more then one
//                firstChartData = lineChartData.first().value.reversed().firstOrNull {
//                    it.score.size > 1 && it.date.toLong().getMonthAndDay() == firstData.second
//                }
//            }
//            // Set the first two score to show on screen
//            var scoreOne = ""
//            var scoreTwo = ""
//            if (firstChartData != null) {
//                scoreOne = firstChartData.score[0].toString()
//                scoreTwo = firstChartData.score[1].toString()
//            }
//            // Set tooltip data
//            this.scoreAverage = scoreAverage
//            this.date = date
//            if (scoreOne != "")
//                this.scoreOne = scoreOne
//            if (scoreTwo != "")
//                this.scoreTwo = scoreTwo
//        }
//
//        binding.included.linearChartViewOralHygiene2.apply {
//            isTooltipDraw = false
//            tooltip = sliderTooltip
//            isFake = isDataFake
//            // Change colors of chart
//            gradientFillColors = intArrayOf(
//                ContextCompat.getColor(context, R.color.primaryLight200),
//                ContextCompat.getColor(context, R.color.secondaryLight)
//            )
//            lineColor = ContextCompat.getColor(context, R.color.white)
//            // Set animation duration to draw the chart
//            animation.duration = CHART_ANIMATION_DURATION
//        }
//
//        // If you are using view pager you can disable input touch to avoid
//        // getting conflict with chart touch
////        binding.linearChartViewOralHygiene.onDataPointUnTouchListener = { _, _, _ ->
////            FragmentHome.viewPager2.isUserInputEnabled = true
////        }
//        binding.included.linearChartViewOralHygiene2.onDataPointTouchListener = { index, _, _ ->
////            FragmentHome.viewPager2.isUserInputEnabled = false
//            val isFake = convertedData[index].first != null
//            val scoreAverage = convertedData[index].third.toInt().toString()
//            val date = convertedData[index].second
//            var scoreOne = ""
//            var scoreTwo = ""
//            if (lineChartData.first().value[index].score.size > 1) {
//                scoreOne = lineChartData.first().value[index].score[0].toString()
//                scoreTwo = lineChartData.first().value[index].score[1].toString()
//            }
//            binding.included.linearChartViewOralHygiene2.tooltip = sliderTooltip.apply {
//                this.isFake = isFake
//                this.scoreAverage = scoreAverage
//                this.date = date
//                if (scoreOne != "") {
//                    this.scoreOne = scoreOne
//                }
//
//                this.scoreTwo = scoreTwo
//            }
//        }
//
//        binding.included.linearChartViewOralHygiene2.animate(convertedData)
//    }
//
//    public fun setupLinearChart3(sliderTooltip: SliderTooltip, binding: ActivityMainBinding, context:Context) {
//        // Chart datav
//        val currentDate = Date()
//        val calendar = Calendar.getInstance()
//        calendar.time = currentDate
//        //Create a fake data for one month
//        val remoteData = HashMap<String, List<String?>>()
//        remoteData["1"] = listOf("11")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["2"] = listOf("11")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["3"] = listOf("11")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["4"] = listOf("10" )
//        calendar.add(Calendar.DATE, -1)
//        remoteData["5"] = listOf("11")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["6"] = listOf("7")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["7"] = listOf("9")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["8"] = listOf("4")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["9"] = listOf("5")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["10"] = listOf("6")
//        calendar.add(Calendar.DATE, -1)
//        remoteData["11"] = listOf("6")
//        remoteData["12"] = listOf("6")
//        remoteData["13"] = listOf("6")
//        remoteData["14"] = listOf("6")
//        remoteData["15"] = listOf("6")
//        remoteData["16"] = listOf("6")
//        remoteData["17"] = listOf("6")
//        remoteData["18"] = listOf("6")
//        remoteData["19"] = listOf("6")
//        remoteData["20"] = listOf("6")
//
//        Log.d("chartremotedata", remoteData.toString())
//
//        // Convert data to chart input
//        val lineChartData = remoteData.toOralHygieneChart()
//        Log.d("chartremotedata", lineChartData.toString())
//        val convertedData = lineChartData.convertToLinearChartData()
//        Log.d("chartremotedata", convertedData.toString())
//        // Setup tooltip and chart color
//        // In the triple data:
//        // first = Drawable
//        // second = date
//        // third = score
//        var isDataFake = false
//        sliderTooltip.apply {
//            // Get the first date that has a value
//            val isDataSizeIsOne = convertedData.filter { it.third != 0.0f }.size == 1
//            val firstData = convertedData.reversed().firstOrNull { it.third != 0.0f }
//            if (isDataSizeIsOne && convertedData.reversed().first().third == 0.0f) {
//                isDataFake = true
//                convertedData[convertedData.size - 1] = Triple(
//                    ColorDrawable(Color.RED),
//                    firstData!!.second,
//                    firstData.third
//                )
//            }
//            var firstChartData: Value? = null
//            var scoreAverage = ""
//            var date = ""
//            if (firstData != null) {
//                // Get first score average
//                scoreAverage = firstData.third.toInt().toString()
//                // Get first date
//                date = firstData.second
//                // Get all score if score are more then one
//                firstChartData = lineChartData.first().value.reversed().firstOrNull {
//                    it.score.size > 1 && it.date.toLong().getMonthAndDay() == firstData.second
//                }
//            }
//            // Set the first two score to show on screen
//            var scoreOne = ""
//            var scoreTwo = ""
//            if (firstChartData != null) {
//                scoreOne = firstChartData.score[0].toString()
//                scoreTwo = firstChartData.score[1].toString()
//            }
//            // Set tooltip data
//            this.scoreAverage = scoreAverage
//            this.date = date
//            if (scoreOne != "")
//                this.scoreOne = scoreOne
//            if (scoreTwo != "")
//                this.scoreTwo = scoreTwo
//        }
//
//        binding.included.linearChartViewOralHygiene3.apply {
//            isTooltipDraw = false
//            tooltip = sliderTooltip
//            isFake = isDataFake
//            // Change colors of chart
//            gradientFillColors = intArrayOf(
//                ContextCompat.getColor(context, R.color.primaryLight200),
//                ContextCompat.getColor(context, R.color.secondaryLight)
//            )
//            lineColor = ContextCompat.getColor(context, R.color.white)
//            // Set animation duration to draw the chart
//            animation.duration = CHART_ANIMATION_DURATION
//        }
//
//        // If you are using view pager you can disable input touch to avoid
//        // getting conflict with chart touch
////        binding.linearChartViewOralHygiene.onDataPointUnTouchListener = { _, _, _ ->
////            FragmentHome.viewPager2.isUserInputEnabled = true
////        }
//        binding.included.linearChartViewOralHygiene3.onDataPointTouchListener = { index, _, _ ->
////            FragmentHome.viewPager2.isUserInputEnabled = false
//            val isFake = convertedData[index].first != null
//            val scoreAverage = convertedData[index].third.toInt().toString()
//            val date = convertedData[index].second
//            var scoreOne = ""
//            var scoreTwo = ""
//            if (lineChartData.first().value[index].score.size > 1) {
//                scoreOne = lineChartData.first().value[index].score[0].toString()
//                scoreTwo = lineChartData.first().value[index].score[1].toString()
//            }
//            binding.included.linearChartViewOralHygiene3.tooltip = sliderTooltip.apply {
//                this.isFake = isFake
//                this.scoreAverage = scoreAverage
//                this.date = date
//                if (scoreOne != "") {
//                    this.scoreOne = scoreOne
//                }
//
//                this.scoreTwo = scoreTwo
//            }
//        }
//
//        binding.included.linearChartViewOralHygiene3.animate(convertedData)
//    }
//
//    companion object {
//        private const val LINEAR_CHART_DATE_FORMAT = "yyyy/MM/dd"
//        private const val LINE_CHART_DATE_FORMAT = "yyyy-MM-dd"
//
//        private const val CHART_ANIMATION_DURATION = 2500L
//    }
}