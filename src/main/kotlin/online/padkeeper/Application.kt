package online.padkeeper

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*
import io.ktor.features.*
import io.ktor.serialization.*
import io.ktor.server.netty.*
import online.padkeeper.v1.features.app.routing.registerV1Routing

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    install(Authentication) {
        jwt {}
    }

    install(ContentNegotiation) {
        json()
    }

    registerV1Routing()
}

