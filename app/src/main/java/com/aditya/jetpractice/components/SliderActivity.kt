package com.aditya.jetpractice.components

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aditya.jetpractice.R
import com.aditya.jetpractice.ui.theme.JetPracticeTheme

class SliderActivity : ComponentActivity() {

    companion object {
        fun getIntent(context: Context) = Intent(context, SliderActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPracticeTheme {
                BasicScaffold(title = "Slider") { innerPadding ->
                    SliderComposable(innerPadding)
                }
            }
        }
    }

    @Composable
    private fun SliderComposable(innerPadding: PaddingValues) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(innerPadding)
        ) {
            var sliderValue by remember {
                mutableFloatStateOf(0f)
            }
            Slider(
                value = sliderValue,
                onValueChange = {
                    sliderValue = it
                },
                colors = SliderDefaults.colors(
                    thumbColor = MaterialTheme.colorScheme.secondary,
                    activeTrackColor = MaterialTheme.colorScheme.secondary,
                    inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                ),
                steps = 5,
                valueRange = 0f..100f
            )
            Text(text = "Slider value = $sliderValue")
        }
    }
}