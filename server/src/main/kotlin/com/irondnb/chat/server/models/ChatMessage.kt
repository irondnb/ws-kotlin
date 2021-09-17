package com.irondnb.chat.server.models
import kotlinx.serialization.*

@Serializable
data class ChatMessage(
    val user: User,
    val message: String
)
