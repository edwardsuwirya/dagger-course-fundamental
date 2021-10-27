package com.enigmacamp.myfulldagger.presentation

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.enigmacamp.myfulldagger.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class CustomerActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModel: CustomerActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)
        initViewModel()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactoryBase { viewModel }).get(CustomerActivityViewModel::class.java)
        Log.d("ViewModel-Customer", viewModel.toString())
    }
}