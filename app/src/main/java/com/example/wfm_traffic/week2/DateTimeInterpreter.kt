package com.example.wfm_traffic.week2

import java.util.*

interface DateTimeInterpreter {
    fun getFormattedWeekDayTitle(date: Calendar): String

    fun getFormattedTimeOfDay(hour: Int, minutes: Int): String


}