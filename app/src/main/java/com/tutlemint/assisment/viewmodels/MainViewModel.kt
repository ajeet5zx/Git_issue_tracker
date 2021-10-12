package com.tutlemint.assisment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tutlemint.assisment.models.IssueListItem
import com.tutlemint.assisment.repository.IssuesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(private val repository: IssuesRepository) : ViewModel() {

    init {
        GlobalScope.launch(Dispatchers.IO){
            repository.getIssuesList(1)
        }
    }

    val issues : LiveData<List<IssueListItem>>
    get() = repository.quotes
}