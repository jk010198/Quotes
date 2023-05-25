package com.infotechworld.offlinequotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.infotechworld.offlinequotes.model.DataManager
import com.infotechworld.offlinequotes.screens.QuoteDetails
import com.infotechworld.offlinequotes.screens.QuotesListsScreen
import com.infotechworld.offlinequotes.ui.theme.OfflineQuotesTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            delay(2000)
            DataManager.loadAssetFromFile(applicationContext)
        }

        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    if (DataManager.isDataLoaded.value) {
        if (DataManager.currentPage.value == Pages.QUOTELIST){
            QuotesListsScreen(data = DataManager.data) {
                DataManager.switchPages(it)
            }
        } else {
            DataManager.currentQuote?.let { QuoteDetails(quote = it) }
        }


    } else {
        Text(text = "Loading", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
    }
}

enum class Pages{
    QUOTELIST,
    QUOTEDETAILS
}

