package com.example.domain.useCases

import com.example.domain.IRepository

class HomePostList(private val repository:IRepository) {
    fun invoke()=repository.homePostList()
}