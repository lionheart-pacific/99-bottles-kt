package Bottles

class BottleNumber(val number: Int) {

    fun quantity(): String {
        if (number == 0) return "no more"
        return number.toString()
    }

    fun container(): String {
        if (number == 1) return "bottle"
        return "bottles"
    }

    fun action(number: Int? = null): String {
        if (this.number == 0) return "Go to the store and buy some more"
        return """Take ${pronoun()} down and pass it around"""
    }

    fun pronoun(): String {
        if (this.number == 1) return "it"
        return "one"
    }

    fun successor(number: Int): Int {
        if (number == 0) return 99
        return (number - 1)
    }
}