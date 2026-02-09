import ReminderService.ReminderService
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import kotlin.time.Instant

class ReminderServiceTest {

    @Test
    fun `no reminder within first eight hours of user creation (quiet period)`() {
        val userCreatedTime = Instant.parse("2026-02-14T06:00:00Z")
        val jobExecutionTime = Instant.parse("2026-02-14T08:00:00Z")

        expectThat(ReminderService().getTwoStepVerificationReminderMessage(userCreatedTime, jobExecutionTime)).isEqualTo(null)
    }

    @Test
    fun `reports 6 days remaining when less than one full day has elapsed since user creation (after quiet period)`() {
        val userCreatedTime = Instant.parse("2026-02-14T14:00:00Z")
        val jobExecutionTime = Instant.parse("2026-02-15T08:00:00Z")
        val expectedReminder = "For security, you have 6 days remaining in your setup window"

        expectThat(ReminderService().getTwoStepVerificationReminderMessage(userCreatedTime, jobExecutionTime)).isEqualTo(expectedReminder)
    }

    @Test
    fun `reports 5 days remaining when user one full day has elapsed since user creation (created during quiet period)`() {
        val userCreatedTime = Instant.parse("2026-02-14T06:00:00Z")
        val jobExecutionTime = Instant.parse("2026-02-15T08:00:00Z")
        val expectedReminder = "For security, you have 5 days remaining in your setup window"

        expectThat(ReminderService().getTwoStepVerificationReminderMessage(userCreatedTime, jobExecutionTime)).isEqualTo(expectedReminder)
    }

    @Test
    fun `reports 2 days remaining when four full days have elapsed since user creation (created after quiet period)`() {
        val userCreatedTime = Instant.parse("2026-02-14T14:00:00Z")
        val jobExecutionTime = Instant.parse("2026-02-19T08:00:00Z")
        val expectedReminder = "For security, you have 2 days remaining in your setup window"

        expectThat(ReminderService().getTwoStepVerificationReminderMessage(userCreatedTime, jobExecutionTime)).isEqualTo(expectedReminder)
    }

    @Test
    fun `reports 1 day remaining when five full days have elapsed since user creation (created during quiet period)`() {
        val userCreatedTime = Instant.parse("2026-02-14T06:00:00Z")
        val jobExecutionTime = Instant.parse("2026-02-19T08:00:00Z")
        val expectedReminder = "For security, you have 1 day remaining in your setup window"

        expectThat(ReminderService().getTwoStepVerificationReminderMessage(userCreatedTime, jobExecutionTime)).isEqualTo(expectedReminder)
    }

    @Disabled
    @Test
    fun `reports 1 day remaining when five full days have elapsed since user creation (created after quiet period)`() {
        val userCreatedTime = Instant.parse("2026-02-14T14:00:00Z")
        val jobExecutionTime = Instant.parse("2026-02-20T08:00:00Z")

        val expected = "For security, you have 1 day remaining in your setup window"

        expectThat(ReminderService().getTwoStepVerificationReminderMessage(userCreatedTime, jobExecutionTime)).isEqualTo(expected)
    }

    @Disabled
    @Test
    fun `reports account locked when seven full days have elapsed since user creation (created during quiet period)`() {
        val userCreatedTime = Instant.parse("2026-02-14T06:00:00Z")
        val jobExecutionTime = Instant.parse("2026-02-21T08:00:00Z")
        val expectedReminder = "For security, your account has been locked because your 7-day setup window has expired"

        expectThat(ReminderService().getTwoStepVerificationReminderMessage(userCreatedTime, jobExecutionTime)).isEqualTo(expectedReminder)
    }

    @Disabled
    @Test
    fun `reports account locked when seven full days have elapsed since user creation (created after quiet period)`() {
        val userCreatedTime = Instant.parse("2026-02-14T14:00:00Z")
        val jobExecutionTime = Instant.parse("2026-02-22T08:00:00Z")
        val expectedReminder = "For security, your account has been locked because your 7-day setup window has expired"

        expectThat(ReminderService().getTwoStepVerificationReminderMessage(userCreatedTime, jobExecutionTime)).isEqualTo(expectedReminder)
    }

    @Disabled
    @Test
    fun `no reminder when eight full days have elapsed since user creation (created during quiet period)`() {
        val userCreatedTime = Instant.parse("2026-02-14T06:00:00Z")
        val jobExecutionTime = Instant.parse("2026-02-22T08:00:00Z")

        expectThat(ReminderService().getTwoStepVerificationReminderMessage(userCreatedTime, jobExecutionTime)).isEqualTo(null)
    }

    @Disabled
    @Test
    fun `no reminder when eight full days have elapsed since user creation (created after quiet period)`() {
        val userCreatedTime = Instant.parse("2026-02-14T14:00:00Z")
        val jobExecutionTime = Instant.parse("2026-02-23T08:00:00Z")

        expectThat(ReminderService().getTwoStepVerificationReminderMessage(userCreatedTime, jobExecutionTime)).isEqualTo(null)
    }
}