package com.tutlemint.assisment.api

import com.tutlemint.assisment.models.IssueList
import com.tutlemint.assisment.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {

    @GET("repos/square/okhttp/issues")
    suspend fun getQuotes() : Response<IssueList>

}