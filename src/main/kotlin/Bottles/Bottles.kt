package Bottles

class Bottles {
    fun verse(number: Int): String {
        return """
            ${firstLine(number)}
            ${secondLine(number)}
            """.trimIndent() + "\n\n"
    }

    fun verses(upper: Int, lower: Int): String {
        var cur = upper
        var result = ""
        while (cur >= lower) {
            result += verse(cur)
            cur -= 1
        }
        return result
    }

    fun song(): String {
        TODO("Don't forget about me!")
    }

    private fun firstLine(number: Int): String {
        if (number == 0) {
            return "No more bottles of beer on the wall, no more bottles of beer."
        }
        return "${bottles(number)} of beer on the wall, ${bottles(number)} of beer."
    }

    private fun secondLine(number: Int): String {
        if (number == 0) {
            return "Go to the store and buy some more, 99 bottles of beer on the wall."
        }
        return "${take(number)} down and pass it around, ${bottles(number - 1)} of beer on the wall."
    }

    private fun bottles(number: Int): String {
        if (number == 1) {
            return "1 bottle"
        }
        if (number == 0) {
            return "no more bottles"
        }
        return "$number bottles"
    }

    private fun take(number: Int): String {
        if (number == 1) {
            return "Take it"
        }
        return "Take one"
    }

}
