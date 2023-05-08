package com.vinsonb.api

import com.vinsonb.api.plugins.configureHTTP
import com.vinsonb.api.plugins.configureRouting
import com.vinsonb.api.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(
        Netty,
        port = 8080,
        host = "0.0.0.0", // TODO
        module = Application::module,
        watchPaths = listOf("classes", "resources")
    )
        .start(wait = true)
}

fun Application.module() {
    configureHTTP()
//    configureSecurity() // TODO: Add JWT Auth
    configureRouting()
    configureSerialization()
}
