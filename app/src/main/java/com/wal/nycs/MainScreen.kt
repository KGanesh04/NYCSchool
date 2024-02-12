package com.wal.nycs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen(dataViewModel: DataViewModel = viewModel()) {
    val dataList by dataViewModel.dataList.observeAsState()

    Surface(color = MaterialTheme.colors.background) {
        Column {
            // Display your UI components here
            DataList(dataList)
        }
    }
}

@Composable
fun DataList(dataList: List<Data>?) {
    LazyColumn {
        items(dataList ?: emptyList()) { data ->
            // Display each item in the list
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MyApp {
        MainScreen()
    }
}