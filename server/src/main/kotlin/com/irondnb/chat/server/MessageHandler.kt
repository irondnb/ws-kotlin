package com.irondnb.chat.server

suspend fun messageHandler(connection: Connection, message: String, server: Server) {
    val textWithUserName = "[${connection.userName}]: $message"
    server.broadcast(textWithUserName)
}
