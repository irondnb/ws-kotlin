package com.irondnb.chat.server

import com.irondnb.chat.server.models.Server
import com.irondnb.chat.server.routes.chatRoute
import io.ktor.application.*
import io.ktor.routing.*
import io.ktor.websocket.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    install(WebSockets)
    val server = Server()

    routing {
        chatRoute(server)
    }
}
