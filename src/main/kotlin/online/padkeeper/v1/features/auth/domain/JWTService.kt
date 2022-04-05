package online.padkeeper.v1.features.auth.domain

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import online.padkeeper.v1.features.auth.register.data.models.UserRegister

class JWTService(
    secret: String,
    private val issuer: String,
) {

    private val algorithm = Algorithm.HMAC512(secret)


    fun createToken(userRegister: UserRegister): String = JWT.create()
        .withSubject("Authentication")
        .withIssuer(issuer)
        .withClaim("email", userRegister.email)
        .withClaim("password", userRegister.password)
        .sign(algorithm)
}