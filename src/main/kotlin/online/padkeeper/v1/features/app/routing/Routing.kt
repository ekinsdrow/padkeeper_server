package online.padkeeper.v1.features.app.routing

import io.ktor.application.*
import io.ktor.routing.*
import online.padkeeper.v1.features.auth.routing.registerAuthRouting
import online.padkeeper.v1.features.user.routing.registerUserRouting


fun Application.registerV1Routing() {
    routing {
        route("/api") {
            route("/v1") {
                registerAuthRouting()
                registerUserRouting()
            }
        }
    }
}
