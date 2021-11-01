package com.example.domain.useCases

import com.example.domain.IRepository

class CreatePost(private val repository: IRepository) {
    operator fun invoke() = repository.createPost()

}