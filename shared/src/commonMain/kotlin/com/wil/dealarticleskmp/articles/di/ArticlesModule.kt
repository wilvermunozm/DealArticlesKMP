package com.wil.dealarticleskmp.articles.di

import com.wil.dealarticleskmp.articles.ArticlesDatasource
import com.wil.dealarticleskmp.articles.ArticlesRepository
import com.wil.dealarticleskmp.articles.ArticlesService
import com.wil.dealarticleskmp.articles.ArticlesUseCase
import com.wil.dealarticleskmp.articles.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single { ArticlesService(get()) }
    single { ArticlesUseCase(get()) }
    single { ArticlesViewModel(get()) }
    single { ArticlesDatasource(get()) }
    single { ArticlesRepository(get(), get()) }
}