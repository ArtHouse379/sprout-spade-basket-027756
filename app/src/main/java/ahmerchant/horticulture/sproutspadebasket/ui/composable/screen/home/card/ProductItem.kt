package ahmerchant.horticulture.sproutspadebasket.ui.composable.screen.home.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ahmerchant.horticulture.sproutspadebasket.R
import ahmerchant.horticulture.sproutspadebasket.data.model.Product
import ahmerchant.horticulture.sproutspadebasket.ui.composable.screen.shared.ProductImage
import ahmerchant.horticulture.sproutspadebasket.ui.theme.LocalDimens
import ahmerchant.horticulture.sproutspadebasket.ui.theme.cardBorderStroke
import ahmerchant.horticulture.sproutspadebasket.ui.theme.imageBorder

@Composable
fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    onAddToCartClick: () -> Unit,
) {
    val dimens = LocalDimens.current

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
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
                .height(180.dp)
                .imageBorder(RectangleShape),
        ) {
            ProductImage(
                imageUrl = product.imageUrl,
                modifier = Modifier.matchParentSize(),
            )

            Badge(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(dimens.cardPadding),
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
            ) {
                Text(
                    text = stringResource(product.category.titleRes),
                    modifier = Modifier.padding(horizontal = 6.dp),
                    style = MaterialTheme.typography.labelSmall,
                )
            }
        }

        Row(
            modifier = Modifier.padding(dimens.cardPadding),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = product.title,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )

                Spacer(modifier = Modifier.height(dimens.itemSpacing))

                Text(
                    text = stringResource(R.string.price, product.price),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleMedium,
                )
            }

            IconButton(
                onClick = onAddToCartClick,
                colors = IconButtonDefaults.filledIconButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                ),
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.add_to_cart_icon_description),
                    tint = MaterialTheme.colorScheme.onPrimary,
                )
            }
        }
    }
}
