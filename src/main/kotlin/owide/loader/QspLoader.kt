package owide.loader

object QspLoader {
    private val HEADER = "QSPGAME";
    private val CRNL = "\n\r"
    fun gamToTxt(gam: String): String {
        val lines = mutableListOf<String>()
        val lineIt = gam.split(CRNL).iterator()
        if (HEADER == lineIt.next()) {
            lines.add("@editor ${lineIt.next()}")
            lineIt.next() // password
            var locsCount = lineIt.next().decrypt().toInt()
            while (locsCount > 0) {
                lines.add("@location(${lineIt.next()}){${lineIt.next()}}")
                lines.add(lineIt.next()) // code
                var actsCount = lineIt.next().decrypt().toInt()
                while (actsCount > 0) {
                    lines.add("@action{${lineIt.next()}}(${lineIt.next()})")
                    lines.add(lineIt.next()) // code
                    actsCount--
                }
                locsCount--
            }
        } else {
            lines.add("-- Unsupported file format --")
        }
        return lines.joinToString("\n")
    }
    fun txtToGam(txt: String): String {
        val lines = mutableListOf<String>()
        return lines.joinToString(CRNL)
    }
}

fun String.decrypt(): String = this.map { ch -> ch - 5 }.toString()
fun String.encrypt(): String = this.map { ch -> ch + 5 }.toString()
