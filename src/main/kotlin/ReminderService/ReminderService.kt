package ReminderService

import kotlin.time.Duration.Companion.hours
import kotlin.time.Instant

class ReminderService {
    fun getTwoStepVerificationReminderMessage(userCreatedTime: Instant, jobExecutionTime: Instant): String? {
        if (jobExecutionTime - userCreatedTime < 8.hours) return null
        val reportedDaysRemaining = 6 - (jobExecutionTime - userCreatedTime).inWholeDays
        return "For security, you have $reportedDaysRemaining days remaining in your setup window"
    }
}
