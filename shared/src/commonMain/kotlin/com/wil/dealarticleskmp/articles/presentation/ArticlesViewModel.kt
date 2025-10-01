package com.wil.dealarticleskmp.articles.presentation

import com.wil.dealarticleskmp.BaseViewModel
import com.wil.dealarticleskmp.articles.domain.Article
import com.wil.dealarticleskmp.articles.domain.ArticlesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val articlesUseCase: ArticlesUseCase
) : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> =
        MutableStateFlow(ArticlesState(isLoading = true))

    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {
        loadArticles()
    }

    fun loadArticles() {
        scope.launch {

            val fetchedArticles = fetchArticles()

            _articlesState.emit(
                ArticlesState(
                    articles = fetchedArticles,
                    isLoading = false
                )
            )
        }
    }

    suspend fun fetchArticles(): List<Article> = articlesUseCase.fetchArticles()

}