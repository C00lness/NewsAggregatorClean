package com.example.domain.repositories

import com.example.domain.entities.News
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getNews(): Flow<List<News>>
}