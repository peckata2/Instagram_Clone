package com.example.data

data class IGComment(
    val hidden: Boolean,
    val from: String,
    val id: String,
    val like_count: String,
    val media:String,
    val parent_id:String,
    val replies:List<IGComment>,
    val text:String,
    val timestamp:String,
    val user:String,
    val username:String
)
