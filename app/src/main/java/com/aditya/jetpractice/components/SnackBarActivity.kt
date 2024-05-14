package com.aditya.jetpractice.components

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.aditya.jetpractice.ui.theme.JetPracticeTheme
import kotlinx.coroutines.launch

class SnackBarActivity : ComponentActivity() {

    companion object {
        fun getIntent(context: Context) = Intent(context, SnackBarActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPracticeTheme {
                SnackBarComposable()
            }
        }
    }

    @Composable
    private fun SnackBarComposable() {
        val scope = rememberCoroutineScope()
        val snackbarHostState = remember { SnackbarHostState() }
        Scaffold(
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    modifier = Modifier.padding(it),
                    onClick = {
                        scope.launch {
                            val result = snackbarHostState
                                .showSnackbar(
                                    message = "Hello",
                                    actionLabel = "ACTION",
                                    duration = SnackbarDuration.Short
                                )
                            when (result) {
                                SnackbarResult.Dismissed -> Toast.makeText(
                                    this@SnackBarActivity,
                                    "Dismissed",
                                    Toast.LENGTH_SHORT
                                ).show()

                                SnackbarResult.ActionPerformed -> Toast.makeText(
                                    this@SnackBarActivity,
                                    "Action Performed",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }) {
                    Text(text = "Show Snackbar")
                }
            }
        }
    }
}