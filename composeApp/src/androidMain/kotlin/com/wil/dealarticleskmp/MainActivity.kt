package com.wil.dealarticleskmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.wil.dealarticleskmp.articles.ArticlesViewModel
import com.wil.dealarticleskmp.screens.ArticlesScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        val articlesViewModel: ArticlesViewModel by viewModels()

        Platform().logSystemInfo()

        setContent {
            ArticlesScreen(
                viewModel = articlesViewModel
            )
        }
    }
}