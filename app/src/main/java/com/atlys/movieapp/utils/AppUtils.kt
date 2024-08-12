package com.atlys.movieapp.utils

import com.atlys.movieapp.BuildConfig

object AppUtils {
    fun getApiKey(): String {
        return BuildConfig.API_KEY
    }
}