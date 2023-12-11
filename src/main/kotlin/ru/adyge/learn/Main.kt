package ru.adyge.learn

import io.ktor.server.application.*
import io.ktor.server.netty.*
import ru.adyge.learn.api.plugins.configureLanguageRouting
import ru.adyge.learn.api.plugins.configurePagesRouting
import kotlin.String as String

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    configurePagesRouting()
    configureLanguageRouting()
}