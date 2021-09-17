package com.irondnb.chat.server.models

import kotlinx.serialization.*

@Serializable
data class User(val id: Int, val name: String = "User")
