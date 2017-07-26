package owide.loader

import owide.loader.qsp.Action
import owide.loader.qsp.Game
import owide.loader.qsp.Location

object QspLoader {
    private val HEADER = "QSPGAME";
    private val NLCR = "\r\n"

    fun gamToTxt(gam: String): String {
        val lineIt = gam.split(NLCR).iterator()

        val hdr = lineIt.next()
        if (HEADER == hdr) {

            val editor = lineIt.next()

            val gamePwd = lineIt.next().decrypt()
            println(gamePwd)
            if (gamePwd.isNotEmpty()) {
                val userPwd: String = js("prompt('Password','')")
                if (userPwd != gamePwd) {
                    return "-- Wrong password --"
                }
            }

            val game = Game()
            game.editor = editor

            var locCount = lineIt.next().decrypt().toInt()
            println("Locations # $locCount")

            while (locCount > 0) {
                val location = Location()
                location.name = lineIt.next().decrypt()
                location.description = lineIt.next().decrypt()
                location.code = lineIt.next().decrypt()

                var actCount = lineIt.next().decrypt().toInt()
                while (actCount > 0) {
                    val action = Action()
                    action.icon = lineIt.next().decrypt()
                    action.name = lineIt.next().decrypt()
                    action.code = lineIt.next().decrypt()

                    location.addAction(action)
                    actCount--
                }

                game.addLocation(location)
                locCount--
            }
            return game.toText()
        }
        return "-- Unsupported file format --"
    }

    fun txtToGam(txt: String): String {
        // make the Game
        val game = parse(txt)
        val pwd: String = js("prompt('Password (keep empty if not needed)', '')")
        val lines = mutableListOf<String>()
        lines.add(HEADER)

        lines.add(game.editor)
        lines.add(pwd.encrypt())

        lines.add(game.locations.size.toString().encrypt())

        for (location in game.locations) {
            lines.add(location.name.encrypt())
            lines.add(location.description.encrypt())
            lines.add(location.code.encrypt())

            lines.add(location.actions.size.toString().encrypt())

            for (action in location.actions) {
                lines.add(action.icon.encrypt())
                lines.add(action.name.encrypt())
                lines.add(action.code.encrypt())
            }
        }
        return lines.joinToString(NLCR)
    }

    private fun parse(text: String): Game {
        return Game()
    }

}

fun String.decrypt(): String = this.map { ch -> ch + 5 }.joinToString("")
fun String.encrypt(): String = this.map { ch -> ch - 5 }.joinToString("")
