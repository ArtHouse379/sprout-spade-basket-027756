package ahmerchant.horticulture.sproutspadebasket.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material.icons.filled.Yard
import androidx.compose.ui.graphics.vector.ImageVector

data class Benefit(
    val icon: ImageVector,
    val text: String,
)

val productBenefits = listOf<Benefit>(
    Benefit(icon = Icons.Filled.Star, text = "Garden-ready quality"),
    Benefit(icon = Icons.Filled.VerifiedUser, text = "12-month tool warranty"),
    Benefit(icon = Icons.Filled.Yard, text = "Growing essentials"),
)
