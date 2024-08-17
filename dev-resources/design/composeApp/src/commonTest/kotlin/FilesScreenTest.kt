import kotlin.test.Test

class FilesScreenTest : BaseScreenTest() {
    @Test
    fun files() = makeScreenshot("files") {
        FilesScreen()
    }

    @Test
    fun filesPressed() = makeScreenshot("files_pressed") {
        FilesScreen(buttonState = "pressed")
    }
}
