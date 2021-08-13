package com.michaelgrigoryan.cobadgeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.michaelgrigoryan.cobadge.components.Badge
import com.michaelgrigoryan.cobadge.types.Size
import com.michaelgrigoryan.cobadgeexample.ui.theme.CobadgeExampleTheme

private fun getColorFromHex(color: String): Color = Color(
    android.graphics.Color.parseColor("#$color")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CobadgeExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Main()
                }
            }
        }
    }
}

@Composable
fun Main() {
    return Column {
        Row {
            Badge(
                size = Size.MD,
                text = "Raspberry Pi",
                color = getColorFromHex("FF3366")
            )

            Badge(
                size = Size.MD,
                text = "Android",
                color = getColorFromHex("03DD70")
            )

            Badge(
                size = Size.MD,
                text = "Apple",
                color = getColorFromHex("000000"),
                textColor = getColorFromHex("ffffff")
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    CobadgeExampleTheme {
        Surface(color = MaterialTheme.colors.background) {
            Main()
        }
    }
}