import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import openneptune.composeapp.generated.resources.Res
import openneptune.composeapp.generated.resources.arrow_right
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.skia.Drawable

@Composable
fun Icon(drawable: DrawableResource, color: Color, size: Dp) {
    Icon(painterResource(drawable), color, size)
}

@Composable
fun Icon(painter: Painter, color: Color, size: Dp) {
    Image(painter, null, modifier = Modifier.size(size), colorFilter = ColorFilter.tint(color))
}
