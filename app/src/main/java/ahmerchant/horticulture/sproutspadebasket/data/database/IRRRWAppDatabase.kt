package ahmerchant.horticulture.sproutspadebasket.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ahmerchant.horticulture.sproutspadebasket.data.database.dao.CartItemDao
import ahmerchant.horticulture.sproutspadebasket.data.database.dao.OrderDao
import ahmerchant.horticulture.sproutspadebasket.data.database.converter.Converters
import ahmerchant.horticulture.sproutspadebasket.data.entity.CartItemEntity
import ahmerchant.horticulture.sproutspadebasket.data.entity.OrderEntity

@Database(
    entities = [CartItemEntity::class, OrderEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class IRRRWAppDatabase : RoomDatabase() {

    abstract fun cartItemDao(): CartItemDao

    abstract fun orderDao(): OrderDao
}