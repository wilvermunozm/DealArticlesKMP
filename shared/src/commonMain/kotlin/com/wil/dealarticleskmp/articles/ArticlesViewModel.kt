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
            title = "The Rise of AI: Transforming Industries",
            description = "Artificial Intelligence is no longer a concept of the future. It's here, and it's reshaping every industry from healthcare to finance. This article explores the impact of AI and what it means for our world.",
            url = "https://example.com",
            urlToImage = "https://media.istockphoto.com/id/814423752/photo/eye-of-model-with-colorful-art-make-up-close-up.jpg?s=612x612&w=0&k=20&c=l15OdMWjgCKycMMShP8UK94ELVlEGvt7GmB_esHWPYE=",
            publishedAt = "2024-09-26",
            content = "From automating tasks to providing deep insights from data, AI is proving to be a game-changer. Companies that are early adopters of AI technology are seeing significant advantages in efficiency and innovation."
        ),
        Article(
            id = "2",
            title = "Sustainable Living: A Guide to a Greener Lifestyle",
            description = "Want to reduce your carbon footprint? This guide provides practical tips for sustainable living, from reducing waste to making eco-friendly choices in your daily life.",
            url = "https://mawiapps.com/wp-content/uploads/2025/05/image__2_-removebg-preview-1-3.png",
            urlToImage = "https://mawiapps.com/wp-content/uploads/2025/05/image__2_-removebg-preview-1-3.png",
            publishedAt = "2024-09-25",
            content = "Living sustainably doesn't have to be difficult. Simple changes like using reusable bags, composting food scraps, and choosing energy-efficient appliances can make a big difference for the planet."
        ),
        Article(
            id = "3",
            title = "The Future of Space Exploration",
            description = "With new missions to Mars and beyond, what does the future hold for space exploration? Experts weigh in on the next frontiers of human discovery.",
            url = "https://example.com",
            urlToImage = "https://media.istockphoto.com/id/814423752/photo/eye-of-model-with-colorful-art-make-up-close-up.jpg?s=612x612&w=0&k=20&c=l15OdMWjgCKycMMShP8UK94ELVlEGvt7GmB_esHWPYE=",
            publishedAt = "2024-09-24",
            content = "From private companies launching their own rockets to international collaborations aiming for the moon and Mars, the ambition for space exploration is higher than ever. The coming decades promise exciting new discoveries."
        )
    )

}