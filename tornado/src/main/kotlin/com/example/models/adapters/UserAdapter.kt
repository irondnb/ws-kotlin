package com.example.models.adapters

import com.example.models.User
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class UserJson(
    val id: Int
)

class UserAdapter {
    @FromJson
    fun fromJson(userJson: UserJson): User {
        return User(userJson.id)
    }
}