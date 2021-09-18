package com.example.controllers

import com.example.ChatService
import com.example.models.adapters.ChatMessageAdapter
import com.example.models.adapters.UserAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.tinder.scarlet.Scarlet
import com.tinder.scarlet.messageadapter.moshi.MoshiMessageAdapter
import com.tinder.scarlet.streamadapter.rxjava2.RxJava2StreamAdapterFactory
import com.tinder.scarlet.websocket.okhttp.newWebSocketFactory
import okhttp3.OkHttpClient
import tornadofx.Controller

class ChatController: ChatService, Controller() {
    private val okHttpClient = OkHttpClient.Builder()
        .build()

    private val moshi: Moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .add(UserAdapter())
        .add(ChatMessageAdapter())
        .build()

    private val scarletInstance = Scarlet.Builder()
        .webSocketFactory(okHttpClient.newWebSocketFactory("ws://0.0.0.0:8080/chat"))
        .addStreamAdapterFactory(RxJava2StreamAdapterFactory())
        .addMessageAdapterFactory(MoshiMessageAdapter.Factory(moshi))
        .build()


    private val chatService = scarletInstance.create<ChatService>()

    override fun observeWebSocketEvent() =  chatService.observeWebSocketEvent()
    override fun observeIncomingMessages() =  chatService.observeIncomingMessages()
    override fun sendMessage(message: String) = chatService.sendMessage(message)
}