package owide.loader.qsp

import owide.loader.encrypt

class Action() : Storable {
    var name = ""
    var icon = ""
    var code = ""

    override fun toText(): String {
        return "@action($name)" +
                (if (icon.isEmpty()) "\n" else "[$icon]\n") +
                "$code\n\n"
    }

    override fun toSave(): String {
        return arrayOf(
                icon.encrypt(),
                name.encrypt(),
                code.encrypt()
        ).joinToString("\r\n")
    }

}