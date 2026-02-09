package ReminderService

import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Instant

class ReminderService {
    fun getTwoStepVerificationReminderMessage(userCreatedTime: Instant, jobExecutionTime: Instant): String? {
        val dif = jobExecutionTime.minus(userCreatedTime)
        if(dif > 8.days){
            return null
        }
        else if(dif > 8.hours) {
            val remainingDays = 6 - dif.inWholeDays
            if (remainingDays <= 0.toLong()) {
                return "For security, your account has been locked because your 7-day setup window has expired"
            }
            val days = if (remainingDays == 1.toLong()) "day" else "days"
            return "For security, you have $remainingDays $days remaining in your setup window"
        }
        return null
    }
}
