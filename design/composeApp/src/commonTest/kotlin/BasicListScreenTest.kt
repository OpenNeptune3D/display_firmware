import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.unit.dp
import openneptune.composeapp.generated.resources.Res
import openneptune.composeapp.generated.resources.navigate_next
import kotlin.test.Test

class BasicListScreenTest : BaseScreenTest() {
    @Test
    fun list() = makeScreenshot("list") {
        BasicListScreen()
    }

    @Test
    fun listPressed() = makeScreenshot("list_pressed") {
        BasicListScreen(buttonState = "pressed")
    }

    @Test
    fun listEmpty() = makeScreenshot("list_blank") {
        BasicListScreen(0)
    }

    @Test
    fun listEmptyPressed() = makeScreenshot("list_blank_pressed") {
        BasicListScreen(0, buttonState = "pressed")
    }

    @Test
    fun listDisclosure() = makeScreenshot("list_disclosure") {
        BasicListScreen(rowDecoration = {
            Icon(Res.drawable.navigate_next, MaterialTheme.colorScheme.onSurface, 32.dp)
        })
    }

    @Test
    fun listDisclosurePressed() = makeScreenshot("list_disclosure_pressed") {
        BasicListScreen(rowDecoration = {
            Icon(Res.drawable.navigate_next, MaterialTheme.colorScheme.onSurface, 32.dp)
        }, buttonState = "pressed")
    }
}
