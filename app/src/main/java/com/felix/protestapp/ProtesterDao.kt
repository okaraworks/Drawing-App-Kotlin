package com.felix.protestapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProtesterDao {
    @Insert
    suspend fun insert(protester: Protester)

    @Update
    suspend fun update(protester: Protester)

    @Query("SELECT * FROM protesters ORDER BY date DESC, time DESC")
    fun getAllProtesters(): LiveData<List<Protester>>
}
