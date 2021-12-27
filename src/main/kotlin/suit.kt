import java.util.Random

const val choices = "bkge"
val rand = Random()

var pWins = 0
var cWins = 0
var draws = 0
var games = 0
val pFreqs = arrayOf(0, 0, 0)

fun printScore() = println("Skor: Kamu $pWins, PC $cWins, Seri $draws\n")

fun getComputerChoice(): Char {
    if (games < 3) return choices[rand.nextInt(3)]
    val num = rand.nextInt(games)
    return when {
        num < pFreqs[0] -> 'k'
        num < pFreqs[0] + pFreqs[1] -> 'g'
        else -> 'b'
    }
}

fun main(args: Array<String>) {
    println("=============GAME SUIT TERMINAL VERSION=================")
    println("Ayo Bertarung! : (b)atu, (k)ertas, (g)unting or (e)xit\n")
    while (true) {
        printScore()
        var pChoice: Char
        while (true) {
            print("Kamu Memilih b/k/g/e : ")
            val input = readLine()!!.toLowerCase()
            if (input.length == 1) {
                pChoice = input[0]
                if (pChoice in choices) break
            }
            println("Salah, Ayo coba lagi!")
        }
        if (pChoice == 'e') {
            println("OK, Sampai Jumpa!")
            return
        }
        if (pChoice == 's') {
            println("Pertarungan Dimulai!")
            return


        }
        val cChoice = getComputerChoice()
        println("Computer's choice   : $cChoice")
        if (pChoice == 'b' && cChoice == 'g') {
            println("Batu menghancurkan Gunting - Kamu Menang!")
            pWins++
        }
        else if (pChoice == 'k' && cChoice == 'b') {
            println("Kertas menyelimuti Batu - Kamu Menang!")
            pWins++
        }
        else if (pChoice == 'g' && cChoice == 'k') {
            println("Gunting membelah Kertas - Kamu Menang!")
            pWins++
        }
        else if (pChoice == 'g' && cChoice == 'b') {
            println("Batu menghancurkan Gunting - PC Menang!")
            cWins++
        }
        else if (pChoice == 'b' && cChoice == 'k') {
            println("Kertas menyelimuti Batu - PC Menang!")
            cWins++
        }
        else if (pChoice == 'k' && cChoice == 'g') {
            println("Gunting membelah Kertas - PC Menang!")
            cWins++
        }
        else {
            println("Wah.. Kalian Seri!")
            draws++
        }
        pFreqs[choices.indexOf(pChoice)]++
        games++
        println()
    }
}