import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import kotlin.test.Test

class AdjustFilamentScreenTest : BaseScreenTest() {
    @Test
    fun adjustFilament() = makeScreenshot("adjust_filament") {
        AdjustFilamentScreen(false)
    }

    @Test
    fun adjustFilamentPressed() = makeScreenshot("adjust_filament_pressed") {
        AdjustFilamentScreen(false, "pressed")
    }

    @Test
    fun adjustFilamentActive() = makeScreenshot("adjust_filament_active") {
        AdjustFilamentScreen(false, "active")
    }

    @Test
    fun adjustFilamentPro() = makeScreenshot("adjust_filament_pro") {
        AdjustFilamentScreen(true)
    }

    @Test
    fun adjustFilamentProPressed() = makeScreenshot("adjust_filament_pro_pressed") {
        AdjustFilamentScreen(true, "pressed")
    }

    @Test
    fun adjustFilamentProActive() = makeScreenshot("adjust_filament_pro_active") {
        AdjustFilamentScreen(true, "active")
    }
}
