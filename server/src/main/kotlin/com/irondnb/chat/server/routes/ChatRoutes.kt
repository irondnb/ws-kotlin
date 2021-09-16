package com.irondnb.chat.server.routes

import com.irondnb.chat.server.Connection
import com.irondnb.chat.server.Server
import com.irondnb.chat.server.messageHandler
import io.ktor.http.cio.websocket.*
import io.ktor.routing.*
import io.ktor.websocket.*

fun Route.chatRoute(server: Server) {
    webSocket("/chat") {
        val connection = Connection(this)
        server.connections += connection
        try {
            send("You are connected! There are ${server.connections.count()} users here.")
            for(frame in incoming) {
                frame as? Frame.Text ?: continue
                messageHandler(connection, frame.readText(), server)
            }
        } catch (e: Exception) {
            log.error(e.localizedMessage)
        } finally {
            log.info("Removing $connection!")
            server.connections -= connection
        }
    }
}