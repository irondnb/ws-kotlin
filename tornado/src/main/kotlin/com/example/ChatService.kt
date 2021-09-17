package com.example

import com.example.models.ChatMessage
import com.tinder.scarlet.WebSocket
import com.tinder.scarlet.ws.Receive
import com.tinder.scarlet.ws.Send
import io.reactivex.Flowable
import kotlinx.coroutines.flow.Flow

interface ChatService {
    @Receive
    fun observeWebSocketEvent(): Flowable<WebSocket.Event>
    @Receive
    fun observeIncomingMessages(): Flowable<WebSocket.Event>
    @Send
    fun sendMessage(message: String)
}