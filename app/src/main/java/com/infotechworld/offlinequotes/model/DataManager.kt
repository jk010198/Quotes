package com.infotechworld.offlinequotes.model

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.infotechworld.offlinequotes.Pages

object DataManager {
    var data = emptyArray<QuotesModel>()
    var currentQuote: QuotesModel? = null
    var currentPage = mutableStateOf(Pages.QUOTELIST)
    var isDataLoaded = mutableStateOf(false)

    fun loadAssetFromFile(context: Context){
        //val inputStream = .openRa("quotes.json")
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<QuotesModel>::class.java)
        isDataLoaded.value = true
    }

    fun switchPages(quotesModel: QuotesModel?){
        if (currentPage.value == Pages.QUOTELIST){
            currentQuote = quotesModel
            currentPage.value = Pages.QUOTEDETAILS
        } else {
            currentPage.value = Pages.QUOTELIST
        }
    }
}