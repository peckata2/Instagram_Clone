package com.example.domain.useCases

import com.example.domain.IRepository

class PostLike(private val repository:IRepository) {
    fun invoke()=repository.postLike()
}