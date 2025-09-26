package com.wil.dealarticleskmp

expect class Platform {
    val systemName: String
    val systemVersion: String
    val deviceName: String
    val deviceDensity: String

    fun logSystemInfo()
}