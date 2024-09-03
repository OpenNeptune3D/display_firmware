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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import openneptune.composeapp.generated.resources.power
import org.jetbrains.compose.resources.painterResource

@Composable
private fun TempInputRow(icon: Painter) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.fillMaxWidth().background(
            MaterialTheme.colorScheme.surfaceVariant,
            shape = MaterialTheme.shapes.medium
        ).padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Image(
            painter = icon,
            null,
            modifier = Modifier.size(32.dp),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant)
        )
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
                containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
            ),
            modifier = Modifier
                .padding(start = 12.dp)
                .size(38.dp)
        ) {
            Image(
                painterResource(Res.drawable.power),
                null,
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.error)
            )
        }
    }
}

@Composable
fun TempDisplay(icon: Painter) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("", modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.onSurface)
                .height(2.dp)
                .width(60.dp)
        ) {}
        Text("", modifier = Modifier.height(20.dp))
        Icon(
            icon,
            MaterialTheme.colorScheme.onSurface,
            32.dp
        )
    }
}


@Composable
fun TempScreen(showSecondBed: Boolean = false, buttonState: String = "") {
    OpenNeptuneScreen {
        Scaffold(
            topBar = {
                BasicTopAppBar()
            },
            bottomBar = {
                PrepareBottomBar(1, buttonState)
            }
        ) { paddingValues ->
            val buttonBackgroud =
                if (buttonState == "pressed") MaterialTheme.colorScheme.primaryContainer.copy(
                    alpha = 0.8f
                ) else MaterialTheme.colorScheme.primaryContainer
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(paddingValues)
                    .padding(horizontal = 12.dp, vertical = 6.dp)
                    .fillMaxSize()
            ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                TempInputRow(painterResource(Res.drawable.extruder))
                TempInputRow(painterResource(Res.drawable.bed))
                if (showSecondBed) {
                    TempInputRow(painterResource(Res.drawable.bed))
                }
            }
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
                    TempDisplay(painterResource(Res.drawable.extruder))
                    TempDisplay(painterResource(Res.drawable.bed))
                    if (showSecondBed) {
                        TempDisplay(painterResource(Res.drawable.bed))
                    }
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        FilledTonalButton(
                            onClick = {},
                            colors = ButtonDefaults.filledTonalButtonColors(
                                containerColor = buttonBackgroud,
                                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                            ),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("PLA")
                        }
                        FilledTonalButton(
                            onClick = {},
                            colors = ButtonDefaults.filledTonalButtonColors(
                                containerColor = buttonBackgroud,
                                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                            ),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("ABS")
                        }
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        FilledTonalButton(
                            onClick = {},
                            colors = ButtonDefaults.filledTonalButtonColors(
                                containerColor = buttonBackgroud,
                                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                            ),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("PETG")
                        }
                        FilledTonalButton(
                            onClick = {},
                            colors = ButtonDefaults.filledTonalButtonColors(
                                containerColor = buttonBackgroud,
                                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                            ),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("TPU")
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun TempScreenPreview() {
    Column {
        Row {
            TempScreen()
            TempScreen(false,"pressed")
        }
        TempScreen(true,"active")
    }
}
