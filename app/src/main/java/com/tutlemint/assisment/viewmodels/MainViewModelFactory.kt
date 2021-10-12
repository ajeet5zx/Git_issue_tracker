package com.tutlemint.assisment.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tutlemint.assisment.repository.IssuesRepository

class MainViewModelFactory(private val repository: IssuesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}