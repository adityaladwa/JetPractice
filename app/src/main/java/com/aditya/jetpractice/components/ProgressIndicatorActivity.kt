package com.aditya.jetpractice.components

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aditya.jetpractice.R
import com.aditya.jetpractice.ui.theme.JetPracticeTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProgressIndicatorActivity : ComponentActivity() {

    companion object {
        fun getIntent(context: Context) = Intent(context, ProgressIndicatorActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPracticeTheme {
                ProgressIndicatorComposable()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun ProgressIndicatorComposable() {
        val scope = rememberCoroutineScope()
        var progress = remember {
            mutableFloatStateOf(0f)
        }
        LaunchedEffect(key1 = Unit) {
            for (i in 1..100) {
                progress.floatValue = i.toFloat() / 100f
                delay(100)
            }
        }
        BasicScaffold(title = "Progress Indicator") { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                LinearProgressIndicator(
                    progress = progress.floatValue,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                CircularProgressIndicator(
                    progress = progress.floatValue,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(16.dp)
                )

                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(100.dp)
                        .padding(16.dp)
                )
            }
        }
    }
}