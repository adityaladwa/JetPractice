package com.aditya.jetpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aditya.jetpractice.components.AppBarActivity
import com.aditya.jetpractice.components.ScaffoldActivity
import com.aditya.jetpractice.ui.theme.JetPracticeTheme

class MainActivity : ComponentActivity() {
    private val components = listOf(
        Component.Scaffold,
        Component.AppBar
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPracticeTheme {
                LazyColumn {
                    items(components) {
                        ListItem(it.title) { navigateToComponentActivity(it) }
                    }
                }
            }
        }
    }

    private fun navigateToComponentActivity(component: Component) {
        when (component) {
            Component.Scaffold -> startActivity(ScaffoldActivity.getIntent(this))
            Component.AppBar -> startActivity(AppBarActivity.getIntent(this))
        }
    }

    @Composable
    private fun ListItem(name: String, onClickItem: () -> Unit) {
        Column(modifier = Modifier.clickable { onClickItem() }) {
            Text(
                text = name,
                fontSize = 30.sp,
                modifier = Modifier.padding(8.dp),
            )
            Divider()
        }
    }
}


enum class Component(
    val title: String
) {
    Scaffold(title = "Scaffold"),
    AppBar(title = "AppBar")
}