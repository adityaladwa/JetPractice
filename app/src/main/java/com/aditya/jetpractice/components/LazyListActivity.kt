package com.aditya.jetpractice.components

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aditya.jetpractice.ui.theme.JetPracticeTheme

class LazyListActivity : ComponentActivity() {

    companion object {
        fun getIntent(context: Context) = Intent(context, LazyListActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPracticeTheme {
                BasicScaffold(title = "Lazy List") {
                    LazyListComposable(it)
                }
            }
        }
    }

    @Composable
    private fun LazyListComposable(paddingValues: PaddingValues) {
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            item {
                LazyListItem(text = "First Item")
            }

            items(100) {
                LazyListItem(text = "Item $it")
            }

            item {
                LazyListItem(text = "Last Item")
            }
        }
    }

    private val itemModifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)

    @Composable
    private fun LazyListItem(text: String) {
        Text(
            text = text,
            modifier = itemModifier,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
        )
        Divider()
    }
}