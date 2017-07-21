package owide.files

object TypeResolver {

    // Maps of mime -> languageId
    val knownTypes = hashMapOf<String, String>(
            "text/javascript" to "javascript"
    )

    fun language(file: SimpleFile): String {
        return knownTypes.getOrDefault(file.mime, "")
    }
}