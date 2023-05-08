package com.vinsonb.api.plugins

import com.vinsonb.api.routes.email.emailRouting
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Ktor REST API for vinsonb.com")
        }

        emailRouting()
    }
}
