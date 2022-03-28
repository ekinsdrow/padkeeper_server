package online.padkeeper.v1.features.auth.routing

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import online.padkeeper.v1.features.auth.data.models.UserRegister
import online.padkeeper.v1.features.auth.data.repositories.AuthRepository
import online.padkeeper.v1.features.auth.data.sources.AuthDatabaseClient
import online.padkeeper.v1.features.auth.domain.JWTService
import org.jetbrains.exposed.sql.Database

fun Route.registerAuthRouting(
    jwtSecret: String,
    jwtIssuer: String,
    database: Database
) {
    val jwtService = JWTService(jwtSecret, jwtIssuer)
    val authDatabaseClient = AuthDatabaseClient(database)
    val authRepository = AuthRepository(authDatabaseClient)

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