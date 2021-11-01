package com.example.domain.useCases

import com.example.domain.IRepository

class UploadImage(private val repository:IRepository) {
    fun invoke()=repository.uploadImage()
}