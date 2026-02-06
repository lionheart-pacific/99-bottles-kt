package Bottles

class BottleNumber(val number: Int) {

    fun quantity(number: Int): String {
        if (number == 0) return "no more"
        return number.toString()
    }

    fun container(number: Int): String {
        if (number == 1) return "bottle"
        return "bottles"
    }

    private fun action(number: Int): String {
        if (number == 0) return "Go to the store and buy some more"
        return """Take ${pronoun(number)} down and pass it around"""
    }

    private fun pronoun(number: Int): String {
        if (number == 1) return "it"
        return "one"
    }

    private fun successor(number: Int): Int {
        if (number == 0) return 99
        return (number - 1)
    }
}