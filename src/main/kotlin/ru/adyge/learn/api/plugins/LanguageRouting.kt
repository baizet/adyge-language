package ru.adyge.learn.api.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import ru.adyge.learn.api.model.LanguagesResponse
import ru.adyge.learn.api.model.WordsResponse
import ru.adyge.learn.language.LanguageManager
import ru.adyge.learn.language.model.Word

fun Application.configureLanguageRouting() {
    routing {
        get ("language") {
            val languageMapResponse = LanguagesResponse(hashMapOf())
            LanguageManager.languages.forEach {
                languageMapResponse.languages[it.key] = it.value.name
            }
            call.respondText(Json.encodeToString(languageMapResponse), status = HttpStatusCode.OK)
        }
        post("/language/{id}/{word}") {
            val id = call.parameters["id"]
            val wordRequest: String = call.parameters["word"].toString()

            LanguageManager.languages.filter { it.key == id }.forEach {
                val word = Word(wordRequest)

                if (it.value.words.contains(word)) {
                    call.respondText("this word is add early")
                } else {
                    it.value.words.add(word)
                }
            }

            if (LanguageManager.languages.filter { it.key == id }.isEmpty()) {
                call.respondText("we dont have this language")
            } else {
                call.respondText("word is add")
            }
        }

        get("/language/{id}") {
            val id = call.parameters["id"]

            val response = WordsResponse()
            LanguageManager.languages[id]?.words?.forEach {
                response.words.add(it.name)
            }
            call.respondText(Json.encodeToString(response))
        }
    }
}
