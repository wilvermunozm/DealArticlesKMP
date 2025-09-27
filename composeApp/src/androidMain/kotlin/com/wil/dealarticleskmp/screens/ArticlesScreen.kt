package com.wil.dealarticleskmp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.wil.dealarticleskmp.articles.Article
import com.wil.dealarticleskmp.articles.ArticlesViewModel

@Composable
fun ArticlesScreen(
    viewModel: ArticlesViewModel
) {
    val articlesState by viewModel.articlesState.collectAsState()

    Column {
        AppBar()
        if (articlesState.isLoading) {
            Loader()
        }
        if (articlesState.error != null) {
            ErrorMessage(error = articlesState.error!!)
        }
        if (articlesState.articles.isNotEmpty()) {
            ArticlesContent(articlesState.articles)
        }
    }
}

@Composable
private fun ArticlesContent(
    articlesList: List<Article>
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(articlesList) { article ->
            ArticleItem(article)
        }
    }
}

@Composable
private fun ArticleItem(article: Article) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        AsyncImage(
            model = article.urlToImage,
            contentDescription = null
        )

        Spacer(Modifier.size(4.dp))

        Text(
            article.title,
            style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold)
        )

        Spacer(Modifier.size(4.dp))

        Text(article.description)

        Spacer(Modifier.size(4.dp))

        Text(
            article.publishedAt,
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(alignment = Alignment.End),
        )

        Spacer(Modifier.size(4.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar() {
    TopAppBar(
        title = { Text("Articles") }
    )

}

@Composable
private fun Loader() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(64.dp),
            color = MaterialTheme.colorScheme.surfaceVariant,
            trackColor = MaterialTheme.colorScheme.secondary,
        )
    }
}

@Composable
private fun ErrorMessage(error: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            error,
            style = TextStyle(
                fontSize = 28.sp,
                textAlign = TextAlign.Center
            ),
        )
    }
}