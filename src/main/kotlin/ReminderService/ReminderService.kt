package ReminderService

import kotlin.time.Duration.Companion.hours
import kotlin.time.Instant

class ReminderService {
    fun getTwoStepVerificationReminderMessage(userCreatedTime: Instant, jobExecutionTime: Instant): String? {
        val dif = jobExecutionTime.minus(userCreatedTime)
        if(dif > 8.hours) {
            return "For security, you have 6 days remaining in your setup window"
        }
        return null
    }
}
