package com.infotechworld.offlinequotes.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.infotechworld.offlinequotes.model.QuotesModel
import kotlin.text.Typography.quote

@Composable
fun QuoteList(data: Array<QuotesModel>, onClick: (quote: QuotesModel) -> Unit) {
    LazyColumn(content = {

        items(data){
            QuotesListItem(quotes = it, onClick)

        }
    })
}