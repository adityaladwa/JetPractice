package com.aditya.jetpractice.components

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.aditya.jetpractice.ui.theme.JetPracticeTheme

class DialogActivity : ComponentActivity() {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, DialogActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPracticeTheme {
                DialogComposable()
            }
        }
    }

    @Composable
    private fun DialogComposable() {
        var dismiss by remember {
            mutableStateOf(false)
        }
        if (dismiss) return
        AlertDialog(
            icon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email") },
            title = { Text(text = "This is title") },
            text = { Text(text = "This is dialog text") },
            onDismissRequest = {
                dismiss = true
                Toast.makeText(this, "Dialog dismissed", Toast.LENGTH_SHORT).show()
            },
            confirmButton = {
                TextButton(onClick = {
                    dismiss = true
                    Toast.makeText(this, "Dialog confirmed", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    dismiss = true
                    Toast.makeText(this, "Dialog dismissed", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "Dismiss")
                }
            }
        )
    }
}