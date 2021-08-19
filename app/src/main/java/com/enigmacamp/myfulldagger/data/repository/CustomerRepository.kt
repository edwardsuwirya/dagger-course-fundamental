package com.enigmacamp.myfulldagger.data.repository

import com.enigmacamp.myfulldagger.data.entity.Customer

interface CustomerRepository {
    fun registerNewCustomer(customer: Customer): Long
}