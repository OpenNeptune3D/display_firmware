import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import openneptune.composeapp.generated.resources.Res
import openneptune.composeapp.generated.resources.extrude
import openneptune.composeapp.generated.resources.move
import openneptune.composeapp.generated.resources.temp
import org.jetbrains.compose.resources.painterResource

@Composable
fun PrepareBottomBar(selected: Int, buttonState: String) {
    val buttonColor = when (buttonState) {
        "pressed" -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        else -> MaterialTheme.colorScheme.surfaceVariant
    }
    NavigationBar(containerColor = MaterialTheme.colorScheme.surfaceContainerHighest) {
        NavigationBarItem(
            onClick = {},
            selected = selected == 0 || buttonState == "pressed",
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = buttonColor
            ),
            icon = {
                Image(
                    painterResource(Res.drawable.move), null, colorFilter = ColorFilter.tint(
                        MaterialTheme.colorScheme.onSurface), modifier = Modifier.size(24.dp))
            },
            label = { Text("") }
        )
        NavigationBarItem(
            onClick = {},
            selected = selected == 1 || buttonState == "pressed",
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = buttonColor
            ),
            icon = {
                Image(
                    painterResource(Res.drawable.temp), null, colorFilter = ColorFilter.tint(
                        MaterialTheme.colorScheme.onSurface), modifier = Modifier.size(24.dp))
            },
            label = { Text("") }
        )
        NavigationBarItem(
            onClick = {},
            selected = selected == 2 || buttonState == "pressed",
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = buttonColor
            ),
            icon = {
                Image(
                    painterResource(Res.drawable.extrude), null, colorFilter = ColorFilter.tint(
                        MaterialTheme.colorScheme.onSurface), modifier = Modifier.size(24.dp))
            },
            label = { Text("") }
        )
    }
}
