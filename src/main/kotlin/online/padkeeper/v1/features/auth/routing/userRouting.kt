package online.padkeeper.v1.features.auth.routing

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.registerAuthRouting() {
    route("/auth") {
        get {
            call.respond("Auth Route")
        }
    }
}