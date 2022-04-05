package online.padkeeper.v1.features.auth.register.data.models
import kotlinx.serialization.Serializable

@Serializable
data class UserRegister(val email: String, val password: String, val username: String)
