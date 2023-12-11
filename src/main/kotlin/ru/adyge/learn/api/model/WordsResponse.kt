package ru.adyge.learn.api.model

import kotlinx.serialization.Serializable

@Serializable
data class WordsResponse(
    val words: MutableSet<String> = mutableSetOf()
)
