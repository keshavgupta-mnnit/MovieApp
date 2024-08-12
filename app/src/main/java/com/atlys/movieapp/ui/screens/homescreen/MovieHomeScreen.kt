package com.atlys.movieapp.ui.screens.homescreen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.atlys.movieapp.models.MovieDto
import com.atlys.movieapp.navigation.MainNavGraph
import com.atlys.movieapp.ui.components.SearchBar
import com.atlys.movieapp.ui.screens.destinations.MovieDetailsScreenDestination
import com.atlys.movieapp.utils.AppConstants
import com.atlys.movieapp.viewmodel.MovieViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@MainNavGraph(start = true)
@Destination
@Composable
fun MovieHomeScreen(navigator: DestinationsNavigator, viewModel: MovieViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    val searchString by viewModel.searchString.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        SearchBar(searchString = searchString) {
            Log.d("MovieHomeScreen","searchString : $it")
            viewModel.fetchMovieByQuery(it)
        }
        if (state.isLoading) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
        if (state.error.isNotBlank()) {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
        }
        if (state.filteredList != null) {
            MovieListItem(state.filteredList ?: emptyList(), navigator)
        } else if (state.allList != null) {
            MovieListItem(state.allList ?: emptyList(), navigator)
        } else {
            Text(text = "Something went wrong")
        }
    }
}

@Composable
fun MovieListItem(list: List<MovieDto>, navigator: DestinationsNavigator) {
    if (list.isEmpty().not()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), contentPadding = PaddingValues(
                start = 12.dp,
                top = 16.dp,
                end = 12.dp,
                bottom = 16.dp
            )
        ) {
            items(list) { model ->
                MovieHomeScreenItem(imageSrc = model.posterPath?.let { "${AppConstants.BASE_IMAGE_URL}$it" }
                    ?: "", title = model.title ?: "") {
                    navigator.navigate(MovieDetailsScreenDestination(model))
                }

            }
        }
    } else {
        Box(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    text ="No Movie Found",
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
        }

    }
}