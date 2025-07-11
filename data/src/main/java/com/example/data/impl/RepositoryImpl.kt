package com.example.data.repositories_usecases_impl

import android.util.Log
import com.example.data.api.RetrofitService
import com.example.data.mappers.toNews
import com.example.domain.entities.News
import com.example.domain.repositories.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryImpl(private val api: RetrofitService):Repository {
    override fun getNews(): Flow<List<News>> = flow {
        val news = api.getRss().channel.items.map {
                itemList ->
            itemList.toNews()
        }
        emit(news)
    }
}