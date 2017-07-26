package owide.loader.qsp

class Game : Storable {
    var editor = "OWIDE 0.0.1.alpha"
    val locations = mutableListOf<Location>()

    fun addLocation(location: Location) = locations.add(location)

    override fun toSave(): String {
        return ""
    }

    override fun toText(): String {
        return "@editor(${editor})\n\n" +
                locations.map { it.toText() }.joinToString("") +
                "\n"
    }

}