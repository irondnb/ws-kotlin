package com.example.controllers

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
            when(event) {
               is OnMessageReceived -> append(event.message as Text)
               else -> println(event)
            }
        }
    }

    fun append(message: Text) {
        runLater {
            chatMessages += message.value
        }
    }
}
