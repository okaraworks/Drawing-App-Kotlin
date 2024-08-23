package com.felix.protestapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProtesterViewModelFactory(private val repository: ProtesterRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProtesterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProtesterViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
