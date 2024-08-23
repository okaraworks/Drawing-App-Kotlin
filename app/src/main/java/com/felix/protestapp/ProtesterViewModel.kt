package com.felix.protestapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProtesterViewModel(private val repository: ProtesterRepository) : ViewModel() {
    val allProtesters: LiveData<List<Protester>> = repository.allProtesters

    fun insert(protester: Protester) = viewModelScope.launch {
        repository.insert(protester)
    }

    fun update(protester: Protester) = viewModelScope.launch {
        repository.update(protester)
    }
}
