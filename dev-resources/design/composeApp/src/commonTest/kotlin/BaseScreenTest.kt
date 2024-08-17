import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.asSkiaBitmap
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.runDesktopComposeUiTest
import org.jetbrains.skia.EncodedImageFormat
import org.jetbrains.skia.Image
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.writeBytes

open class BaseScreenTest {
    @OptIn(ExperimentalTestApi::class)
    fun makeScreenshot(name: String, width: Int = 272, height: Int = 480, content: @Composable () -> Unit) = runDesktopComposeUiTest(width, height) {
        setContent {
            content()
        }
        Image.makeFromBitmap(captureToImage().asSkiaBitmap()).use { img: Image ->
            val path = Path.of("screens/${name}.png")
            Files.deleteIfExists(path)
            if (!Files.exists(path.parent)) Files.createDirectories(path.parent)
            val actualPng = Files.createFile(path)
            val actualImage = img.encodeToData(EncodedImageFormat.PNG)
                ?: error("Could not encode image as png")
            actualPng.writeBytes(actualImage.bytes)
        }
    }
}
