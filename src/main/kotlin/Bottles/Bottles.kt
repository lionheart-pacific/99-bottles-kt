package Bottles

class Bottles {
    fun verse(number: Int): String {
        return when (number) {
            0 -> """
                ${capitalize(quantity(number))} ${container(number)} of beer on the wall, ${quantity(number)} ${container(number)} of beer.
                ${action(number)}, ${quantity(successor(number))} ${container(successor(number))} of beer on the wall.
                """.trimIndent() + "\n\n"

            else -> """
                ${capitalize(quantity(number))} ${container(number)} of beer on the wall, ${quantity(number)} ${container(number)} of beer.
                ${action(number)}, ${quantity(successor(number))} ${container(successor(number))} of beer on the wall.
                """.trimIndent() + "\n\n"
        }
    }

    fun verses(upper: Int, lower: Int): String {
        return (upper downTo lower).map { verse(it) }.joinToString("")
    }

    fun song(): String {
        return verses(99, 0)
    }

    private fun container(number: Int): String {
        if (number == 1) return "bottle"
        return "bottles"
    }

    private fun pronoun(number: Int): String {
        if (number == 1) return "it"
        return "one"
    }

    private fun quantity(number: Int): String {
        if (number == 0) return "no more"
        return number.toString()
    }

    private fun capitalize(word: String): String = word.replaceFirstChar { it.uppercase() }

    private fun action(number: Int): String {
        if (number == 0) return "Go to the store and buy some more"
        return """Take ${pronoun(number)} down and pass it around"""
    }

    private fun successor(number: Int): Int {
        if (number == 0) return 99
        return (number - 1)
    }
}
