package com.wil.dealarticleskmp.di

import com.wil.dealarticleskmp.articles.ArticlesDb
import com.wil.dealarticleskmp.db.DatabaseDriverFactory
import org.koin.dsl.module

val dataBaseModule = module {

    single { DatabaseDriverFactory().createDriver() }

    single { ArticlesDb(get()) }

}

