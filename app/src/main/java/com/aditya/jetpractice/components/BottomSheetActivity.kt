package com.aditya.jetpractice.components

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aditya.jetpractice.ui.theme.JetPracticeTheme
import kotlinx.coroutines.launch

class BottomSheetActivity : ComponentActivity() {

    companion object {
        fun getIntent(context: Context) = Intent(context, BottomSheetActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPracticeTheme {
                BasicScaffold(title = "Bottom Sheet") {
                    BottomSheetComposable(it)
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun BottomSheetComposable(innerPadding: PaddingValues) {
        val sheetState = rememberModalBottomSheetState()
        val scope = rememberCoroutineScope()
        ModalBottomSheet(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            onDismissRequest = {
                Toast.makeText(this, "Dismissed", Toast.LENGTH_SHORT).show()
            },
            sheetState = sheetState,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "This is bottom sheet contents",
                    modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
                )
                Button(onClick = {
                    scope.launch { sheetState.hide() }
                        .invokeOnCompletion { finish() }
                }) {
                    Text(text = "This is a button")
                }
            }
        }
    }
}