package com.example.market_re.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.market_re.R
// Set of Material typography styles to start with
val Typography = Typography(bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
)
)

val customFont2 = FontFamily(
    Font(R.font.zxc)
)

val customTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = customFont2,
        fontSize = 36.sp,
        fontWeight = FontWeight.Normal,
        color = Color.Black,
        textDecoration = TextDecoration.Underline
    )
)
val customTypography1 = Typography(
    bodyLarge = TextStyle(
        fontFamily = customFont2,
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        color = Color6,
    )
)

