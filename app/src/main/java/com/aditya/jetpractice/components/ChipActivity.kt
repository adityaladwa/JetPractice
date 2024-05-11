package com.aditya.jetpractice.components

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.aditya.jetpractice.ui.theme.JetPracticeTheme

class ChipActivity : ComponentActivity() {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, ChipActivity::class.java)
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPracticeTheme {
                BasicScaffold(title = "Chips") { innerPadding ->
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        AssistChipComposable()
                        FilterChipComposable()
                        InputChipComposable {
                        }
                        SuggestionChipComposable()
                    }
                }
            }
        }
    }

    @Composable
    private fun SuggestionChipComposable() {
        SuggestionChip(onClick = { }, label = { Text(text = "Suggestion Chip") })
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun InputChipComposable(onDismiss: () -> Unit) {
        var enabled by remember {
            mutableStateOf(true)
        }
        if (!enabled) return
        InputChip(
            onClick = {
                onDismiss()
                enabled = !enabled
            },
            label = { Text(text = "Input Chip") },
            selected = enabled,
            avatar = {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = "Localized description",
                    Modifier.size(InputChipDefaults.AvatarSize)
                )
            },
            trailingIcon = {
                Icon(
                    Icons.Default.Close,
                    contentDescription = "Localized description",
                    Modifier.size(InputChipDefaults.AvatarSize)
                )
            }
        )
    }

    @Composable
    private fun AssistChipComposable() {
        AssistChip(
            onClick = { },
            label = { Text(text = "Assist Chip") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Description",
                    modifier = Modifier.size(AssistChipDefaults.IconSize)
                )
            }
        )
    }

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    private fun FilterChipComposable() {
        var selected by remember {
            mutableStateOf(false)
        }
        FilterChip(
            selected = selected,
            onClick = { selected = !selected },
            label = { Text(text = "Filter Chip") },
            leadingIcon = if (selected) {
                {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = "Description",
                        modifier = Modifier.size(AssistChipDefaults.IconSize)
                    )
                }
            } else {
                null
            }
        )
    }
}