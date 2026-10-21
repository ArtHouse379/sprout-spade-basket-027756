package ahmerchant.horticulture.sproutspadebasket.ui.composable.screen.settings.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ahmerchant.horticulture.sproutspadebasket.R
import ahmerchant.horticulture.sproutspadebasket.ui.theme.LocalDimens
import ahmerchant.horticulture.sproutspadebasket.ui.theme.cardBorderStroke
import ahmerchant.horticulture.sproutspadebasket.ui.theme.imageBorder

private val BannerHeight = 72.dp
private val LogoSize = 48.dp

@Composable
fun AppInfoCard(modifier: Modifier = Modifier) {
    val dimens = LocalDimens.current
    val logoShape = RoundedCornerShape(dimens.cornerRadius)
    val companyName = stringResource(R.string.irrrw_company_name)

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(dimens.cardCornerRadius),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = MaterialTheme.colorScheme.onSurface,
        ),
        border = cardBorderStroke(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(BannerHeight)
                .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.CenterStart,
        ) {
            Image(
                painter = painterResource(R.drawable.icon),
                contentDescription = stringResource(R.string.irrrw_app_logo_description),
                modifier = Modifier
                    .padding(horizontal = dimens.cardPadding)
                    .size(LogoSize)
                    .clip(logoShape)
                    .imageBorder(logoShape),
            )
        }

        Column(modifier = Modifier.padding(dimens.cardPadding)) {
            Text(
                text = stringResource(R.string.app_name),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            if (companyName.isNotBlank()) {
                Text(
                    text = companyName,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }

            Spacer(modifier = Modifier.height(dimens.tightSpacing))

            Row {
                Text(
                    text = stringResource(R.string.settings_screen_version_label),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodySmall,
                )

                Spacer(modifier = Modifier.width(dimens.tightSpacing))

                Text(
                    text = stringResource(R.string.irrrw_app_version),
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }
    }
}
