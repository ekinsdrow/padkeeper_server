package online.padkeeper.v1.features.auth.routing

import io.ktor.application.*
import io.ktor.routing.*
import online.padkeeper.v1.features.auth.domain.JWTService
import online.padkeeper.v1.features.auth.login.domain.LoginController
import online.padkeeper.v1.features.auth.register.data.repositories.RegisterRepository
import online.padkeeper.v1.features.auth.register.data.sources.RegisterDatabaseClient
import online.padkeeper.v1.features.auth.register.domain.RegisterController
import org.jetbrains.exposed.sql.Database


fun Route.configureAuthRouting(
    jwtSecret: String,
    jwtIssuer: String,
    database: Database
) {
    val jwtService = JWTService(jwtSecret, jwtIssuer)
    val registerDatabaseClient = RegisterDatabaseClient(database)
    val registerRepository = RegisterRepository(registerDatabaseClient)


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