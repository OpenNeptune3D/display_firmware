import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import openneptune.composeapp.generated.resources.Res
import openneptune.composeapp.generated.resources.arrow_left
import openneptune.composeapp.generated.resources.arrow_right
import openneptune.composeapp.generated.resources.navigate_next
import org.jetbrains.compose.resources.painterResource

@Composable
fun BasicListScreen(numberOfRows: Int = 8, rowDecoration: @Composable (() -> Unit)? = null, buttonState: String = "") {
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
                for (i in 0..<numberOfRows) {
                    BaseRow(buttonState, Modifier
                            .weight(1f)
                    ) {
                        Spacer(Modifier.weight(1f))
                        rowDecoration?.invoke()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun BasicListScreenPreview() {
    Column {
        Row {
            BasicListScreen()
            BasicListScreen(buttonState = "pressed")
        }
        Row {
            BasicListScreen(rowDecoration =  {
                Icon(Res.drawable.navigate_next, MaterialTheme.colorScheme.onSurface, 32.dp)
            })
            BasicListScreen(rowDecoration = {
                Icon(Res.drawable.navigate_next, MaterialTheme.colorScheme.onSurface, 32.dp)
            }, buttonState = "pressed")
        }
        Row {
            BasicListScreen(0)
            BasicListScreen(0, buttonState = "pressed")
        }
    }
}
