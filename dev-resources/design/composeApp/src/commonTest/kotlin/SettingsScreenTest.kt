import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import kotlin.test.Test

class SettingsScreenTest : BaseScreenTest() {
    @Test
    fun settings() = makeScreenshot("settings") {
        SettingsScreen()
    }

    @Test
    fun settingsPressed() = makeScreenshot("settings_pressed") {
        SettingsScreen("pressed")
    }
}
