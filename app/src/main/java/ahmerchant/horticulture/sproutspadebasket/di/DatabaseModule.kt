package ahmerchant.horticulture.sproutspadebasket.di

import androidx.room.Room
import ahmerchant.horticulture.sproutspadebasket.data.database.IRRRWAppDatabase
import org.koin.dsl.module

private const val DB_NAME = "irrrw_db"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = IRRRWAppDatabase::class.java,
            name = DB_NAME
        ).build()
    }

    single { get<IRRRWAppDatabase>().cartItemDao() }

    single { get<IRRRWAppDatabase>().orderDao() }
}