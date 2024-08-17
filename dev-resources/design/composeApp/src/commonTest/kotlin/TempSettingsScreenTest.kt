import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import kotlin.test.Test

class TempSettingsScreenTest : BaseScreenTest() {
    @Test
    fun settingsTemp() = makeScreenshot("settings_temp") {
        TempSettingsScreen(false)
    }

    @Test
    fun settingsTempPressed() = makeScreenshot("settings_temp_pressed") {
        TempSettingsScreen(false,"pressed")
    }

    @Test
    fun settingsTempActive() = makeScreenshot("settings_temp_active") {
        TempSettingsScreen(false,"active")
    }
}
