import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import kotlin.test.Test

class AdjustSpeedScreenTest : BaseScreenTest() {
    @Test
    fun adjustSpeed() = makeScreenshot("adjust_speed") {
        AdjustSpeedScreen(false)
    }

    @Test
    fun adjustSpeedPressed() = makeScreenshot("adjust_filament_pressed") {
        AdjustSpeedScreen(false, "pressed")
    }

    @Test
    fun adjustSpeedActive() = makeScreenshot("adjust_filament_active") {
        AdjustSpeedScreen(false, "active")
    }
}
