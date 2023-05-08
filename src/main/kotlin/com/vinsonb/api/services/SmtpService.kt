package com.vinsonb.api.services

import com.vinsonb.api.routes.email.Email
import org.apache.commons.mail.DefaultAuthenticator
import org.apache.commons.mail.SimpleEmail

private const val USERNAME_KEY = "APP_SMTP_USERNAME"
private const val PASSWORD_KEY = "APP_SMTP_PASSWORD"
private const val HOST_KEY = "APP_SMTP_HOST"
private const val SMTP_PORT_KEY = "APP_SMTP_PORT"
private const val APP_TAG = "[portfolio-contact-form]"

object SmtpService {
    private val username = System.getenv(USERNAME_KEY)
    private val password = System.getenv(PASSWORD_KEY)
    private val host = System.getenv(HOST_KEY)
    private val port = System.getenv(SMTP_PORT_KEY).toInt()

    fun sendEmail(email: Email) {
        SimpleEmail().apply {
            isSSLOnConnect = true
            hostName = host
            setSmtpPort(port)
            setAuthenticator(DefaultAuthenticator(username, password))
            addTo(username)
            setFrom(username)
            subject = "$APP_TAG ${email.subject} (${email.name})"
            setMsg("From: ${email.name} (${email.fromEmail})\n\n${email.message}")
        }.send()
    }
}
