package ru.adyge.learn.language.model

data class Language(
    val name: String,
    var words: MutableSet<Word> = mutableSetOf()
)