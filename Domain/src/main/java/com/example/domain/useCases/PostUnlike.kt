package com.example.domain.useCases

import com.example.domain.IRepository

class PostUnlike(private val repository:IRepository) {
    fun invoke()=repository.postUnlike()
}