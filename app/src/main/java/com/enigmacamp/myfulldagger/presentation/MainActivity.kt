package com.enigmacamp.myfulldagger.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.enigmacamp.myfulldagger.R
import com.enigmacamp.myfulldagger.data.SharedPref
import com.enigmacamp.myfulldagger.data.db.AppDatabase
import com.enigmacamp.myfulldagger.data.repository.CustomerRepositoryImpl
import com.enigmacamp.simplesharedpref.data.repository.AuthenticationRepositoryImpl
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        viewModel.doLogin("jeco", "123")
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactoryBase { viewModel }).get(MainActivityViewModel::class.java)
    }
}