package com.tutlemint.assisment.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tutlemint.assisment.models.IssueListItem
import com.tutlemint.assisment.models.Result

@Dao
interface QuoteDao {

    @Insert
    suspend fun addQuotes(quotes: List<IssueListItem>)

    @Query("SELECT * FROM quote")
    suspend fun getQuotes() : List<IssueListItem>

    @Query("DELETE FROM quote")
    fun deleteTable()
}