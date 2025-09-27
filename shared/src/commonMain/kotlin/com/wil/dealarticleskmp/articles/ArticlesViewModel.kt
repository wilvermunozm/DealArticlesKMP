package com.wil.dealarticleskmp.articles

import com.wil.dealarticleskmp.BaseViewModel
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