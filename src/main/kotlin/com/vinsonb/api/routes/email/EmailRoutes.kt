package com.vinsonb.api.routes.email

import com.vinsonb.api.services.SmtpService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.emailRouting() = this {
    route("/email") {
        post {
            try {
                call.receive<Email>().also {
                    SmtpService.sendEmail(it)
                }
                call.respondText("Email received", status = HttpStatusCode.Accepted)
            } catch (e: Exception) {
                System.err.println(e)
                val status = when (e) {
                    is BadRequestException -> HttpStatusCode.BadRequest
                    else -> HttpStatusCode.NotFound
                }
                call.respondText(text = e.toString(), status = status)
            }
        }
    }
}
