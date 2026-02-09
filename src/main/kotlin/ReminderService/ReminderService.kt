package ReminderService

import kotlin.time.Duration.Companion.hours
import kotlin.time.Instant

class ReminderService {
    fun getTwoStepVerificationReminderMessage(userCreatedTime: Instant, jobExecutionTime: Instant): String? {
        if (jobExecutionTime - userCreatedTime < 8.hours) return null
        return "For security, you have 6 days remaining in your setup window"
    }
}
