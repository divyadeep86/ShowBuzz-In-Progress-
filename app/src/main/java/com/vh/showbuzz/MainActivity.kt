package com.vh.showbuzz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.LocalImageLoader
import com.vh.showbuzz.common.navigation.AppNavHost
import com.vh.showbuzz.ui.theme.ShowBuzzTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var imageLoader: ImageLoader
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShowBuzzTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CompositionLocalProvider(CoilImageLoader provides imageLoader) {
                        AppNavHost(
                            navHostController = rememberNavController(),
                            modifier = Modifier.padding(innerPadding)
                        )

                    }
                }
            }
        }
    }

    val CoilImageLoader = compositionLocalOf { imageLoader }


    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!", modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        ShowBuzzTheme {
            Greeting("Android")
        }
    }
}