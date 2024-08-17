import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import openneptune.composeapp.generated.resources.Res
import openneptune.composeapp.generated.resources.bed
import openneptune.composeapp.generated.resources.extruder
import openneptune.composeapp.generated.resources.fan
import openneptune.composeapp.generated.resources.light
import openneptune.composeapp.generated.resources.move
import openneptune.composeapp.generated.resources.power
import openneptune.composeapp.generated.resources.print
import openneptune.composeapp.generated.resources.settings
import openneptune.composeapp.generated.resources.temp
import org.jetbrains.compose.resources.painterResource

@Composable
fun MainScreen(deviceName: String, showSecondBed: Boolean = false, buttonState: String = "", modifier: Modifier = Modifier) {
    OpenNeptuneScreen {
        Scaffold {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize()
            ) {
                val chipColor = if (buttonState == "pressed") MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f) else MaterialTheme.colorScheme.surfaceVariant
                val buttonBackgroud = if (buttonState == "pressed") MaterialTheme.colorScheme.inversePrimary.copy(alpha = 0.15f) else MaterialTheme.colorScheme.inverseSurface
                val buttonBorder = if (buttonState == "pressed") MaterialTheme.colorScheme.inversePrimary.copy(alpha = 0.8f) else MaterialTheme.colorScheme.inversePrimary
                Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {
                    Row {
                        Text(deviceName)
                        Spacer(modifier = Modifier.weight(1f))
                        Image(
                            painterResource(Res.drawable.power),
                            null,
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.error),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    Box(
                        modifier = Modifier.padding(top = 8.dp, bottom = 20.dp).fillMaxWidth()
                            .height(3.dp).background(MaterialTheme.colorScheme.secondary)
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        InputChip(
                            onClick = {},
                            leadingIcon = { Text("X", color = MaterialTheme.colorScheme.primary) },
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
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        InputChip(
                            onClick = {},
                            leadingIcon = { Text("Y", color = MaterialTheme.colorScheme.primary) },
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
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxWidth()
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
                            modifier = Modifier.weight(1f).alpha(if (showSecondBed) 1f else 0f)
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxWidth()
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
                    }
                }
                Box(
                    modifier = Modifier.height(190.dp).background(
                        MaterialTheme.colorScheme.inverseSurface,
                        shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)
                    ).padding(horizontal = 16.dp, vertical = 12.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Button(
                                onClick = {},
                                modifier = Modifier.weight(1f),
                                border = BorderStroke(
                                    2.dp,
                                    MaterialTheme.colorScheme.inversePrimary
                                ),
                                colors = ButtonDefaults.buttonColors(containerColor = buttonBackgroud),
                                contentPadding = PaddingValues(horizontal = 16.dp)
                            ) {
                                Image(
                                    painterResource(Res.drawable.move),
                                    null,
                                    colorFilter = ColorFilter.tint(buttonBorder),
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.weight(1f))
                            }
                            Button(
                                onClick = {},
                                modifier = Modifier.weight(1f),
                                border = BorderStroke(
                                    2.dp,
                                    MaterialTheme.colorScheme.inversePrimary
                                ),
                                colors = ButtonDefaults.buttonColors(containerColor = buttonBackgroud),
                                contentPadding = PaddingValues(horizontal = 16.dp)
                            ) {
                                Image(
                                    painterResource(Res.drawable.temp),
                                    null,
                                    colorFilter = ColorFilter.tint(buttonBorder),
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Button(
                                onClick = {},
                                modifier = Modifier.weight(1f),
                                border = BorderStroke(
                                    2.dp,
                                    MaterialTheme.colorScheme.inversePrimary
                                ),
                                colors = ButtonDefaults.buttonColors(containerColor = buttonBackgroud),
                                contentPadding = PaddingValues(horizontal = 16.dp)
                            ) {
                                Image(
                                    painterResource(Res.drawable.move),
                                    null,
                                    colorFilter = ColorFilter.tint(buttonBorder),
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.weight(1f))
                            }
                            Button(
                                onClick = {},
                                modifier = Modifier.weight(1f),
                                border = BorderStroke(
                                    2.dp,
                                    MaterialTheme.colorScheme.inversePrimary
                                ),
                                colors = ButtonDefaults.buttonColors(containerColor = buttonBackgroud),
                                contentPadding = PaddingValues(horizontal = 16.dp)
                            ) {
                                Image(
                                    painterResource(Res.drawable.settings),
                                    null,
                                    colorFilter = ColorFilter.tint(buttonBorder),
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                        Button(
                            onClick = {}, modifier = Modifier.fillMaxSize().height(60.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = buttonBorder),
                            contentPadding = PaddingValues(horizontal = 16.dp)
                        ) {
                            Image(
                                painterResource(Res.drawable.print),
                                null,
                                alignment = Alignment.CenterStart,
                                colorFilter = ColorFilter.tint(
                                    Color.White
                                ),
                                modifier = Modifier.size(32.dp)
                            )
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        }
    }
}

@Preview()
@Composable
fun MainScreenPreview() {
    Row {
        MainScreen("Neptune 4")
        MainScreen("Neptune 4", buttonState = "pressed")
    }
}
