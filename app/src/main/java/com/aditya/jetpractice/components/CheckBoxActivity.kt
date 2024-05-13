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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.aditya.jetpractice.ui.theme.JetPracticeTheme

class CheckBoxActivity : ComponentActivity() {

    companion object {
        fun getIntent(context: Context) = Intent(context, CheckBoxActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPracticeTheme {
                BasicScaffold(title = "Checkbox") {

                    CheckBoxComposable(it)
                }
            }
        }
    }

    @Composable
    private fun CheckBoxComposable(innerPadding: PaddingValues) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var checked by remember { mutableStateOf(false) }
            Row(
                modifier = Modifier.padding(innerPadding),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Checkbox")
                Checkbox(
                    checked = checked,
                    onCheckedChange = {
                        checked = it
                    }
                )
            }
            val checkedText = if (checked) "checked" else "not checked"
            Text(text = "Checkbox is $checkedText")
        }
    }
}