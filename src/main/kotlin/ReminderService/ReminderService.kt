package ReminderService

import kotlin.time.Duration.Companion.hours
import kotlin.time.Instant

class ReminderService {
    fun getTwoStepVerificationReminderMessage(userCreatedTime: Instant, jobExecutionTime: Instant): String? {
        val durationSinceUserCreated = jobExecutionTime - userCreatedTime

        if (durationSinceUserCreated < 8.hours) return null

        val fullDaysElapsed = durationSinceUserCreated.inWholeDays.toInt()
        val reportedDaysRemaining = 6 - fullDaysElapsed
        if (fullDaysElapsed == 5) return "For security, you have 1 day remaining in your setup window"
        if (fullDaysElapsed == 7) return "For security, your account has been locked because your 7-day setup window has expired"
        return "For security, you have $reportedDaysRemaining days remaining in your setup window"
    }
}
