package ru.adyge.learn.language

import ru.adyge.learn.language.model.Language
import ru.adyge.learn.language.model.Word

object LanguageManager {
    val languages: Map<String, Language> = mapOf(
        "adg" to Language("адыгэ",
            mutableSetOf(
                Word("зы"),
                Word("т1у"),
                Word("щы")
            )
        ),
        "rus" to Language("русский")
    )
}