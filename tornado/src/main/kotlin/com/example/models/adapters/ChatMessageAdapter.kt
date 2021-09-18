package com.example.models.adapters

import com.example.models.ChatMessage
import com.example.models.User
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ChatMessageJson(
    val user: User,
    val message: String
)

class ChatMessageAdapter {
    @FromJson
    fun fromJson(messageJson: ChatMessageJson): ChatMessage {
        return ChatMessage(messageJson.user, messageJson.message)
    }
}