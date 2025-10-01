package com.wil.dealarticleskmp.articles.presentation

import com.wil.dealarticleskmp.articles.domain.Article

data class ArticlesState(
    val articles: List<Article> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)
