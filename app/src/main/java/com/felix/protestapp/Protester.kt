package com.felix.protestapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "protesters")
data class Protester(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val location: String,
    val description: String,
    val date: String,
    val time: String,
    val message: String
)

