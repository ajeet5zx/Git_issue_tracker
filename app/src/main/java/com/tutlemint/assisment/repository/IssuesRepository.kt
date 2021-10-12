package com.tutlemint.assisment.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tutlemint.assisment.api.QuoteService
import com.tutlemint.assisment.db.QuoteDatabase
import com.tutlemint.assisment.models.IssueListItem
import com.tutlemint.assisment.models.QuoteList
import com.tutlemint.assisment.utils.NetworkUtils

class IssuesRepository(
    private val quoteService: QuoteService,
    private val quoteDatabase: QuoteDatabase,
    private val applicationContext: Context
) {

    private val quotesLiveData = MutableLiveData<List<IssueListItem>>()

    val quotes: LiveData<List<IssueListItem>>
    get() = quotesLiveData

    suspend fun getIssuesList(page: Int){

        if(NetworkUtils.isInternetAvailable(applicationContext)){
            val result = quoteService.getQuotes()
            val result2=result
            if(result?.body() != null){
                quoteDatabase.quoteDao().deleteTable()
                quoteDatabase.quoteDao().addQuotes(result.body()!!)
                quotesLiveData.postValue(result.body())
            }
        }
        else{
            val quotes = quoteDatabase.quoteDao().getQuotes()
            quotesLiveData.postValue(quotes)
        }
    }
}







