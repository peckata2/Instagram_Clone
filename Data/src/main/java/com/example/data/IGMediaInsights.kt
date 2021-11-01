package com.example.data

data class IGMediaInsights(
    val name: String,
    val period: String,
    val title: String,
    val description: String,
    val id: String,
    val values:List<Value>
)
