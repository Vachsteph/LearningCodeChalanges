package game

fun main(args: Array<String>) {

    print("enter the word too guess: ")
    val word = readLine()
    if (word == null) {
        print("no word given")
        return
    }

    for (i in 1..100) {
        println()
    }

    val letters = word.lowercase().toCharArray().toHashSet()
    val correctGuesses = mutableSetOf<Char>()
    var fails = 0

    while (letters != correctGuesses) {
        printExploredWord(word, correctGuesses)
        println("#Wrong guesses: $fails\n")

        print("Guess letter: ")
        val input = readLine()
        if (input == null) {
            continue
        } else if (input.length != 1) {
            println("please write one letter")
            continue
        }
        if (word.lowercase().contains(input.lowercase())) {
            val c: Char = input[0]
            correctGuesses.add(c)
        } else {
            fails++
        }
    }

    printExploredWord(word, correctGuesses)

    println("Wrong guesses $fails\n\n")
    println("well done")
}


fun printExploredWord(Word: String, correctGuesses: MutableSet<Char>) {
    for (letter in Word.lowercase()) {
        if (correctGuesses.contains(letter)) {
            print(letter + " ")
        } else {
            print("_ ")
        }
    }

}