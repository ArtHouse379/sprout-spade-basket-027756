package ahmerchant.horticulture.sproutspadebasket.ui.composable.screen.order

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ahmerchant.horticulture.sproutspadebasket.R
import ahmerchant.horticulture.sproutspadebasket.data.entity.OrderEntity
import ahmerchant.horticulture.sproutspadebasket.ui.composable.approot.LocalContentBottomPadding
import ahmerchant.horticulture.sproutspadebasket.ui.composable.screen.order.card.OrderItem
import ahmerchant.horticulture.sproutspadebasket.ui.composable.screen.shared.DataBasedContainer
import ahmerchant.horticulture.sproutspadebasket.ui.composable.screen.shared.DataEmptyContent
import ahmerchant.horticulture.sproutspadebasket.ui.state.DataUiState
import ahmerchant.horticulture.sproutspadebasket.ui.theme.LocalDimens
import ahmerchant.horticulture.sproutspadebasket.ui.viewmodel.OrderViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun IRRRWOrdersScreen(
    modifier: Modifier = Modifier,
    viewModel: OrderViewModel = koinViewModel(),
) {
    val ordersState by viewModel.ordersState.collectAsState()

    OrdersContent(
        ordersState = ordersState,
        modifier = modifier,
    )
}

@Composable
private fun OrdersContent(
    ordersState: DataUiState<List<OrderEntity>>,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current

    Column(modifier = modifier) {

        DataBasedContainer(
            modifier = Modifier.fillMaxSize(),
            dataState = ordersState,

            dataPopulated = {
                val data = (ordersState as DataUiState.Populated<List<OrderEntity>>).data

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(
                        start = dimens.screenPadding,
                        end = dimens.screenPadding,
                        top = dimens.screenPadding,
                        bottom = dimens.screenPadding + LocalContentBottomPadding.current,
                    ),
                    verticalArrangement = Arrangement.spacedBy(dimens.contentSpacing),
                ) {
                    items(items = data, key = { order -> order.orderNumber }) { order ->
                        OrderItem(order = order)
                    }
                }
            },

            dataEmpty = {
                DataEmptyContent(
                    primaryText = stringResource(R.string.orders_state_empty_primary_text),
                    modifier = Modifier.fillMaxSize(),
                )
            },
        )
    }
}
