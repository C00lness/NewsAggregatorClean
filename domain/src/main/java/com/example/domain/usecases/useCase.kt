package com.example.domain.usecases

import com.example.domain.repositories.Repository

class useCase(private val repository: Repository) {
    fun getNews() = repository.getNews()
}