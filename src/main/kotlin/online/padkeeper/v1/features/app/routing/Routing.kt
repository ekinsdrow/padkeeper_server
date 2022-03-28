package online.padkeeper.v1.features.app.routing

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.routing.*
import online.padkeeper.v1.features.app.di.AppDi
import online.padkeeper.v1.features.auth.routing.registerAuthRouting
import online.padkeeper.v1.features.user.routing.registerUserRouting


fun Application.registerV1Routing() {
    val jwtSecret = AppDi.jwtSecret(environment)
    val jwtIssuer = AppDi.jwtIssuer(environment)
    val database = AppDi.database(environment)

    routing {
        route("api") {
            route("/v1") {
                registerAuthRouting(jwtSecret, jwtIssuer, database)
                authenticate {
                    registerUserRouting()
                }
            }
        }
    }
}
