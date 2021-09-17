package com.example.controllers

import javafx.scene.control.TextArea
import tornadofx.Controller

class SubmitFormController: Controller() {
    val chatService:  ChatController by inject()

    fun submit(textField: TextArea) {
        val message = textField.text
        if (message.isNotBlank())
            chatService.sendMessage(message)
            textField.text = ""
    }
}
