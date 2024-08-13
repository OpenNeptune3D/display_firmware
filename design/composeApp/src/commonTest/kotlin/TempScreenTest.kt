import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import kotlin.test.Test

class TempScreenTest : BaseScreenTest() {
    @Test
    fun temp() = makeScreenshot("temp") {
        TempScreen()
    }

    @Test
    fun tempPro() = makeScreenshot("temp_pro") {
        TempScreen(showSecondBed = true)
    }

    @Test
    fun tempPressed() = makeScreenshot("temp_pressed") {
        TempScreen(buttonState = "pressed")
    }

    @Test
    fun tempProPressed() = makeScreenshot("temp_pro_pressed") {
        TempScreen(showSecondBed = true, buttonState = "pressed")
    }
}
