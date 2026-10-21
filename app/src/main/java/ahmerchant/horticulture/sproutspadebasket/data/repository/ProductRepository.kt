package ahmerchant.horticulture.sproutspadebasket.data.repository

import ahmerchant.horticulture.sproutspadebasket.data.model.Product
import ahmerchant.horticulture.sproutspadebasket.data.model.ProductCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ProductRepository {
    private val products = listOf<Product>(
        Product(
            id = 1,
            title = "Pruning Shears",
            description = "These bypass pruning shears make clean cuts on flowers, herbs, and young stems. A spring-loaded action reduces hand strain during regular garden care. The locking catch keeps the blades closed between jobs. They are a practical choice for precise seasonal pruning.",
            category = ProductCategory.PRUNING_TOOLS,
            price = 18.99,
            imageUrl = "https://images.pexels.com/photos/4270181/pexels-photo-4270181.jpeg",
        ),
        Product(
            id = 2,
            title = "Hedge Shears",
            description = "These hedge shears are designed for shaping shrubs and trimming soft new growth. Long handles provide useful reach and leverage along wider hedges. The straight blades help create neat edges with controlled strokes. They suit routine maintenance in small and medium gardens.",
            category = ProductCategory.PRUNING_TOOLS,
            price = 29.99,
            imageUrl = "https://images.pexels.com/photos/38936347/pexels-photo-38936347.jpeg",
        ),
        Product(
            id = 3,
            title = "Garden Shovel",
            description = "This garden shovel has a pointed steel blade for breaking soil and opening planting holes. Its sturdy shaft handles regular digging in beds and borders. A shaped grip offers steady control when moving compost or loose earth. It is sized for everyday garden projects.",
            category = ProductCategory.DIGGING_TOOLS,
            price = 24.99,
            imageUrl = "https://images.pexels.com/photos/1301856/pexels-photo-1301856.jpeg",
        ),
        Product(
            id = 4,
            title = "Hand Trowel",
            description = "This compact hand trowel is made for planting bulbs, seedlings, and container plants. The narrow metal scoop works neatly around established roots. Its comfortable handle gives good control in raised beds and pots. It is easy to clean after routine planting work.",
            category = ProductCategory.DIGGING_TOOLS,
            price = 9.49,
            imageUrl = "https://images.pexels.com/photos/18222297/pexels-photo-18222297.jpeg",
        ),
        Product(
            id = 5,
            title = "Tomato Seedling",
            description = "This healthy tomato seedling is ready to establish in a sunny bed, grow bag, or large container. Strong young growth gives it a useful head start on the growing season. Plant after the risk of frost has passed and keep the soil evenly moist. Support the main stem as the plant develops.",
            category = ProductCategory.SEEDLINGS,
            price = 3.99,
            imageUrl = "https://images.pexels.com/photos/12309430/pexels-photo-12309430.jpeg",
        ),
        Product(
            id = 6,
            title = "Basil Seedling",
            description = "This basil seedling brings fresh aromatic leaves to a kitchen windowsill or warm patio. It arrives established in a nursery pot and is ready for transplanting. Pinch the growing tips regularly to encourage bushy growth. Keep it sheltered from cold weather and water when the compost begins to dry.",
            category = ProductCategory.SEEDLINGS,
            price = 2.79,
            imageUrl = "https://images.pexels.com/photos/25315859/pexels-photo-25315859.jpeg",
        ),
        Product(
            id = 7,
            title = "Pea Seeds",
            description = "This packet contains pea seeds for sowing in garden rows or deep containers. The plants climb readily when given netting or twig supports. Sow in succession for a longer harvest of sweet green pods. The packet includes clear spacing and growing guidance.",
            category = ProductCategory.SEEDS,
            price = 2.49,
            imageUrl = "https://images.pexels.com/photos/7782153/pexels-photo-7782153.jpeg",
        ),
        Product(
            id = 8,
            title = "Wildflower Seeds",
            description = "This wildflower seed mix creates a varied patch of annual blooms for garden pollinators. Scatter it over prepared soil in a sunny open area and rake lightly. The blend is suitable for borders, containers, or a small meadow strip. Regular watering supports germination during dry spells.",
            category = ProductCategory.SEEDS,
            price = 4.29,
            imageUrl = "https://images.pexels.com/photos/9154522/pexels-photo-9154522.jpeg",
        ),
        Product(
            id = 9,
            title = "Watering Can",
            description = "This metal watering can provides a balanced way to carry water around beds and containers. Its long spout reaches beneath foliage without disturbing the soil surface. A removable rose creates a gentler shower for seedlings and delicate plants. The durable body is suitable for regular outdoor use.",
            category = ProductCategory.WATERING,
            price = 22.99,
            imageUrl = "https://images.pexels.com/photos/15085874/pexels-photo-15085874.jpeg",
        ),
        Product(
            id = 10,
            title = "Garden Hose",
            description = "This flexible garden hose supplies water across lawns, borders, and vegetable beds. Its 20-metre length provides useful reach for an average garden. Standard fittings connect easily to common outdoor taps and spray nozzles. Store it drained and loosely coiled to help prevent kinks.",
            category = ProductCategory.WATERING,
            price = 27.99,
            imageUrl = "https://images.pexels.com/photos/15291278/pexels-photo-15291278.jpeg",
        ),
    )

    fun observeById(id: Int): Flow<Product?> {
        val item = products.find { it.id == id }
        return flowOf(item)
    }

    fun getById(id: Int): Product? {
        return products.find { it.id == id }
    }

    fun observeAll(): Flow<List<Product>> {
        return flowOf(products)
    }
}
