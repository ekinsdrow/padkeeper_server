package online.padkeeper.v1.features.auth.domain

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import online.padkeeper.v1.common.utils.isValidEmail
import online.padkeeper.v1.common.utils.isValidPassword
import online.padkeeper.v1.common.utils.isValidUserName
import online.padkeeper.v1.features.auth.data.models.UserRegister

class RegisterController(private val call: ApplicationCall, private val jwtService: JWTService) {
    suspend fun registerNewUser() {
        val user = call.receive<UserRegister>()

        if (!user.email.isValidEmail()) {
            call.respond(HttpStatusCode.UnprocessableEntity, "Email not valid")
        } else if (!user.password.isValidPassword()) {
            call.respond(HttpStatusCode.UnprocessableEntity, "Password is too short")
        } else if (!user.username.isValidUserName()) {
            call.respond(HttpStatusCode.UnprocessableEntity, "Username is too short")
        } else {
            val token = jwtService.createToken(user)
            call.respond(hashMapOf("access_token" to token))
        }

    }
}