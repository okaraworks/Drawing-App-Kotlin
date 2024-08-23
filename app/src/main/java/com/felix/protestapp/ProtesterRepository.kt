package com.felix.protestapp

import androidx.lifecycle.LiveData

class ProtesterRepository(private val protesterDao: ProtesterDao) {
    val allProtesters: LiveData<List<Protester>> = protesterDao.getAllProtesters()

    suspend fun insert(protester: Protester) {
        protesterDao.insert(protester)
    }

    suspend fun update(protester: Protester) {
        protesterDao.update(protester)
    }
}
