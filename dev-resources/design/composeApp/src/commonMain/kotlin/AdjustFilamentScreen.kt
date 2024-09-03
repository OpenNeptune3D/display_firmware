import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import openneptune.composeapp.generated.resources.load
import openneptune.composeapp.generated.resources.minus
import openneptune.composeapp.generated.resources.plus
import openneptune.composeapp.generated.resources.power
import openneptune.composeapp.generated.resources.unload
import org.jetbrains.compose.resources.painterResource

@Composable
private fun TempInputRow(icon: Painter? = null, showPlusMinusButtons: Boolean = false, buttonState: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.fillMaxWidth().background(
            MaterialTheme.colorScheme.surfaceVariant,
            shape = MaterialTheme.shapes.medium
        ).padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        if (icon != null) {
            Image(
                painter = icon,
                null,
                modifier = Modifier.size(32.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant)
            )
        }
        if (showPlusMinusButtons) {
            FilledTonalIconButton(
                onClick = {},
                colors = IconButtonDefaults.filledTonalIconButtonColors(
                    containerColor = if (buttonState == "pressed") MaterialTheme.colorScheme.surfaceContainerHighest.copy(
                        alpha = 0.8f
                    ) else MaterialTheme.colorScheme.surfaceContainerHighest
                ),
                modifier = Modifier
                    .size(38.dp)
            ) {
                Icon(
                    painterResource(Res.drawable.minus),
                    MaterialTheme.colorScheme.onSurface,
                    24.dp
                )
            }
        }
        Box(
            modifier = Modifier
                .padding(start = 12.dp)
                .background(MaterialTheme.colorScheme.surfaceDim,
                    shape = MaterialTheme.shapes.small)
                .border(1.dp, MaterialTheme.colorScheme.onSurface, MaterialTheme.shapes.small)
                .weight(1f).height(38.dp)
        ) {}

        if (showPlusMinusButtons) {
            FilledTonalIconButton(
                onClick = {},
                colors = IconButtonDefaults.filledTonalIconButtonColors(
                    containerColor = if (buttonState == "pressed") MaterialTheme.colorScheme.surfaceContainerHighest.copy(
                        alpha = 0.8f
                    ) else MaterialTheme.colorScheme.surfaceContainerHighest
                ),
                modifier = Modifier
                    .size(38.dp)
            ) {
                Icon(
                    painterResource(Res.drawable.plus),
                    MaterialTheme.colorScheme.onSurface,
                    24.dp
                )
            }
        } else {
            Text(
                "°C",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
            )
        }
        FilledTonalIconButton(
            onClick = {},
            colors = IconButtonDefaults.filledTonalIconButtonColors(
                containerColor = if (buttonState == "pressed") MaterialTheme.colorScheme.surfaceContainerHighest.copy(
                    alpha = 0.8f
                ) else MaterialTheme.colorScheme.surfaceContainerHighest
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdjustFilamentScreen(showSecondBed: Boolean = false, buttonState: String = "") {
    OpenNeptuneScreen {
        Scaffold(
            topBar = {
                BasicTopAppBar()
            },
            bottomBar = {
                AdjustBottomBar(0, buttonState)
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
                        Icon(Res.drawable.extruder, if (buttonState == "active") MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface, 24.dp)
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
                        Icon(Res.drawable.bed, if (buttonState == "active") MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface, 24.dp)
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
                        Icon(Res.drawable.bed, if (buttonState == "active") MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface, 24.dp)
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                TempInputRow(showPlusMinusButtons = true, buttonState = buttonState)
                Spacer(modifier = Modifier.weight(1f))
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
                    TempDisplay(painterResource(Res.drawable.extruder))
                    TempDisplay(painterResource(Res.drawable.bed))
                    if (showSecondBed) {
                        TempDisplay(painterResource(Res.drawable.bed))
                    }
                }
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    FilledTonalButton(
                        onClick = {},
                        colors = ButtonDefaults.filledTonalButtonColors(
                            containerColor = buttonBackgroud,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        ),
                        modifier = Modifier.weight(1f).padding(4.dp)
                    ) {
                        Icon(Res.drawable.load, MaterialTheme.colorScheme.onPrimaryContainer, 24.dp)
                        Spacer(modifier = Modifier.weight(1f))
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    FilledTonalButton(
                        onClick = {},
                        colors = ButtonDefaults.filledTonalButtonColors(
                            containerColor = buttonBackgroud,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        ),
                        modifier = Modifier.weight(1f).padding(4.dp)
                    ) {
                        Icon(
                            Res.drawable.unload,
                            MaterialTheme.colorScheme.onPrimaryContainer,
                            24.dp
                        )
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun AdjustFilamentScreenPreview() {
    Column {
        Row {
            AdjustFilamentScreen()
            AdjustFilamentScreen(false,"pressed")
        }
        AdjustFilamentScreen(true,"active")
    }
}
