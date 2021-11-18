package com.example.latihanpref

import android.content.Context

class PrefManager(context: Context) {

    companion object{
        const val PREF_NAME = "app_pref"
        const val IS_FIRST_TIME = "is_first_time"
    }

    val sharedPref = context.applicationContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
}