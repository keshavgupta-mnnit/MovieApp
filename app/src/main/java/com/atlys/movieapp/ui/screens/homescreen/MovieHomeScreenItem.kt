package com.atlys.movieapp.ui.screens.homescreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.atlys.movieapp.ui.theme.typography

@Composable
fun MovieHomeScreenItem(imageSrc: String, title: String, onClick: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(208.dp)
            .padding(4.dp)
            .clickable { onClick() }
    ) {
        AsyncImage(
            contentScale = ContentScale.FillBounds,
            model = imageSrc,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight(0.8f)
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = title,
            modifier = Modifier.fillMaxWidth(),
            style = typography.subtitle1,
            color = Color.Black,
            textAlign = TextAlign.Start,
            maxLines = 1
        )
    }
}