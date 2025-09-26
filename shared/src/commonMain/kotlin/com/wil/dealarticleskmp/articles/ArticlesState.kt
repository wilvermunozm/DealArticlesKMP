package com.wil.dealarticleskmp.articles

data class ArticlesState (
    val articles : List<Article> = emptyList(),
    val isLoading : Boolean = false,
    val error : String? = null,
)
