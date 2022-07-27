package com.example.wfm_traffic.week2

import androidx.annotation.ColorInt

interface TextColorPicker {

    @ColorInt
    fun getTextColor(event: WeekViewEvent): Int

}