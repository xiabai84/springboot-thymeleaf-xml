package com.example.demo.model

import java.util.*

data class Person(
    val uuid: String = UUID.randomUUID().toString(),
    val response: String
)