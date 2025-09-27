package com.wil.dealarticleskmp.articles

import com.wil.dealarticleskmp.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> =
        MutableStateFlow(ArticlesState(isLoading = true))

    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {
        loadArticles()
    }

    fun loadArticles() {
        scope.launch {
            delay(1500)

            _articlesState.emit(
                ArticlesState(
                    error = "Error, correeee!!!!"
                )
            )

            delay(1500)

            val fetchedArticles = fetchArticles()

            _articlesState.emit(
                ArticlesState(
                    articles = fetchedArticles,
                    isLoading = false
                )
            )
        }
    }

    suspend fun fetchArticles(): List<Article> = mockArticles

    private val mockArticles = listOf(
        Article(
            id = "1",
            title = "Article 1",
            description = "Description 1",
            url = "https://example.com",
            urlToImage = "https://media.istockphoto.com/id/814423752/photo/eye-of-model-with-colorful-art-make-up-close-up.jpg?s=612x612&w=0&k=20&c=l15OdMWjgCKycMMShP8UK94ELVlEGvt7GmB_esHWPYE=",
            publishedAt = "2022-01-01",
            content = "Content 1"
        ),
        Article(
            id = "2",
            title = "Article 2",
            description = "Description 2",
            url = "https://mawiapps.com/wp-content/uploads/2025/05/image__2_-removebg-preview-1-3.png",
            urlToImage = "https://mawiapps.com/wp-content/uploads/2025/05/image__2_-removebg-preview-1-3.png",
            publishedAt = "2022-01-02",
            content = "Content 2"
        ),
        Article(
            id = "3",
            title = "Article 3",
            description = "Description 3",
            url = "https://example.com",
            urlToImage = "https://media.istockphoto.com/id/814423752/photo/eye-of-model-with-colorful-art-make-up-close-up.jpg?s=612x612&w=0&k=20&c=l15OdMWjgCKycMMShP8UK94ELVlEGvt7GmB_esHWPYE=",
            publishedAt = "2022-01-03",
            content = "Content 3"
        )
    )

}