package com.infotechworld.offlinequotes.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.infotechworld.offlinequotes.model.DataManager
import com.infotechworld.offlinequotes.model.QuotesModel

@Composable
fun QuoteDetails(quote: QuotesModel) {
    BackHandler() {
        DataManager.switchPages(null)
    }

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(Brush.sweepGradient(colors = listOf(Color(0xFFffffff),
                Color(0xFFE3E3E3))))) {
        Card(elevation = 4.dp, modifier = Modifier.padding(32.dp)) {
            Column(verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp, 24.dp)) {
                Image(imageVector = Icons.Filled.FormatQuote,
                    contentDescription = "",
                    alignment = Alignment.TopStart,
                    modifier = Modifier
                        .size(80.dp)
                        .rotate(180F)
                        )

                Text(text = quote.text,
                    style = MaterialTheme.typography.h6)

                Spacer(modifier = Modifier.padding(16.dp))

                Text(text = quote.from,
                    fontWeight = FontWeight.Thin,
                    style = MaterialTheme.typography.subtitle1)

            }
        }

    }
}