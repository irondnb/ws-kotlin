package com.irondnb.chat.server

import com.irondnb.chat.server.models.ChatMessage
import com.irondnb.chat.server.models.User
import kotlinx.serialization.*
import kotlinx.serialization.json.*

suspend fun messageHandler(user: User, message: String, server: Server) {
    val outgoingMessage = ChatMessage(user, message)
    server.broadcast(Json.encodeToString(outgoingMessage))
}
