package ru.adyge.learn.api.model

import kotlinx.serialization.Serializable

@Serializable
data class LanguagesResponse(
    var languages: HashMap<String, String>
)
