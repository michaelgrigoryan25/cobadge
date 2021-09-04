package com.michaelgrigoryan.cobadge.types

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

/**
 * Enum for specifying corner rounding of the badge
 *
 * @author Michael Grigoryan
 * @property NO No rounding
 * @property SM Small rounding
 * @property MD Medium rounding
 * @property LG Large rounding
 * @property XL Extra large rounding
 */
enum class Rounding { NO, SM, MD, LG, XL }

/**
 * Enum for specifying the size of the badge
 *
 * @author Michael Grigoryan
 * @property SM Small badge
 * @property MD Medium badge
 * @property LG Large badge
 * @property XL Extra large badge
 */
enum class Size { SM, MD, LG, XL }

/**
 * Type for holding size values after dimension calculations
 *
 * @author Michael Grigoryan
 * @property width Badge width
 * @property height Badge height
 * @property fontSize Badge font size
 * @property textPadding Badge text padding
 */
data class Dimensions(
    val width: Dp,
    val height: Dp,
    val textPadding: Dp,
    val fontSize: TextUnit
)
