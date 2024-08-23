package com.felix.protestapp

import android.app.Application

class MyApplication : Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
    val repository: ProtesterRepository by lazy { ProtesterRepository(database.protesterDao()) }
}
