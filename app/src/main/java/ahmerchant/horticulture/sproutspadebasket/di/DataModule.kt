package ahmerchant.horticulture.sproutspadebasket.di

import ahmerchant.horticulture.sproutspadebasket.data.repository.CartRepository
import ahmerchant.horticulture.sproutspadebasket.data.repository.OnboardingRepository
import ahmerchant.horticulture.sproutspadebasket.data.repository.OrderRepository
import ahmerchant.horticulture.sproutspadebasket.data.repository.ProductRepository

import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    includes(databaseModule, dataStoreModule)

    single {
        OnboardingRepository(
            onboardingDataStoreManager = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single { ProductRepository() }

    single {
        CartRepository(
            cartItemDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single {
        OrderRepository(
            orderDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }
}