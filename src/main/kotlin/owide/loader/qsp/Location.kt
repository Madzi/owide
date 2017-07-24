package owide.loader.qsp

class Location() : Storable {
    var name = "noname"
    var description = ""
    var code = ""
    val actions = mutableListOf<Action>()

    fun addAction(action: Action) = actions.add(action)

    override fun toSave(): String {
        return ""
    }

    override fun toText(): String {
        return "@location($name)" +
                (if (description.isEmpty()) "\n" else "[\n$description\n]\n") +
                "$code\n" +
                actions.map { it.toText() }.joinToString { "" } +
                "\n"
    }

}
