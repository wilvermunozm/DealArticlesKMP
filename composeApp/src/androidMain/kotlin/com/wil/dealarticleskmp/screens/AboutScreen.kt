package com.wil.dealarticleskmp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.wil.dealarticleskmp.Platform

@Composable
fun AboutScreen(
    onBackClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ToolBar(onBackClick)
        ContentView()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ToolBar(
    onBackClick: () -> Unit,
) {
    TopAppBar(
        title = { Text("About") },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(Icons.Default.Close, contentDescription = "About")
            }
        }
    )
}

@Composable
private fun ContentView() {
    val dataItems = makeItems()
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        itemsIndexed(dataItems) { index, item ->
            RowItem(
                dataItems[index].first,
                dataItems[index].second
            )
        }

    }
}

@Composable
private fun RowItem(tile: String, subtitle: String) {
    ListItem(
        headlineContent = { Text(text = "bb") },
        leadingContent = { Text(text = tile) },
        trailingContent = { Text(text = subtitle) }
    )
}

private fun makeItems(): List<Pair<String, String>> {
    val platform = Platform()
    platform.logSystemInfo()

    return listOf(
        Pair("System Name", platform.systemName),
        Pair("System Version", platform.systemVersion),
        Pair("Device Name", platform.deviceName),
        Pair("Device Density", platform.deviceDensity)
    )
}