import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import kotlin.test.Test

class AdvancedSettingsScreenTest : BaseScreenTest() {
    @Test
    fun advancedSettings() = makeScreenshot("settings_advanced") {
        AdvancedSettingsScreen()
    }

    @Test
    fun advancedSettingsPressed() = makeScreenshot("settings_advanced_pressed") {
        AdvancedSettingsScreen("pressed")
    }
}
