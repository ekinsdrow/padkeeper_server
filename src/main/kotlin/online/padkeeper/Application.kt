package online.padkeeper

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import online.padkeeper.v1.features.app.routing.registerV1Routing

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        registerV1Routing()
    }.start(wait = true)
}
