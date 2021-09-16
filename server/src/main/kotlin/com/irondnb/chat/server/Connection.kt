package com.irondnb.chat.server

import io.ktor.http.cio.websocket.*
import java.util.concurrent.atomic.AtomicInteger

class Connection(val session: DefaultWebSocketSession) {
    companion object {
        var lastId = AtomicInteger(0)
    }

    val userName = "user#${lastId.getAndIncrement()}"
}