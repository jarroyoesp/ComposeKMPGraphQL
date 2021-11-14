package com.jarroyo.sharedcodeclient.domain.model

import com.jarroyo.GetCharactersQuery

data class CharacterUIModel(
    val id: String?,
    val name: String?,
    val image: String?
)

fun GetCharactersQuery.Result?.toUIModel(): CharacterUIModel {
    return CharacterUIModel(id = this?.id, name = this?.name, image = this?.image)
}

fun GetCharactersQuery.Characters.toUIModel(): List <CharacterUIModel>? {
    return this.results?.map {
        it.toUIModel()
    }
}