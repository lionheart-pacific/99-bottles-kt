package ReminderService

import kotlin.time.Duration.Companion.hours
import kotlin.time.Instant

class ReminderService {
    fun getTwoStepVerificationReminderMessage(userCreatedTime: Instant, jobExecutionTime: Instant): String? {
        val dif = jobExecutionTime.minus(userCreatedTime)
        if(dif > 8.hours) {
            val remainingDays = 6 - dif.inWholeDays
            return "For security, you have $remainingDays days remaining in your setup window"
        }
        return null
    }
}
