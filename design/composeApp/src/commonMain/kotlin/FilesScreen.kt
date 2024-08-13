import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import openneptune.composeapp.generated.resources.Res
import openneptune.composeapp.generated.resources.arrow_left
import openneptune.composeapp.generated.resources.arrow_right
import org.jetbrains.compose.resources.painterResource

@Composable
fun FilesScreen(buttonState: String = "") {
    OpenNeptuneScreen {
        Scaffold(
            topBar = {
                BasicTopAppBar()
            },
        ) { paddingValues ->
            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(paddingValues)
                    .padding(horizontal = 12.dp, vertical = 4.dp)
                    .fillMaxSize()
            ) {
                for (i in 0..4) {
                    Box(
                        modifier = Modifier
                            .background(if (buttonState == "pressed") MaterialTheme.colorScheme.surfaceVariant else MaterialTheme.colorScheme.surfaceContainerHighest, shape = RoundedCornerShape(12.dp))
                            .fillMaxWidth()
                            .weight(1f)
                    )
                }
                val buttonColor = when (buttonState) {
                    "pressed" -> MaterialTheme.colorScheme.primary.copy(alpha = 0.9f)
                    else -> MaterialTheme.colorScheme.primary
                }
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Button({}, modifier = Modifier.weight(1f), colors = ButtonDefaults.buttonColors(containerColor = buttonColor)) {
                        Image(painterResource(Res.drawable.arrow_left), null, modifier = Modifier.size(24.dp), colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary))
                    }
                    Button({}, modifier = Modifier.weight(1f), colors = ButtonDefaults.buttonColors(containerColor = buttonColor)) {
                        Image(painterResource(Res.drawable.arrow_right), null, modifier = Modifier.size(24.dp), colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun FilesScreenPreview() {
    Row {
        FilesScreen()
        FilesScreen("pressed")
    }
}
