package com.enigmacamp.myfulldagger.data.repository

import com.enigmacamp.myfulldagger.data.db.AppDatabase
import com.enigmacamp.myfulldagger.data.entity.Customer

class CustomerRepositoryImpl(private val db: AppDatabase) : CustomerRepository {
    override fun registerNewCustomer(customer: Customer) = db.customerDao().insert(customer)
}