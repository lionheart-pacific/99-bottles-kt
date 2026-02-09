package ReminderService

import kotlin.time.Duration.Companion.hours
import kotlin.time.Instant

class ReminderService {
    fun getTwoStepVerificationReminderMessage(userCreatedTime: Instant, jobExecutionTime: Instant): String? {
        val durationSinceUserCreated = jobExecutionTime - userCreatedTime
        val wholeDaysSinceUserCreated = durationSinceUserCreated.inWholeDays.toInt()
        val reportedDaysRemaining = 6 - wholeDaysSinceUserCreated
        return when {
            durationSinceUserCreated < 8.hours -> null
            wholeDaysSinceUserCreated == 5 -> "For security, you have $reportedDaysRemaining day remaining in your setup window"
            wholeDaysSinceUserCreated < 7 -> "For security, you have $reportedDaysRemaining days remaining in your setup window"
            wholeDaysSinceUserCreated == 7 -> "For security, your account has been locked because your 7-day setup window has expired"
            else -> null
        }
    }
}
