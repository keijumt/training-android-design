package keijumt.trainingandroiddesign.util

import java.util.*


object TimeUtil {

    fun dateDifference(startDate: Date, endDate: Date): Long {
        val startCal = Calendar.getInstance()
        startCal.time = roundDate(startDate)
        val endCal = Calendar.getInstance()
        endCal.time = roundDate(endDate)
        return Math.abs(startCal.timeInMillis - endCal.timeInMillis) / (1000 * 60 * 60 * 24)
    }

    fun roundDate(date: Date): Date {
        val cal = Calendar.getInstance()
        cal.time = date
        return Calendar.getInstance().also {
            it.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE))
        }.time
    }

    fun getRandomDate(): Date {
        // 開始日
        val dateStart = Calendar.getInstance()
        dateStart.set(2018, 5, 1)

        // 終了日
        val dateEnd = Calendar.getInstance()

        // 期間日数
        val dateDiff = (dateEnd.timeInMillis - dateStart.timeInMillis) / (1000 * 60 * 60 * 24)

        // ランダムな年月日の生成
        val dateRandom = Calendar.getInstance()
        dateRandom.add(Calendar.DATE, -Random().nextInt(dateDiff.toInt()))

        return dateRandom.time
    }
}