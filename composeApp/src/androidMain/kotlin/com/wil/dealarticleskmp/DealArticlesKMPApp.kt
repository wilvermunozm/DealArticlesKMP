package com.wil.dealarticleskmp

import android.app.Application
import com.wil.dealarticleskmp.di.dataBaseModule
import com.wil.dealarticleskmp.di.sharedCoinModules
import com.wil.dealarticleskmp.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class DealArticlesKMPApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DealArticlesKMPApp)
            modules(sharedCoinModules + viewModelsModule + dataBaseModule)
        }
    }
}