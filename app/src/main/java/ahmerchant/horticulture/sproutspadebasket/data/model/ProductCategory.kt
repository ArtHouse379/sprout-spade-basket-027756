package ahmerchant.horticulture.sproutspadebasket.data.model

import androidx.annotation.StringRes
import ahmerchant.horticulture.sproutspadebasket.R

enum class ProductCategory(@field:StringRes val titleRes: Int) {
    PRUNING_TOOLS(R.string.product_category_pruning_tools_title),
    DIGGING_TOOLS(R.string.product_category_digging_tools_title),
    SEEDLINGS(R.string.product_category_seedlings_title),
    SEEDS(R.string.product_category_seeds_title),
    WATERING(R.string.product_category_watering_title),
}
