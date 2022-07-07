import java.io.File

fun printInvoiceList(): Int {
    var i: Int = 0
    val path = System.getProperty("user.dir")
    File(path).walk().forEach {
        var txt = File(it.toString()).extension
        if (txt == "txt") {
            println(File(it.toString()))
            i++
        }
    }
    if (i == 0) {
        println("No invoices found")
    }
    println("Press Enter to continue")
    try {
        System.`in`.read()
        return options()
    } catch (e: Exception) {
    }
    return 0
}