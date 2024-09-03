import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import openneptune.composeapp.generated.resources.Res
import openneptune.composeapp.generated.resources.bed
import openneptune.composeapp.generated.resources.extruder
import openneptune.composeapp.generated.resources.minus
import openneptune.composeapp.generated.resources.plus
import org.jetbrains.compose.resources.painterResource

@Composable
private fun TempInputRow(icon: Painter, buttonState: String) {
    val buttonBackgroud =
        if (buttonState == "pressed") MaterialTheme.colorScheme.surfaceContainer.copy(
            alpha = 0.8f
        ) else MaterialTheme.colorScheme.surfaceContainerHighest
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.fillMaxWidth().background(
            MaterialTheme.colorScheme.surfaceVariant,
            shape = MaterialTheme.shapes.medium
        ).padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        Image(
            painter = icon,
            null,
            modifier = Modifier.size(32.dp),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant)
        )
        FilledTonalIconButton(
            onClick = {},
            colors = IconButtonDefaults.filledTonalIconButtonColors(
                containerColor = buttonBackgroud
            ),
            modifier = Modifier
                .padding(start = 12.dp)
                .size(38.dp)
        ) {
            Image(
                painterResource(Res.drawable.minus),
                null,
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface)
            )
        }
        Box(
            modifier = Modifier
                .padding(start = 12.dp)
                .background(MaterialTheme.colorScheme.surfaceDim,
                    shape = MaterialTheme.shapes.small)
                .border(1.dp, MaterialTheme.colorScheme.onSurface, MaterialTheme.shapes.small)
                .weight(1f).height(38.dp)
        ) {}
        Text(
            "°C",
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier
        )
        FilledTonalIconButton(
            onClick = {},
            colors = IconButtonDefaults.filledTonalIconButtonColors(
                containerColor = buttonBackgroud
            ),
            modifier = Modifier
                .padding(start = 12.dp)
                .size(38.dp)
        ) {
            Image(
                painterResource(Res.drawable.plus),
                null,
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TempSettingsScreen(showSecondHotbed: Boolean, buttonState: String = "") {
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
                val backgroundColor = if (buttonState == "pressed") {
                    MaterialTheme.colorScheme.surfaceVariant
                } else {
                    MaterialTheme.colorScheme.surface
                }
                MultiChoiceSegmentedButtonRow(modifier = Modifier.fillMaxWidth()) {
                    SegmentedButton(
                        buttonState == "active",
                        {},
                        shape = SegmentedButtonDefaults.itemShape(0, 3),
                        icon = {},
                        colors = SegmentedButtonDefaults.colors(
                            activeBorderColor = MaterialTheme.colorScheme.primary,
                            inactiveBorderColor = MaterialTheme.colorScheme.primary,
                            activeContainerColor = MaterialTheme.colorScheme.primaryContainer,
                            activeContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                            inactiveContainerColor = backgroundColor
                        )
                    ) {
                        Text("1°C")
                    }
                    SegmentedButton(
                        buttonState == "active",
                        {}, shape = SegmentedButtonDefaults.itemShape(1, 3),
                        icon = {},
                        colors = SegmentedButtonDefaults.colors(
                            activeBorderColor = MaterialTheme.colorScheme.primary,
                            inactiveBorderColor = MaterialTheme.colorScheme.primary,
                            activeContainerColor = MaterialTheme.colorScheme.primaryContainer,
                            activeContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                            inactiveContainerColor = backgroundColor
                        )
                    ) {
                        Text("5°C")
                    }
                    SegmentedButton(
                        buttonState == "active",
                        {}, shape = SegmentedButtonDefaults.itemShape(2, 3),
                        icon = {},
                        colors = SegmentedButtonDefaults.colors(
                            activeBorderColor = MaterialTheme.colorScheme.primary,
                            inactiveBorderColor = MaterialTheme.colorScheme.primary,
                            activeContainerColor = MaterialTheme.colorScheme.primaryContainer,
                            activeContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                            inactiveContainerColor = backgroundColor
                        )
                    ) {
                        Text("10°C")
                    }
                }
                TempInputRow(painterResource(Res.drawable.extruder), buttonState)
                TempInputRow(painterResource(Res.drawable.bed), buttonState)
                if (showSecondHotbed) {
                    TempInputRow(painterResource(Res.drawable.bed), buttonState)
                }
            }
        }
    }
}

@Preview
@Composable
fun TempSettingsScreenPreview() {
    Column {
        Row {
            TempSettingsScreen(false)
            TempSettingsScreen(false, buttonState = "pressed")
            TempSettingsScreen(false, buttonState = "active")
        }
        Row {
            TempSettingsScreen(true)
            TempSettingsScreen(true, buttonState = "pressed")
        }
    }
}
