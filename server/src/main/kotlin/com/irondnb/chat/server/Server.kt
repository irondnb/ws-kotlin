package com.irondnb.chat.server

import io.ktor.http.cio.websocket.*
import java.util.*

class Server {
    val connections: MutableSet<Connection> = Collections.synchronizedSet(LinkedHashSet())

    suspend fun broadcast(message: String) {
        connections.forEach {
            it.session.send(message)
        }
    }
}