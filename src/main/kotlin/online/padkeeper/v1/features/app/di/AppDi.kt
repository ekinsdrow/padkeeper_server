package online.padkeeper.v1.features.app.di

import io.ktor.application.*
import org.jetbrains.exposed.sql.Database
import java.nio.file.Paths


object AppDi {
    fun database(environment: ApplicationEnvironment): Database {
        val path = environment.config.property("database.path").getString()

        return Database.connect("jdbc:sqlite:$path", "org.sqlite.JDBC")
    }

    fun jwtSecret(environment: ApplicationEnvironment): String {
        return environment.config.property("jwt.secret").getString()
    }

    fun jwtIssuer(environment: ApplicationEnvironment): String {
        return environment.config.property("jwt.issuer").getString()
    }

}