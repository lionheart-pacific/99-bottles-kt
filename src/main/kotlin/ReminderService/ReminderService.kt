package ReminderService

import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Instant

class ReminderService {
    fun getTwoStepVerificationReminderMessage(userCreatedTime: Instant, jobExecutionTime: Instant): String? {
        val createdTime = jobExecutionTime.minus(userCreatedTime)
        val quietPeriod = 8.hours
        val reminderPeriod = 8.days

        if(createdTime > quietPeriod && createdTime < reminderPeriod) {
            val remainingDays = 6 - createdTime.inWholeDays
            if (remainingDays >= 1.toLong()) {
                val days = if (remainingDays == 1.toLong()) "day" else "days"
                return "For security, you have $remainingDays $days remaining in your setup window"
            }
            return "For security, your account has been locked because your 7-day setup window has expired"
        }
        return null
    }
}
