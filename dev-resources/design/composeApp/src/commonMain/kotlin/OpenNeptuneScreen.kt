import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OpenNeptuneScreen(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = darkScheme) {
        Box(modifier = modifier.width(272.dp).height(480.dp)) {
            content()
        }
    }
}
