import java.io.File

fun invoiceCountFile(): Int {
    val path = System.getProperty("user.dir")
    var i: String
    var fileName = "InvoiceCount" + ".cfg"
    var file = File(fileName)
    File(path).walk().forEach {
        i = it.toString()
        if (isFileExists(file)) {
            return options()
        } else {
            file.createNewFile()
            file.writeText("0")
            return options()
        }
    }
    return 0
}

fun readFile(fileName: String): Int {
    var fileName = "InvoiceCount" + ".cfg"
    var file = File(fileName)
    var invoiceCount = 0

    file.forEachLine { invoiceCount = it.toInt() }
    return invoiceCount
}

fun invoiceCountpp(): Int {

    var fileName = "InvoiceCount" + ".cfg"
    var currentCount: Int = readFile(fileName)
    currentCount++
    var file = File(fileName)

    file.writeText("$currentCount")

    return invoiceCountFile()

}

fun isFileExists(file: File): Boolean {
    return file.exists() && !file.isDirectory
}