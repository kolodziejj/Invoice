fun check(toCheck: String): Boolean {
    return toCheck.toDoubleOrNull() != null
}

fun checkString(toCheck: String): Boolean {
    return toCheck.toDoubleOrNull() == null
}

