import java.io.File

fun deleteInvoice(): Int {
    var tab = Array<String>(100) { "it = $it" }
    var i: Int = 0
    var userChoice: Int = 1
    val path = System.getProperty("user.dir")
    File(path).walk().forEach {
        var txt = File(it.toString()).extension
        if (txt == "txt") {
            tab[i] = it.toString()
            println(it.toString() + " - $userChoice")
            userChoice++
            i++
        }
    }
    if (i == 0) {
        println("No invoices found")
    }
    println("Please type number of invoice you want to delete")
    userChoice = readln().toInt()
    if (userChoice > i) {
        println("This invoice doesn't exist")
        return deleteInvoice()
    } else if (userChoice <= 0) {
        println("Please enter number bigger than 0")
        return deleteInvoice()
    }

    if (userChoice == 1) {
        userChoice = 0
    } else {
        userChoice--
    }

    File(tab[userChoice]).delete()
    println("Invoice has been delete")

    println("Press Enter to continue")
    try {
        System.`in`.read()
        return options()
    } catch (e: Exception) {
    }
    return 0
}