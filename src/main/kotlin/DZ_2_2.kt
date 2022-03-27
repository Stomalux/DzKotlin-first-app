// Задача 2 - люди - человеки

// В сочетании с числительным (независимо от того,
// насколько число большое) - слово ЧЕЛОВЕК.
// В сочетании с существительным,
// которое только похоже на числительное, - слово ЛЮДИ.

const val CHELOVEK = "человек"
const val CHELOVEKA = "человека"

fun main() {
    print("Введите количество лайков: ")
    val likes = readln().toInt()
//println(" по проценту $lastDigit")
    val lastDigit = likes % 10

    if (lastDigit >= 2 && lastDigit <= 4) {
        println("Вам поставили лайки $likes  $CHELOVEKA !")
    } else {
        println("Вам поставили лайки $likes  $CHELOVEK !")
    }
    if (lastDigit == 1) println("Понравилось $likes  человеу !")

    if(lastDigit >= 2) println("Понравилось $likes  людям !")
    if(lastDigit == 0) println("Никому не понравилось!")
}



// последний символ в строке по длине строки  - 1
//val likeString = likes.toString()
// val lastChar: Char = likeString[(likeString.count() - 1)]
// println(lastChar)



