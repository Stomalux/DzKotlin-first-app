var minHour: Int = 0
var lastDigit = 0

fun main() {
    print("Введите количество секунд: ")
    val seconds = readln().toInt()

    when (seconds) {
        in 0..60 -> print("Пользователь был только что.")// до минуты
        in 61..3600 -> {                        //in 61..3600 -> print("х минут назад.")// до часа
            minHour = seconds / 60
            lastDigit = (seconds / 60) % 10
            val minHourAll = minut(lastDigit)
            print("Пользователь был $minHour $minHourAll назад.")
        }
        in 3601..86400 -> {                   // часов назад до сутки
            minHour = seconds / 60 / 60
            lastDigit = (seconds / 60 / 60) % 10
            val minHourAll = hour(lastDigit)
            print("Пользователь был $minHour $minHourAll назад.")
        }
        in 86401..172800 -> print("Пользователь был сегодня.")//меньше 2 сут
        in 172801..259200 -> print("Пользователь был вчера.")//меньше 3 сут
        else -> print("Пользователь был давно.")
    }
}

fun hour(lastDigit: Int): String {
    when (lastDigit) {
        1 -> return "час"
        in 2..4 -> return "часа"
        else -> return "часов"
    }
}

fun minut(lastDigit: Int): String {
    when (lastDigit) {
        1 -> return "минуту"
        in 2..4 -> return "минуты"
        else -> return "минут"
    }
}
