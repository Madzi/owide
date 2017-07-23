package owide.files

object TypeResolver {

    // Maps of mime -> languageId
    val knownTypes = mapOf<String, String>(
            "application/x-javascript" to "javascript",
            "application/x-markdown" to "markdown",
            "application/x-qsp" to "qsp",
            "text/css" to "css",
            "text/html" to "html",
            "text/xml" to "xml"
    )

    fun language(file: SimpleFile): String {
        println(knownTypes)
        var lang = knownTypes.get(file.mime)
        if (lang == null) {
            lang = ""
        }
        println(" >>> ${file.mime} >>> $lang >>> ")
        return lang
    }
}