import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import kotlin.test.Test

class SingleElements: BaseScreenTest() {
    @Test
    fun toggle() = makeScreenshot("toggle", 52, 32) {
        MaterialTheme(colorScheme = darkScheme) {
            Switch(checked = false, onCheckedChange = {})
        }
    }

    @Test
    fun toggleActive() = makeScreenshot("toggle_active", 52, 32) {
        MaterialTheme(colorScheme = darkScheme) {
            Switch(checked = true, onCheckedChange = {})
        }
    }

    @Test
    fun checkbox() = makeScreenshot("checkbox", 24, 24) {
        MaterialTheme(colorScheme = darkScheme) {
            Checkbox(checked = false, onCheckedChange = {})
        }
    }

    @Test
    fun checkboxActive() = makeScreenshot("checkbox_active", 24, 24) {
        MaterialTheme(colorScheme = darkScheme) {
            Checkbox(checked = true, onCheckedChange = {})
        }
    }
}
