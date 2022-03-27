// Денежные переводы

const val commissionConst = 0.0075 // Комиссия - 0.75%
const val commissionMin: Int = 3500   // Минимальная комиссия


fun main() {
    val commission: Int
    print("Введите сумму перевода в копейках: ")
    val commissionOtSumKop = readln().toInt() * commissionConst
    val commissionOtSumKopInt: Int = commissionOtSumKop.toInt()
    if (commissionOtSumKopInt <= commissionMin) commission = commissionMin else commission = commissionOtSumKopInt
    println("Итоговая сумма комиссиии в копейках: $commission")
}