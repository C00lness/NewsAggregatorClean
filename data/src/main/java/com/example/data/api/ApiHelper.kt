package com.example.net

import com.example.net.dto.ItemDto
import kotlinx.coroutines.flow.Flow

interface ApiHelper {
    fun getNews(): Flow<List<ItemDto>>
}