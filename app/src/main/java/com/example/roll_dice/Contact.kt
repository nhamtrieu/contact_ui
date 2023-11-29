package com.example.roll_dice

import java.io.Serializable
import java.util.UUID

data class Contact(
    val name: String,
    val phoneNumber: String,
    val email: String,
    val id: String = UUID.randomUUID().toString(),

): Serializable
