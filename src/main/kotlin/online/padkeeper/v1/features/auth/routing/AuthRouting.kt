package online.padkeeper.v1.features.auth.routing

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import online.padkeeper.v1.features.auth.data.models.UserLogin
import online.padkeeper.v1.features.auth.data.models.UserRegister
import online.padkeeper.v1.features.auth.domain.JWTService

fun Route.registerAuthRouting(
    jwtSecret: String,
    jwtIssuer: String,
) {
    val jwtService = JWTService(jwtSecret, jwtIssuer)

    route("/auth") {
        post("register") {
            //TODO: create user and add him to database with token
            val user = call.receive<UserRegister>()
            val token = jwtService.createToken(user)
            call.respond(hashMapOf("access_token" to token))
        }

        post("login") {
            //TODO: get token and user from database
        }
    }
}