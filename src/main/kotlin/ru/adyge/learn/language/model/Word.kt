package ru.adyge.learn.language.model

data class Word(
    val name: String,
    var translate: MutableMap<Word, Double> = mutableMapOf()
)