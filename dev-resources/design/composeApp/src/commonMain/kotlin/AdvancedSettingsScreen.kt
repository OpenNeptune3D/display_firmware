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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import openneptune.composeapp.generated.resources.Res
import openneptune.composeapp.generated.resources.backlight
import openneptune.composeapp.generated.resources.error
import openneptune.composeapp.generated.resources.fan
import openneptune.composeapp.generated.resources.fine_tune
import openneptune.composeapp.generated.resources.language
import openneptune.composeapp.generated.resources.light
import openneptune.composeapp.generated.resources.motor_off
import openneptune.composeapp.generated.resources.navigate_next
import openneptune.composeapp.generated.resources.sound
import openneptune.composeapp.generated.resources.temp
import openneptune.composeapp.generated.resources.warning

@Composable
fun AdvancedSettingsScreen(buttonState: String = "") {
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
                    Column(horizontalAlignment = Alignment.Start) {Row {
                        Icon(Res.drawable.backlight, MaterialTheme.colorScheme.onSurface, 24.dp)
                        Spacer(Modifier.height(32.dp))
                    }
                        Spacer(Modifier.height(32.dp))
                    }
                }
                BaseRow(buttonState) {
                    Icon(Res.drawable.sound, MaterialTheme.colorScheme.onSurface, 24.dp)
                    Spacer(Modifier.height(32.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun AdvancedSettingsScreenPreview() {
    Column {
        Row {
            AdvancedSettingsScreen()
            AdvancedSettingsScreen(buttonState = "pressed")
        }
    }
}
