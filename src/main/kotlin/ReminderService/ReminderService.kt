package ReminderService

import kotlin.time.Duration
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.DurationUnit
import kotlin.time.Instant

class ReminderService {
    fun getTwoStepVerificationReminderMessage(userCreatedTime: Instant, jobExecutionTime: Instant): String? {
        val timeElapsed = jobExecutionTime - userCreatedTime
        if (timeElapsed <= 8.hours || timeElapsed >= 8.days) {
            return null
        }
        if (timeElapsed > 7.days) {
            return "For security, your account has been locked because your 7-day setup window has expired"
        }
        val days = remainingDays(timeElapsed)
        if (days == 1) {
            return "For security, you have 1 day remaining in your setup window"
        }
        return "For security, you have ${days} days remaining in your setup window"
    }

    private fun remainingDays(hoursElapsed: Duration) : Int{
        val hours = hoursElapsed.toInt(DurationUnit.HOURS)
        return 6 - hours / 24
    }
}
