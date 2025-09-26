package com.wil.dealarticleskmp

import platform.Foundation.NSLog
import platform.UIKit.UIDevice
import platform.UIKit.UIScreen

actual class Platform() {
    actual val systemName: String
        get() = "iOS"
    actual val systemVersion: String
        get() = UIDevice.currentDevice.systemVersion
    actual val deviceName: String
        get() = UIDevice.currentDevice.name
    actual val deviceDensity: String
        get() = "${UIScreen.mainScreen.scale}"

    actual fun logSystemInfo() {
        NSLog(
            "System Name: $systemName, System Version: $systemVersion, Device Name: $deviceName, Device Density: $deviceDensity"
        )
    }
}