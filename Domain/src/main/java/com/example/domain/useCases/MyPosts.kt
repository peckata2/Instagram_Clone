package com.example.domain.useCases

import com.example.domain.IRepository

class MyPosts(private val repository:IRepository) {
    fun invoke()=repository.myPosts()
}