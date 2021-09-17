package com.irondnb.chat.server

import com.irondnb.chat.server.models.User
import io.ktor.http.cio.websocket.*
import java.util.concurrent.atomic.AtomicInteger

class Connection(val session: DefaultWebSocketSession) {
    companion object {
        var lastId = AtomicInteger(0)
    }

    val user = User(lastId.getAndIncrement(), "User")
}