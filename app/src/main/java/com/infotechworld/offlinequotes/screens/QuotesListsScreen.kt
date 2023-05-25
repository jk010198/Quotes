package com.infotechworld.offlinequotes.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.infotechworld.offlinequotes.R
import com.infotechworld.offlinequotes.model.QuotesModel

@Composable
fun QuotesListsScreen(data: Array<QuotesModel>, onClick: (quote: QuotesModel) -> Unit) {
    Column() {
        Text(text = "Quotes App",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp, 24.dp)
                .fillMaxWidth(1f),
            style = MaterialTheme.typography.h5,
            fontFamily = FontFamily(Font(R.font.poppins_regular)))

        QuoteList(data = data, onClick)
    }
}