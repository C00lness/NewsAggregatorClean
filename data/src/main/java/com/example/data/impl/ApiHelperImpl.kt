package com.example.net

import com.example.net.dto.ItemDto
import com.example.net.dto.RssFeed
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val rssFeed: RssFeed) : ApiHelper{
    override fun getNews(): Flow<List<ItemDto>> = flow {
        emit(rssFeed.getRss().channel.items)
    }
}