// Meloman
import kotlin.random.Random

const val PRISE = 100
const val BORDERSONE = 1001
const val BORDERSTU = 10001
const val DISCOUNTPROCENT = 0.05
const val DISCOUNTMELOMAN = 0.01
//public val discount: Double = 0.0

fun main() {
    var discount: Double = 0.0
    var discountMeloman: Double = 0.0
    var itog: Double = 0.0
    print("Введите количество композиций: ")
    val count = readln().toInt()
    val totalPrice = count * PRISE
    println("Сумма покупки составляет $totalPrice руб.")
    val meloman = Random.nextBoolean()
    //println(meloman)
    if (meloman) println("У вас есть скидка за предыдущие покупки!")
    else println("У вас нет скидки за предыдущие покупки!")

    if (totalPrice >= BORDERSTU) {
        discount = totalPrice * DISCOUNTPROCENT
        println("Вы преобретаете товар на сумму больше 10_000 руб.")
        println("Ваша скидка от стоимости товара 5% от суммы ${discount.toInt()} руб.")
    }
    if (totalPrice >= BORDERSONE && totalPrice < BORDERSTU) {
        discount = 100.0
        println("Вы преобретаете товар на сумму больше 1_001 руб.")
        println("Ваша скидка от стоимости товара ${discount.toInt()} руб.")
    }
    if (totalPrice < BORDERSONE) {
        discount = 0.0
        println("Вы преобретаете товар на сумму меньше 1_001 руб.")
        println("У вас нет скидки от стоимости товара.")
    }
    val priceMinDiscount = totalPrice - discount
    if (meloman) {
        discountMeloman = (totalPrice - discount) * DISCOUNTMELOMAN
        println("Скидка по предыдущим покупкам: ${discountMeloman.toInt()} руб.")
        itog = totalPrice - discount - discountMeloman
        println("Всего к оплате: ${itog.toInt()}  руб.")

    } else {
        itog = totalPrice - discount - discountMeloman
        println("Всего к оплате: ${itog.toInt()}  руб.")
    }
}