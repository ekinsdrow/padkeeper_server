package online.padkeeper.v1.features.auth.data.models
import kotlinx.serialization.Serializable

@Serializable
data class UserRegister(val email: String, val password: String, val username: String)
