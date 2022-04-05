package online.padkeeper.v1.features.auth.login.domain

import io.ktor.application.*

class LoginController(private val call: ApplicationCall) {
    fun login() {
        //TODO: get token and user from database
    }
}