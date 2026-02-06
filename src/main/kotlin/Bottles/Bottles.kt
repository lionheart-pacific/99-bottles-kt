package Bottles

class Bottles {
    fun verse(number: Int): String = """
            ${capitalize(quantity(number))} ${container(number)} of beer on the wall, ${quantity(number)} ${container(number)} of beer.
            ${action(number)}, ${quantity(successor(number))} ${container(successor(number))} of beer on the wall.
            """.trimIndent() + "\n\n"

    fun verses(upper: Int, lower: Int): String {
        return (upper downTo lower).map { verse(it) }.joinToString("")
    }

    fun song(): String {
        return verses(99, 0)
    }

    private fun container(number: Int): String {
        return BottleNumber(number).container()
    }

    private fun quantity(number: Int): String {
        return BottleNumber(number).quantity()
    }

    private fun capitalize(word: String): String = word.replaceFirstChar { it.uppercase() }

    private fun action(number: Int): String {
        return BottleNumber(number).action()
    }

    private fun successor(number: Int): Int {
        return BottleNumber(number).successor(number)
    }
}
