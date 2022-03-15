package online.padkeeper.v1.features.auth.data.models
import kotlinx.serialization.Serializable

@Serializable
data class UserLogin(val email: String, val password: String)
