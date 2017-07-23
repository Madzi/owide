package owide.loader

object QspLoader {
    private val HEADER = "QSPGAME";
    private val NLCR = "\r\n"

    fun gamToTxt(gam: String): String {
        val lines = mutableListOf<String>()
        val lineIt = gam.split(NLCR).iterator()
        val hdr = lineIt.next()
        println("HEADER:::$hdr:::$HEADER::: ??? ${hdr == HEADER}")
        if (HEADER == hdr) {
            println("EDITOR")
            lines.add("@editor ${lineIt.next()}")
            println("PASSWORD")
            lineIt.next() // password
            var locsCount = lineIt.next().decrypt().toInt()
            println("Locations # $locsCount")
            while (locsCount > 0) {
                lines.add("@location(${lineIt.next().decrypt()}){${lineIt.next().decrypt()}}")
                lines.add(lineIt.next().decrypt()) // code
                var actsCount = lineIt.next().decrypt().toInt()
                while (actsCount > 0) {
                    lines.add("@action{${lineIt.next().decrypt()}}(${lineIt.next().decrypt()})")
                    lines.add(lineIt.next().decrypt()) // code
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
        return lines.joinToString(NLCR)
    }
}

fun String.decrypt(): String = this.map { ch -> ch + 5 }.joinToString("")
fun String.encrypt(): String = this.map { ch -> ch - 5 }.joinToString("")
