package com.example.demo.model

import java.util.*

data class Company (
    val uuid: String = UUID.randomUUID().toString(),
    val address: String
)