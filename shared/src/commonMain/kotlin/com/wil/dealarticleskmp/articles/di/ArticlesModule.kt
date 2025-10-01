package com.wil.dealarticleskmp.articles.di

import com.wil.dealarticleskmp.articles.data.ArticlesDatasource
import com.wil.dealarticleskmp.articles.data.ArticlesRepository
import com.wil.dealarticleskmp.articles.data.ArticlesService
import com.wil.dealarticleskmp.articles.domain.ArticlesUseCase
import com.wil.dealarticleskmp.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single { ArticlesService(get()) }
    single { ArticlesUseCase(get()) }
    single { ArticlesViewModel(get()) }
    single { ArticlesDatasource(get()) }
    single { ArticlesRepository(get(), get()) }
}