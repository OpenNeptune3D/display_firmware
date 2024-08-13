import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import openneptune.composeapp.generated.resources.Res
import openneptune.composeapp.generated.resources.bed
import openneptune.composeapp.generated.resources.emergency_stop
import openneptune.composeapp.generated.resources.extrude
import openneptune.composeapp.generated.resources.extruder
import openneptune.composeapp.generated.resources.fan
import openneptune.composeapp.generated.resources.fine_tune
import openneptune.composeapp.generated.resources.light
import openneptune.composeapp.generated.resources.pause
import openneptune.composeapp.generated.resources.speedplus
import openneptune.composeapp.generated.resources.stop
import org.jetbrains.compose.resources.painterResource

@Composable
fun PrintScreen(
    showSecondBed: Boolean = false,
    buttonState: String = "",
    modifier: Modifier = Modifier
) {
    OpenNeptuneScreen {
        Scaffold(topBar = {
            BasicTopAppBar(actions = {
                IconButton(onClick = {}) {
                    Image(
                        painterResource(Res.drawable.emergency_stop),
                        null,
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.error),
                        modifier = Modifier.size(32.dp)
                    )
                }
            })
        }) {
            Column(
                modifier = Modifier.fillMaxSize().padding(it)
            ) {
                val chipColor =
                    if (buttonState == "pressed") MaterialTheme.colorScheme.surfaceVariant.copy(
                        alpha = 0.5f
                    ) else MaterialTheme.colorScheme.surfaceVariant
                val buttonBackgroud =
                    if (buttonState == "pressed") MaterialTheme.colorScheme.primaryContainer.copy(
                        alpha = 0.8f
                    ) else MaterialTheme.colorScheme.primaryContainer
                val buttonBorder =
                    if (buttonState == "pressed") MaterialTheme.colorScheme.inversePrimary.copy(
                        alpha = 0.8f
                    ) else MaterialTheme.colorScheme.inversePrimary

                Row {
                    Box(
                        modifier = Modifier.size(200.dp)
                            .background(MaterialTheme.colorScheme.surfaceVariant)
                    )
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.height(200.dp).fillMaxWidth().padding(top = 17.dp)
                    ) {
                        FilledTonalIconButton(
                            onClick = {},
                            colors = IconButtonDefaults.filledIconButtonColors(containerColor = buttonBackgroud),
                            modifier = Modifier.size(48.dp)
                        ) {
                            Image(
                                painterResource(Res.drawable.pause),
                                null,
                                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                                modifier = Modifier.size(32.dp)
                            )
                        }
                        FilledTonalIconButton(
                            onClick = {},
                            colors = IconButtonDefaults.filledIconButtonColors(containerColor = buttonBackgroud),
                            modifier = Modifier.size(48.dp)
                        ) {
                            Image(
                                painterResource(Res.drawable.stop),
                                null,
                                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                                modifier = Modifier.size(32.dp)
                            )
                        }
                        FilledTonalIconButton(
                            onClick = {},
                            colors = IconButtonDefaults.filledIconButtonColors(containerColor = buttonBackgroud),
                            modifier = Modifier.size(48.dp)
                        ) {
                            Image(
                                painterResource(Res.drawable.fine_tune),
                                null,
                                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    }
                }

                LinearProgressIndicator(
                    trackColor = MaterialTheme.colorScheme.primaryContainer,
                    strokeCap = StrokeCap.Round,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
                        .padding(top = 50.dp)
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(3.dp),
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        modifier = Modifier.fillMaxWidth().height(35.dp)
                    ) {
                        InputChip(
                            onClick = {},
                            leadingIcon = {
                                Image(
                                    painterResource(Res.drawable.speedplus),
                                    null,
                                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                                    modifier = Modifier.size(18.dp)
                                )
                            },
                            selected = true,
                            label = {
                                Text("")
                            },
                            colors = InputChipDefaults.inputChipColors(selectedContainerColor = chipColor),
                            modifier = Modifier.weight(1f)
                        )
                        InputChip(
                            onClick = {},
                            leadingIcon = {
                                Image(
                                    painterResource(Res.drawable.extrude),
                                    null,
                                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                                    modifier = Modifier.size(18.dp)
                                )
                            },
                            selected = true,
                            colors = InputChipDefaults.inputChipColors(selectedContainerColor = chipColor),
                            label = {
                                Text("")
                            },
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        modifier = Modifier.fillMaxWidth().height(35.dp)
                    ) {
                        InputChip(
                            onClick = {},
                            leadingIcon = { Text("Z", color = MaterialTheme.colorScheme.primary) },
                            selected = true,
                            colors = InputChipDefaults.inputChipColors(selectedContainerColor = chipColor),
                            label = {
                                Text("")
                            },
                            modifier = Modifier.weight(1f)
                        )
                        InputChip(
                            onClick = {},
                            leadingIcon = {
                                Image(
                                    painterResource(Res.drawable.extruder),
                                    null,
                                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                                    modifier = Modifier.size(18.dp)
                                )
                            },
                            selected = true,
                            colors = InputChipDefaults.inputChipColors(selectedContainerColor = chipColor),
                            label = {
                                Text("")
                            },
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        modifier = Modifier.fillMaxWidth().height(35.dp)
                    ) {
                        InputChip(
                            onClick = {},
                            leadingIcon = {
                                Image(
                                    painterResource(Res.drawable.light),
                                    null,
                                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                                    modifier = Modifier.size(18.dp)
                                )
                            },
                            selected = true,
                            colors = InputChipDefaults.inputChipColors(selectedContainerColor = chipColor),
                            label = {
                                Text("")
                            },
                            modifier = Modifier.weight(1f)
                        )
                        InputChip(
                            onClick = {},
                            leadingIcon = {
                                Image(
                                    painterResource(Res.drawable.bed),
                                    null,
                                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                                    modifier = Modifier.size(18.dp)
                                )
                            },
                            selected = true,
                            colors = InputChipDefaults.inputChipColors(selectedContainerColor = chipColor),
                            label = {
                                Text("")
                            },
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        modifier = Modifier.fillMaxWidth().height(35.dp)
                    ) {
                        InputChip(
                            onClick = {},
                            leadingIcon = {
                                Image(
                                    painterResource(Res.drawable.fan),
                                    null,
                                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                                    modifier = Modifier.size(18.dp)
                                )
                            },
                            selected = true,
                            colors = InputChipDefaults.inputChipColors(selectedContainerColor = chipColor),
                            label = {
                                Text("")
                            },
                            modifier = Modifier.weight(1f)
                        )
                        InputChip(
                            onClick = {},
                            leadingIcon = {
                                Image(
                                    painterResource(Res.drawable.bed),
                                    null,
                                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                                    modifier = Modifier.size(18.dp)
                                )
                            },
                            selected = true,
                            colors = InputChipDefaults.inputChipColors(selectedContainerColor = chipColor),
                            label = {
                                Text("")
                            },
                            modifier = Modifier.weight(1f).weight(1f)
                                .alpha(if (showSecondBed) 1f else 0f)
                        )
                    }
                }
            }
        }
    }
}

@Preview()
@Composable
fun PrintScreenPreview() {
    Row {
        PrintScreen()
        PrintScreen(buttonState = "pressed")
    }
}
