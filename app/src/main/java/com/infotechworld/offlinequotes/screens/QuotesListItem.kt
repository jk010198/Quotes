package com.infotechworld.offlinequotes.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.infotechworld.offlinequotes.model.DataManager
import com.infotechworld.offlinequotes.model.QuotesModel

@Composable
fun QuotesListItem(quotes: QuotesModel, onclick: (quotes: QuotesModel) -> Unit) {
    Card(elevation = 4.dp, modifier = Modifier.padding(4.dp)
    .clickable { onclick(quotes) }) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(imageVector = Icons.Filled.FormatQuote,
                contentDescription = "",
                alignment = Alignment.TopStart,
                modifier = Modifier
                    .size(40.dp)
                    .rotate(180F)
                    .background(Color.Black), colorFilter = ColorFilter.tint(Color.White))

            Spacer(modifier = Modifier.padding(4.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = quotes.text,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp))
                Box(modifier = Modifier
                    .background(Color(0xFFEEEEEE))
                    .height(2.dp)
                    .fillMaxWidth(.4f))
                Text(text = quotes.from,
                    fontWeight = FontWeight.Thin,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(top = 4.dp))
            }
        }
    }
}