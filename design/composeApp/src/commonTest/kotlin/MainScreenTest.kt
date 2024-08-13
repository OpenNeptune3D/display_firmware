import kotlin.test.Test

class MainScreenTest : BaseScreenTest() {
    @Test
    fun main() = makeScreenshot("main") {
        MainScreen("Neptune 4")
    }

    @Test
    fun mainPro() = makeScreenshot("main_pro") {
        MainScreen("Neptune 4 Pro", true)
    }

    @Test
    fun mainPlus() = makeScreenshot("main_plus") {
        MainScreen("Neptune 4 Plus")
    }

    @Test
    fun mainMax() = makeScreenshot("main_max") {
        MainScreen("Neptune 4 Max")
    }


    @Test
    fun mainPressed() = makeScreenshot("main_pressed") {
        MainScreen("Neptune 4", buttonState = "pressed")
    }
}
