package com.example.domain.useCases

import com.example.domain.IRepository

class PostDetail(private val repository:IRepository) {
    fun invoke()=repository.postDetail()
}