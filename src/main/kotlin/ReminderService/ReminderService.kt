package ReminderService

import kotlin.time.Duration.Companion.hours
import kotlin.time.Instant

class ReminderService {
    fun getTwoStepVerificationReminderMessage(userCreatedTime: Instant, jobExecutionTime: Instant): String? {
        val durationSinceUserCreated = jobExecutionTime - userCreatedTime
        val wholeDaysSinceUserCreated = durationSinceUserCreated.inWholeDays.toInt()
        val reportedDaysRemaining = 6 - wholeDaysSinceUserCreated
        if (durationSinceUserCreated < 8.hours) return null
        if (reportedDaysRemaining == 1) return "For security, you have $reportedDaysRemaining day remaining in your setup window"
        if (reportedDaysRemaining <= 0) return "For security, your account has been locked because your 7-day setup window has expired"
        return "For security, you have $reportedDaysRemaining days remaining in your setup window"
    }
}
