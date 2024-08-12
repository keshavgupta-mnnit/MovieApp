package com.atlys.movieapp.ui.screens.detailscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.atlys.movieapp.models.MovieDto
import com.atlys.movieapp.navigation.MainNavGraph
import com.atlys.movieapp.ui.components.TopBar
import com.atlys.movieapp.ui.theme.typography
import com.atlys.movieapp.utils.AppConstants
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@MainNavGraph
@Destination
@Composable
fun MovieDetailsScreen(navigator: DestinationsNavigator, model: MovieDto) {
    Scaffold(topBar = {
        TopBar {
            navigator.popBackStack()
        }
    }) { padding ->
        MovieDetails(model, padding)
    }
}

@Composable
fun MovieDetails(model: MovieDto, paddingValues: PaddingValues) {
    LazyColumn(modifier = Modifier.padding(paddingValues)) {
        item {
            SubcomposeAsyncImage(
                contentScale = ContentScale.FillBounds,
                model = model.posterPath?.let { "${AppConstants.BASE_IMAGE_URL}$it" },
                contentDescription = null,
                loading = {
                    Box(contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(color = Color.Blue)
                    }
                },
                modifier = Modifier
                    .height(360.dp)
                    .padding(all = 16.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = model.title ?: "",
                style = typography.h6,
                color = Color.Black,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = model.overview ?: "",
                style = typography.body1,
                textAlign = TextAlign.Justify,
                color = Color.Black,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
        }
    }
}