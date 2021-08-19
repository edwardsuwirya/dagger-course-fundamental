package com.enigmacamp.myfulldagger.data.entity

import androidx.room.*
import java.util.*

@Entity(tableName = "m_customer")
data class Customer(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "customer_id")
    val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "id_card") val idCard: String,
    @ColumnInfo(name = "gender") val gender: String,
)
