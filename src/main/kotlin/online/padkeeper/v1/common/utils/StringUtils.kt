package online.padkeeper.v1.common.utils

fun String.isValidEmail(): Boolean {
    val regex = Regex("^[a-zA-Z0-9.!#\$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*\$")
    return regex.matches(this)
}

fun String.isValidPassword(): Boolean{
    return this.length > 7
}

fun String.isValidUserName(): Boolean{
    return this.length > 2
}