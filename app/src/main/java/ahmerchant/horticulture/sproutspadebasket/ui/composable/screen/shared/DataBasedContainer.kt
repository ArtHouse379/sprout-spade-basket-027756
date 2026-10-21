package ahmerchant.horticulture.sproutspadebasket.ui.composable.screen.shared

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ahmerchant.horticulture.sproutspadebasket.ui.state.DataUiState

@Composable
fun <T> DataBasedContainer(
    modifier: Modifier = Modifier,
    dataState: DataUiState<T>,
    dataPopulated: @Composable (() -> Unit),
    dataEmpty: @Composable (() -> Unit),
    dataInitial: @Composable (() -> Unit) = {},
) {
    Box(modifier = modifier) {
        when (dataState) {
            DataUiState.Initial -> {
                dataInitial()
            }

            is DataUiState.Populated -> {
                dataPopulated()
            }

            DataUiState.Empty -> {
                dataEmpty()
            }
        }
    }
}