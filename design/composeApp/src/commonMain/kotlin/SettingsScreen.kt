import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import openneptune.composeapp.generated.resources.Res
import openneptune.composeapp.generated.resources.error
import openneptune.composeapp.generated.resources.fan
import openneptune.composeapp.generated.resources.fine_tune
import openneptune.composeapp.generated.resources.language
import openneptune.composeapp.generated.resources.light
import openneptune.composeapp.generated.resources.motor_off
import openneptune.composeapp.generated.resources.navigate_next
import openneptune.composeapp.generated.resources.temp
import openneptune.composeapp.generated.resources.warning

@Composable
fun SettingsScreen(buttonState: String = "") {
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
                    BaseRow(buttonState) {
                        Icon(Res.drawable.language, MaterialTheme.colorScheme.onSurface, 24.dp)
                        Spacer(Modifier.weight(1f))
                        Icon(Res.drawable.navigate_next, MaterialTheme.colorScheme.onSurface, 32.dp)
                    }
                BaseRow(buttonState) {
                    Icon(Res.drawable.temp, MaterialTheme.colorScheme.onSurface, 24.dp)
                    Spacer(Modifier.weight(1f))
                    Icon(Res.drawable.navigate_next, MaterialTheme.colorScheme.onSurface, 32.dp)
                }
                BaseRow(buttonState) {
                    Icon(Res.drawable.light, MaterialTheme.colorScheme.onSurface, 24.dp)
                    Spacer(Modifier.weight(1f))
                    Icon(Res.drawable.navigate_next, MaterialTheme.colorScheme.onSurface, 32.dp)
                }
                BaseRow(buttonState) {
                    Icon(Res.drawable.fan, MaterialTheme.colorScheme.onSurface, 24.dp)
                    Spacer(Modifier.weight(1f).height(32.dp))
                }
                BaseRow(buttonState) {
                    Icon(Res.drawable.motor_off, MaterialTheme.colorScheme.onSurface, 24.dp)
                    Spacer(Modifier.weight(1f).height(32.dp))
                }
                BaseRow(buttonState) {
                    Icon(Res.drawable.error, MaterialTheme.colorScheme.onSurface, 24.dp)
                    Spacer(Modifier.weight(1f).height(32.dp))
                }
                BaseRow(buttonState) {
                    Icon(Res.drawable.warning, MaterialTheme.colorScheme.onSurface, 24.dp)
                    Spacer(Modifier.weight(1f))
                    Icon(Res.drawable.navigate_next, MaterialTheme.colorScheme.onSurface, 32.dp)
                }
                BaseRow(buttonState) {
                    Icon(Res.drawable.fine_tune, MaterialTheme.colorScheme.onSurface, 24.dp)
                    Spacer(Modifier.weight(1f))
                    Icon(Res.drawable.navigate_next, MaterialTheme.colorScheme.onSurface, 32.dp)
                }
            }
        }
    }
}

@Preview
@Composable
fun SettingsScreenPreview() {
    Column {
        Row {
            SettingsScreen()
            SettingsScreen(buttonState = "pressed")
        }
    }
}
