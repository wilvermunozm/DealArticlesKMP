package com.wil.dealarticleskmp.articles

import com.wil.dealarticleskmp.BaseViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class ArticlesViewModel(
    //private val articlesUseCase: ArticlesUseCase
) : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> =
        MutableStateFlow(ArticlesState(isLoading = true))

    val articlesState: StateFlow<ArticlesState> get() = _articlesState
    val useCase = ArticlesUseCase(
        ArticlesService(
            HttpClient {
                install(ContentNegotiation) {
                    json(Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    })
                }
            }
        )
    )

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

    suspend fun fetchArticles(): List<Article> = useCase.fetchArticles()

}