package online.padkeeper.v1.features.user.routing

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.registerUserRouting() {
    route("/user") {
        get {
            call.respond("User Route")
        }
    }
}