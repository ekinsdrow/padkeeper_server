package online.padkeeper.plugins

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {
    install(Locations) {
    }

    routing {
        get("/") {
            call.respondText("Hello, it is Padkeeper")
        }
    }
}