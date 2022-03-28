package online.padkeeper.v1.features.app.di

import io.ktor.application.*
import org.jetbrains.exposed.sql.Database


object AppDi {
    fun database(environment: ApplicationEnvironment): Database {
        val url = environment.config.property("database.url").getString()
        val user = environment.config.property("database.username").getString()
        val pass = environment.config.property("database.password").getString()

        return Database.connect(
            url, driver = "org.postgresql.Driver",
            user = user, password = pass
        )
    }

    fun jwtSecret(environment: ApplicationEnvironment): String {
        return environment.config.property("jwt.secret").getString()
    }

    fun jwtIssuer(environment: ApplicationEnvironment): String {
        return environment.config.property("jwt.issuer").getString()
    }

}