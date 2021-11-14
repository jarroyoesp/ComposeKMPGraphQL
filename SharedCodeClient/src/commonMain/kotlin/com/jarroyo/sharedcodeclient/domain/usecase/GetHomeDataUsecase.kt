package com.jarroyo.sharedcodeclient.domain.usecase

import arrow.core.Either
import com.jarroyo.sharedcodeclient.domain.model.CharacterUIModel
import com.jarroyo.sharedcodeclient.domain.repository.HomeRepository


class GetHomeDataUsecase(private val homeRepository: HomeRepository) {

    suspend operator fun invoke(): Either<Exception, List<CharacterUIModel>?> {
        return homeRepository.getData()
    }
}