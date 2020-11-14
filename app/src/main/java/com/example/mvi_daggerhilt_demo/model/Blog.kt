package com.example.mvi_daggerhilt_demo.model

data class Blog(
    val id: Int,
    val title: String,
    val body: String,
    val image: String,
    val category: String
)