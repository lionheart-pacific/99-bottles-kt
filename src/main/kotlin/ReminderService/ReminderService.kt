package ReminderService

import kotlin.time.Duration.Companion.hours
import kotlin.time.Instant

class ReminderService {
    fun getTwoStepVerificationReminderMessage(userCreatedTime: Instant, jobExecutionTime: Instant): String? {
        val durationSinceUserCreated = jobExecutionTime - userCreatedTime

        if (durationSinceUserCreated < 8.hours) return null

        val fullDaysElapsed = durationSinceUserCreated.inWholeDays.toInt()
        val reportedDaysRemaining = 6 - fullDaysElapsed

        return when (fullDaysElapsed) {
            5 -> "For security, you have 1 day remaining in your setup window"
            7 -> "For security, your account has been locked because your 7-day setup window has expired"
            else -> "For security, you have $reportedDaysRemaining days remaining in your setup window"
        }
    }
}
