package com.irondnb.chat.server

import io.ktor.application.*
import io.ktor.http.cio.websocket.*
import io.ktor.routing.*
import io.ktor.websocket.*
import java.util.*


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    install(WebSockets)
    routing {
        val connections = Collections.synchronizedSet<Connection?>(LinkedHashSet())
        webSocket("/chat") {
            val connection = Connection(this)
            connections += connection
            try {
                send("You are connected! There are ${connections.count()} users here.")
                for(frame in incoming) {
                    frame as? Frame.Text ?: continue
                    val receivedText = frame.readText()
                    val textWithUserName = "[${connection.userName}]: $receivedText"
                    connections.forEach {
                        it.session.send(textWithUserName)
                    }
                }
            } catch (e: Exception) {
                log.error(e.localizedMessage)
            } finally {
                log.info("Removing $connection!")
                connections -= connection
            }
        }
    }
}
