package com.wil.dealarticleskmp.di

import com.wil.dealarticleskmp.articles.di.articlesModule

val sharedCoinModules = listOf(
    networkModule,
    articlesModule
)