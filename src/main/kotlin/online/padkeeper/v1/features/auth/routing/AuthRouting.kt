package online.padkeeper.v1.features.auth.routing

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import online.padkeeper.v1.features.auth.data.models.UserRegister
import online.padkeeper.v1.features.auth.data.repositories.AuthRepository
import online.padkeeper.v1.features.auth.data.sources.AuthDatabaseClient
import online.padkeeper.v1.features.auth.domain.JWTService
import online.padkeeper.v1.features.auth.domain.LoginController
import online.padkeeper.v1.features.auth.domain.RegisterController
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
            val registerController = RegisterController(call, jwtService)
            registerController.registerNewUser()
        }

        post("login") {
            val loginController = LoginController(call)
            loginController.login()
        }
    }
}