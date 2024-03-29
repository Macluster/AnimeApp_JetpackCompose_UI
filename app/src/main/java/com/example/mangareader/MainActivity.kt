package com.example.mangareader

import android.os.Bundle
import android.telecom.Call.Details
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.example.mangareader.ui.theme.MangaReaderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            var viewModel=viewModels<ItemViewModel>();






            MangaReaderTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //HomePage(viewModel.value.list,navController)
                    NavHost(navController = navController, startDestination = "home") {
                        composable(route="home") {  HomePage(viewModel.value.list,navController) }
                       composable(route = "detail/{index}") {
                            AnimeDetailsPage( it.arguments?.getString("index") as String ,viewModel)
                        }


                    }


                }
            }
        }
    }
}



