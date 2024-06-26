package com.aditya.jetpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aditya.jetpractice.components.AppBarActivity
import com.aditya.jetpractice.components.BasicScaffold
import com.aditya.jetpractice.components.BottomSheetActivity
import com.aditya.jetpractice.components.ButtonActivity
import com.aditya.jetpractice.components.CardActivity
import com.aditya.jetpractice.components.CheckBoxActivity
import com.aditya.jetpractice.components.ChipActivity
import com.aditya.jetpractice.components.DialogActivity
import com.aditya.jetpractice.components.LazyGridActivity
import com.aditya.jetpractice.components.LazyGridStaggeredActivity
import com.aditya.jetpractice.components.LazyListActivity
import com.aditya.jetpractice.components.NavigationDrawerActivity
import com.aditya.jetpractice.components.ProgressIndicatorActivity
import com.aditya.jetpractice.components.ScaffoldActivity
import com.aditya.jetpractice.components.SliderActivity
import com.aditya.jetpractice.components.SnackBarActivity
import com.aditya.jetpractice.components.SwitchActivity
import com.aditya.jetpractice.ui.theme.JetPracticeTheme

class MainActivity : ComponentActivity() {
    private val components = listOf(
        Component.Scaffold,
        Component.AppBar,
        Component.Button,
        Component.Card,
        Component.Chip,
        Component.Dialog,
        Component.ProgressIndicator,
        Component.Slider,
        Component.Switch,
        Component.Checkbox,
        Component.BottomSheet,
        Component.NavigationDrawer,
        Component.SnackBar,
        Component.LazyList,
        Component.LazyGrid,
        Component.LazyGridStaggered
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPracticeTheme {
                BasicScaffold(title = "Components") {
                    ContentComposable(it)
                }
            }
        }
    }

    @Composable
    private fun ContentComposable(paddingValues: PaddingValues) {
        LazyColumn(contentPadding = paddingValues) {
            items(components) {
                ListItem(it.title) { navigateToComponentActivity(it) }
            }
        }
    }

    private fun navigateToComponentActivity(component: Component) {
        when (component) {
            Component.Scaffold -> startActivity(ScaffoldActivity.getIntent(this))
            Component.AppBar -> startActivity(AppBarActivity.getIntent(this))
            Component.Button -> startActivity(ButtonActivity.getIntent(this))
            Component.Card -> startActivity(CardActivity.getIntent(this))
            Component.Chip -> startActivity(ChipActivity.getIntent(this))
            Component.Dialog -> startActivity(DialogActivity.getIntent(this))
            Component.ProgressIndicator -> startActivity(ProgressIndicatorActivity.getIntent(this))
            Component.Slider -> startActivity(SliderActivity.getIntent(this))
            Component.Switch -> startActivity(SwitchActivity.getIntent(this))
            Component.Checkbox -> startActivity(CheckBoxActivity.getIntent(this))
            Component.BottomSheet -> startActivity(BottomSheetActivity.getIntent(this))
            Component.NavigationDrawer -> startActivity(NavigationDrawerActivity.getIntent(this))
            Component.SnackBar -> startActivity(SnackBarActivity.getIntent(this))
            Component.LazyList -> startActivity(LazyListActivity.getIntent(this))
            Component.LazyGrid -> startActivity(LazyGridActivity.getIntent(this))
            Component.LazyGridStaggered -> startActivity(LazyGridStaggeredActivity.getIntent(this))
        }
    }

    @Composable
    private fun ListItem(name: String, onClickItem: () -> Unit) {
        Column(modifier = Modifier.clickable { onClickItem() }) {
            Text(
                text = name,
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                color = MaterialTheme.typography.titleLarge.color,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
            )
            Divider(modifier = Modifier.padding(2.dp))
        }
    }
}


enum class Component(
    val title: String
) {
    Scaffold(title = "Scaffold"),
    AppBar(title = "AppBar"),
    Button(title = "Button"),
    Card(title = "Card"),
    Chip(title = "Chip"),
    Dialog(title = "Dialog"),
    ProgressIndicator(title = "Progress Indicator"),
    Slider(title = "Slider"),
    Switch(title = "Switch"),
    Checkbox(title = "Checkbox"),
    BottomSheet(title = "Bottom Sheet"),
    NavigationDrawer(title = "Navigation Drawer"),
    SnackBar(title = "Snackbar"),
    LazyList(title = "Lazy List"),
    LazyGrid(title = "Lazy Grid"),
    LazyGridStaggered(title = "Lazy Grid Staggered")
}