package com.tutlemint.assisment

import android.app.Application
import com.tutlemint.assisment.api.QuoteService
import com.tutlemint.assisment.api.RetrofitHelper
import com.tutlemint.assisment.db.QuoteDatabase
import com.tutlemint.assisment.repository.IssuesRepository

class IssuesApplication : Application() {

    lateinit var quoteRepository: IssuesRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = IssuesRepository(quoteService, database, applicationContext)
    }
}