package com.vh.showbuzz.home.genres.data

import kotlinx.serialization.Serializable

@Serializable
data class GeneresDTO(
    val genres: List<Genre>
)
@Serializable
data class Genre(
    val id: Int,
    val name: String
)
