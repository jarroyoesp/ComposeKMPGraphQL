package com.jarroyo.sharedcodeclient.domain.repository

import arrow.core.Either
import com.jarroyo.sharedcodeclient.domain.model.CharacterUIModel
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getData(): Either<Exception, List<CharacterUIModel>?>
    fun getDataFlow(): Flow<Either<Exception, List<CharacterUIModel>?>>
}