import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BaseRow(buttonState: String = "", modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = modifier
    .background(if (buttonState == "pressed") MaterialTheme.colorScheme.surfaceVariant else MaterialTheme.colorScheme.surfaceContainerHighest, shape = RoundedCornerShape(12.dp))
        .padding(horizontal = 8.dp, vertical = 5.dp)
    .fillMaxWidth()
    ) {
        content()
    }
}
