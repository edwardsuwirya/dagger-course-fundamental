package com.enigmacamp.myfulldagger.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.enigmacamp.myfulldagger.appComponent
import com.enigmacamp.myfulldagger.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {
    lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        subscribe()
        binding.apply {
            val userName = editTextUserName.text
            val password = editTextPassword.text
            buttonLogin.setOnClickListener {
                viewModel.doLogin(userName.toString(), password.toString())
            }
        }

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactoryBase { appComponent.mainActivityViewModel }).get(MainActivityViewModel::class.java)
        Log.d("ViewModel-Main", viewModel.toString())
    }

    private fun subscribe() {
        viewModel.userIsAuthenticated.observe(this) {
            if (it) {
                val intent = Intent(this, CustomerActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Ooops", Toast.LENGTH_SHORT).show()
            }
        }
    }
}