package com.enigmacamp.myfulldagger.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.enigmacamp.myfulldagger.R
import com.enigmacamp.myfulldagger.appComponent

class CustomerActivity : AppCompatActivity() {
//    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)
//        initViewModel()
    }

//    private fun initViewModel() {
//        viewModel = ViewModelProvider(
//            this,
//            ViewModelFactoryBase { appComponent.mainActivityViewModel }).get(MainActivityViewModel::class.java)
//        Log.d("ViewModel-Customer", viewModel.toString())
//    }
}