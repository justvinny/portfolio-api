package com.vinsonb.api.routes.email

import kotlinx.serialization.Serializable

@Serializable
data class Email(
    val fromEmail: String,
    val name: String,
    val subject: String,
    val message: String
)
