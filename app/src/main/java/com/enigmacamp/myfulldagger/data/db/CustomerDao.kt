package com.enigmacamp.myfulldagger.data.db

import androidx.room.Dao
import com.enigmacamp.myfulldagger.data.entity.Customer

@Dao
interface CustomerDao : BaseDao<Customer>