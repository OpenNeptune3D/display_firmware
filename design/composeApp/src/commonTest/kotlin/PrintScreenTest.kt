import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import kotlin.test.Test

class PrintScreenTest : BaseScreenTest() {
    @Test
    fun print() = makeScreenshot("print") {
        PrintScreen()
    }

    @Test
    fun printPro() = makeScreenshot("print_pro") {
        PrintScreen(showSecondBed = true)
    }

    @Test
    fun printPressed() = makeScreenshot("print_pressed") {
        PrintScreen(buttonState = "pressed")
    }

    @Test
    fun progressEmpty() = makeScreenshot("progress_empty", 248, 5) {
        MaterialTheme(colorScheme = darkScheme) {
            LinearProgressIndicator(
                trackColor = MaterialTheme.colorScheme.primaryContainer,
                strokeCap = StrokeCap.Round,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

    @Test
    fun progressFull() = makeScreenshot("progress_full", 248, 5) {
        MaterialTheme(colorScheme = darkScheme) {
            LinearProgressIndicator(
                progress = { 1f },
                trackColor = MaterialTheme.colorScheme.primaryContainer,
                strokeCap = StrokeCap.Round,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
