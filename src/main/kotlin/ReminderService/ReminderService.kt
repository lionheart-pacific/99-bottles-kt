package ReminderService

import kotlin.time.Duration.Companion.hours
import kotlin.time.Instant

class ReminderService {
    fun getTwoStepVerificationReminderMessage(userCreatedTime: Instant, jobExecutionTime: Instant): String? {
        val durationSinceUserCreated = jobExecutionTime - userCreatedTime

        if (durationSinceUserCreated < 8.hours) return null

        val reportedDaysRemaining = 6 - durationSinceUserCreated.inWholeDays.toInt()
        if (reportedDaysRemaining == 1) return "For security, you have 1 day remaining in your setup window"
        return "For security, you have $reportedDaysRemaining days remaining in your setup window"
    }
}
