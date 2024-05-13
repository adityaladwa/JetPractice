package com.aditya.jetpractice.components

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.aditya.jetpractice.ui.theme.JetPracticeTheme

class SwitchActivity : ComponentActivity() {

    companion object {
        fun getIntent(context: Context) = Intent(context, SwitchActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPracticeTheme {
                BasicScaffold(title = "Switch") { innerPadding ->
                    SwitchComposable(innerPadding)
                }
            }
        }
    }

    @Composable
    private fun SwitchComposable(innerPadding: PaddingValues) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var checked by remember { mutableStateOf(false) }
            Switch(
                checked = checked,
                onCheckedChange = {
                    checked = it
                }
            )

            var secondCheck by remember {
                mutableStateOf(false)
            }
            Switch(
                checked = secondCheck,
                onCheckedChange = {
                    secondCheck = it
                },
                thumbContent = if (secondCheck) {
                    {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = null,
                            modifier = Modifier.size(SwitchDefaults.IconSize),
                        )
                    }
                } else {
                    null
                }
            )


            var nextCheck by remember { mutableStateOf(true) }

            Switch(
                checked = nextCheck,
                onCheckedChange = {
                    nextCheck = it
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = MaterialTheme.colorScheme.primary,
                    checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                    uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                    uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                )
            )
        }
    }
}