package com.example.repository

import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getNews(): Flow<List<News>>
}