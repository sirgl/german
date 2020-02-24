package german.utils

sealed class Res<out T, out E>

class Success<T>(val value: T): Res<T, Nothing>()

class Err<E>(val error: E): Res<Nothing, E>()

// Utilities

fun <T, E, R> Res<T, E>.map(f: (T) -> R): Res<R, E> {
    return when (this) {
        is Success -> Success(f(value))
        is Err -> this
    }
}

fun <T, E> Res<T, E>.unwrap(): T {
    return when (this) {
        is Success -> value
        is Err -> throw ValueIsAbsentException(error)
    }
}

fun <T, E> Res<T, E>.asNullable(): T? {
    return when (this) {
        is Success -> value
        is Err -> null
    }
}

fun <T, E> Res<T, E>.isOk() : Boolean = this is Success<*>
fun <T, E> Res<T, E>.isErr() : Boolean = this is Err<*>

fun <T, E> Res<T, E>.ok() : T? = (this as? Success)?.value

class ValueIsAbsentException(private val value: Any?): Exception() {
    override val message: String?
        get() = value.toString()
}