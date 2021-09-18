package com.example.controllers

import com.example.models.ChatMessage
import com.tinder.scarlet.Message.Text
import com.tinder.scarlet.WebSocket.Event.OnMessageReceived
import javafx.collections.FXCollections
import tornadofx.Controller
import tornadofx.runLater

class AppController: Controller() {
    val chatMessages = FXCollections.observableArrayList<String>()

    val chatService:  ChatController by inject()

    fun connect() {

        chatService.observeWebSocketEvent().subscribe { event ->
            println(event)
        }

        chatService.observeIncomingMessages().subscribe { message ->
            append(message)
        }
    }


    fun append(message: ChatMessage) {
        runLater {
            chatMessages += "${message.user}: ${message.message}"
        }
    }
}
