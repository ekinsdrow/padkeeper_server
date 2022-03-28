package online.padkeeper.v1.features.app.routing

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.routing.*
import online.padkeeper.v1.features.auth.routing.registerAuthRouting
import online.padkeeper.v1.features.user.routing.registerUserRouting


fun Application.registerV1Routing() {

    val jwtSecret = environment.config.property("jwt.secret").getString()
    val jwtIssuer = environment.config.property("jwt.secret").getString()

    routing {
        route("api") {
            route("/v1") {
                registerAuthRouting(jwtSecret, jwtIssuer)
                authenticate {
                    registerUserRouting()
                }
            }
        }
    }
}
