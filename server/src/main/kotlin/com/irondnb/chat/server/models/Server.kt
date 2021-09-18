package com.irondnb.chat.server.models

import com.irondnb.chat.server.Connection
import io.ktor.http.cio.websocket.*
import java.util.*

class Server {
    val connections: MutableSet<Connection> = Collections.synchronizedSet(LinkedHashSet())

    fun add(connection: Connection) {
        connections += connection
    }

    fun remove(connection: Connection) {
        connections -= connection
    }

    suspend fun broadcast(message: String) {
        connections.forEach {
            it.session.send(message)
        }
    }
}