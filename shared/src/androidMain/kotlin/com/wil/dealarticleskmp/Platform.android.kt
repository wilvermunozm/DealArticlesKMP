package com.wil.dealarticleskmp

import android.content.res.Resources
import android.os.Build
import android.util.Log
import kotlin.math.round

actual class Platform() {
    actual val systemName: String
        get() = "Android"
    actual val systemVersion: String
        get() = "${Build.VERSION.SDK_INT}"
    actual val deviceName: String
        get() = "${Build.MANUFACTURER} ${Build.MODEL}"
    actual val deviceDensity: String
        get() = round(Resources.getSystem().displayMetrics.density).toString()

    actual fun logSystemInfo() {
        Log.d(
            "DealArticles",
            "System Name: $systemName, System Version: $systemVersion, Device Name: $deviceName, Device Density: $deviceDensity"
        )
    }
}