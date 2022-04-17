// Определение комиссии перевода и его возможности
const val commisConst = 0.0075 // Комиссия - 0.75%
const val commisConstM = 0.006 // Комиссия - 0.6%
const val commisMin: Int = 3500   // Минимальная комиссия
const val commisD: Int = 2000   //  комиссия +20 руб
var tipKard: String = "1"
var ok: Boolean = true
var comisKop = 0

////////////////////////////////////////////////////////////////////////
fun main() {
//////////////////////////////
    do {
        println(
            "Введите тип карты:\n  Mastercard,\n" + "  Maestro,\n" + "  Visa,\n" + "  Mir,\n" + "  VK_Pay:"
        )
        tipKard = readln()
    } while (tipKard != "Mastercard" && tipKard != "Maestro" && tipKard != "Visa" && tipKard != "Mir" && tipKard != "VK_Pay")
    print("Введите сумму предыдущего перевода в копейках: ")
    val summOld = readln().toInt()
    print("Введите сумму перевода в копейках: ")
    val summNew = readln().toInt()
///////////////////////////////
    if (summNew <= 15000000 && (summNew + summOld) <= 60000000) {
        comisKop = commission(tipKard, summOld, summNew)
    } else {
        ok = false
        comisKop = 0
        println("Превышен суточный/месячный лимит по карте!")
    }
///////////////////////////////
    if (ok) println("Итоговая сумма комиссиии в копейках: $comisKop")
    else println("Перевод отклонен!")
}

///////////////////////////////////////////////////////////////////////////////////////////
fun commission(tipKard: String, summOld: Int, summNew: Int): Int {
    var comissionKop = 0
    when (tipKard) {
        "VK_Pay" -> {
            println(tipKard)
            if (summNew >= 1500000 || (summNew + summOld) >= 4000000) {
                println("Превышен суточный/месячный лимит по аккаунту!")
                ok = false
            }
        }
        "Maestro", "Mastercard" -> {
            println(tipKard)
            if ((summNew + summOld) <= 7500000) {
                println("комиссии нет!")
                comissionKop = 0
                ok = true
            } else comissionKop = (summNew * commisConstM + commisD).toInt()
        }
        "Visa", "Mir" -> {
            println(tipKard)
            val commissionOtSum = (summNew * commisConst).toInt()
            comissionKop = if (commissionOtSum <= commisMin) commisMin else commissionOtSum
        }
    }
    return comissionKop
}