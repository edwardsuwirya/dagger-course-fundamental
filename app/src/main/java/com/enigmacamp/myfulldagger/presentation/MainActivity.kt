package com.enigmacamp.myfulldagger.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.RoomDatabase
import com.enigmacamp.myfulldagger.R
import com.enigmacamp.myfulldagger.data.SharedPref
import com.enigmacamp.myfulldagger.data.db.AppDatabase
import com.enigmacamp.myfulldagger.data.repository.CustomerRepositoryImpl
import com.enigmacamp.mysimpleupload.data.api.RetrofitInstance
import com.enigmacamp.simplesharedpref.data.repository.AuthenticationRepositoryImpl

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        viewModel.doLogin("jeco", "123")
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val sharedPref = SharedPref(applicationContext)
                val authenticationRepository = AuthenticationRepositoryImpl(
                    RetrofitInstance(sharedPref).authApi,
                    sharedPref
                )
                val db = AppDatabase.getDatabase(applicationContext)
                val customerRepository = CustomerRepositoryImpl(db)
                return MainActivityViewModel(authenticationRepository, customerRepository) as T
            }
        }).get(MainActivityViewModel::class.java)
    }
}