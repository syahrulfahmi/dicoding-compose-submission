package com.sf.dcd.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sf.dcd.compose.core.data.source.DataResult
import com.sf.dcd.compose.core.domain.model.MovieDomain
import com.sf.dcd.compose.core.util.ui.LoadingContent
import com.sf.dcd.compose.page.home.HomeScreen
import com.sf.dcd.compose.page.home.HomeViewModel
import com.sf.dcd.compose.ui.theme.DicodingComposeSubmissionTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DicodingComposeSubmissionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(),
    navController: NavController = rememberNavController()
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Greeting(name = "asdqwe", uiState = viewModel.movieUiState) {

        }
    }
}

@Composable
fun Greeting(
    modifier: Modifier = Modifier,
    name: String,
    uiState: StateFlow<DataResult<MovieDomain.Result>>,
    navigateToDetail: (Int) -> Unit
) {
    uiState.collectAsState().value.let {
        when (it) {
            is DataResult.Loading -> {
                LoadingContent()
            }

            is DataResult.Success -> {
                HomeScreen(modifier = modifier, it.data ?: MovieDomain.Result()) { id ->
                    navigateToDetail.invoke(id)
                }
            }

            is DataResult.Error -> {

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    DicodingComposeSubmissionTheme {
        Greeting(name = "Android", uiState = MutableStateFlow(DataResult.Loading(null)))
    }
}