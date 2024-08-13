import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.InputChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoveScreen(buttonState: String = "") {
    OpenNeptuneScreen {
        Scaffold(
            topBar = {
                BasicTopAppBar()
            },
            bottomBar = {
                PrepareBottomBar(0, buttonState)
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues)
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
                val backgroundColor = if (buttonState == "pressed") {
                    MaterialTheme.colorScheme.surfaceVariant
                } else {
                    MaterialTheme.colorScheme.surface
                }
                MultiChoiceSegmentedButtonRow {
                    SegmentedButton(
                        buttonState == "active",
                        {},
                        shape = SegmentedButtonDefaults.itemShape(0, 3),
                        icon = {},
                        colors = SegmentedButtonDefaults.colors(
                            activeBorderColor = MaterialTheme.colorScheme.primary,
                            inactiveBorderColor = MaterialTheme.colorScheme.primary,
                            activeContainerColor = MaterialTheme.colorScheme.primaryContainer,
                            activeContentColor = MaterialTheme.colorScheme.onPrimary,
                            inactiveContainerColor = backgroundColor
                        )
                    ) {
                        Text("0.1mm")
                    }
                    SegmentedButton(
                        buttonState == "active",
                        {}, shape = SegmentedButtonDefaults.itemShape(1, 3),
                        icon = {},
                        colors = SegmentedButtonDefaults.colors(
                            activeBorderColor = MaterialTheme.colorScheme.primary,
                            inactiveBorderColor = MaterialTheme.colorScheme.primary,
                            activeContainerColor = MaterialTheme.colorScheme.primaryContainer,
                            activeContentColor = MaterialTheme.colorScheme.onPrimary,
                            inactiveContainerColor = backgroundColor
                        )
                    ) {
                        Text("1mm")
                    }
                    SegmentedButton(
                        buttonState == "active",
                        {}, shape = SegmentedButtonDefaults.itemShape(2, 3),
                        icon = {},
                        colors = SegmentedButtonDefaults.colors(
                            activeBorderColor = MaterialTheme.colorScheme.primary,
                            inactiveBorderColor = MaterialTheme.colorScheme.primary,
                            activeContainerColor = MaterialTheme.colorScheme.primaryContainer,
                            activeContentColor = MaterialTheme.colorScheme.onPrimary,
                            inactiveContainerColor = backgroundColor
                        )
                    ) {
                        Text("10mm")
                    }
                }


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
                        modifier = Modifier.weight(1f)
                    )
                    InputChip(
                        onClick = {},
                        leadingIcon = { Text("Y", color = MaterialTheme.colorScheme.primary) },
                        selected = true,
                        label = {
                            Text("")
                        },
                        modifier = Modifier.weight(1f)
                    )
                    InputChip(
                        onClick = {},
                        leadingIcon = { Text("Z", color = MaterialTheme.colorScheme.primary) },
                        selected = true,
                        label = {
                            Text("")
                        },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MoveScreenPreview() {
    Column {
        Row {
            MoveScreen()
            MoveScreen("pressed")
        }
        MoveScreen("active")
    }
}
