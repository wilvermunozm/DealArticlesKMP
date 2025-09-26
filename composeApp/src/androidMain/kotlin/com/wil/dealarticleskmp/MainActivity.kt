package com.wil.dealarticleskmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        Platform().logSystemInfo()

        setContent {
            AboutScreen()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}