package com.distribuido.simpleCrud.entity

import org.springframework.data.annotation.Id
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table

@Table("medicine")
data class Medicine(
    @Id
    @PrimaryKey
    var id: String,
    val name: String,
    val price: Double,
    var amount: Int
)
