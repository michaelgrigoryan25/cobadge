package com.michaelgrigoryan.cobadge.components

import com.michaelgrigoryan.cobadge.types.*
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// To disable the ripple effect in interactions
@SuppressLint("UnnecessaryComposedModifier")
inline fun Modifier.noRippleClickable(
    crossinline onClickAction: () -> Unit
): Modifier = composed {
    val interactionSource = remember { MutableInteractionSource() }
    clickable(indication = null, interactionSource = interactionSource) { onClickAction() }
}

/**
 * Badge component for Jetpack Compose
 *
 * @author Michael Grigoryan
 * @param size Badge size
 * @param textColor Text color
 * @param fontWeight Font weight
 * @param rounded Apply rounding to the badge
 * @param paddingSelf Outer padding of the badge
 * @param color The background color of the badge
 * @param text Text that will be displayed on the badge
 * @param isClickable Whether the badge is clickable or not
 * @param onClickAction Function that should trigger on click
 * @param backgroundColorOpacity Can be used to make badge background transparent
 */
@Composable
fun Badge(
    text: String,
    color: Color,
    size: Size = Size.MD,
    paddingSelf: Dp = 4.dp,
    isClickable: Boolean = true,
    rounded: Rounding = Rounding.XL,
    backgroundColorOpacity: Float = 1f,
    textColor: Color = Color.Unspecified,
    onClickAction: () -> Unit = fun() {},
    fontWeight: FontWeight = FontWeight.Bold
) {
    // Calculating the rounding of the badge
    val rounding: Dp = when (rounded) {
        Rounding.NO -> 0.dp
        Rounding.SM -> 5.dp
        Rounding.MD -> 10.dp
        Rounding.LG -> 80.dp
        Rounding.XL -> 100.dp
    }

    // Calculating the dimensions of the badge
    val dimensions: Dimensions = when (size) {
        Size.SM -> Dimensions(90.dp,  20.dp,  8.dp, 18.sp)
        Size.MD -> Dimensions(120.dp, 40.dp, 12.dp, 20.sp)
        Size.LG -> Dimensions(140.dp, 45.dp, 10.dp, 24.sp)
        Size.XL -> Dimensions(160.dp, 55.dp, 12.dp, 26.sp)
    }

    return Box(
        modifier = Modifier
            .padding(paddingSelf)
            .widthIn(min = dimensions.width)
            .heightIn(min = dimensions.height)
            .noRippleClickable(onClickAction)
            .focusable(enabled = isClickable, interactionSource = null)
            .background(
                shape = RoundedCornerShape(rounding),
                color = color.copy(alpha = backgroundColorOpacity)
            )

    ) {
        Box(modifier = Modifier.align(Alignment.Center)) {
            Text(
                text = text,
                color = textColor,
                fontWeight = fontWeight,
                fontSize = dimensions.fontSize,
                modifier = Modifier.padding(dimensions.textPadding)
            )
        }
    }
}
