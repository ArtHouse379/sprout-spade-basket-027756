package ahmerchant.horticulture.sproutspadebasket.di

import ahmerchant.horticulture.sproutspadebasket.data.datastore.OnboardingDataStoreManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataStoreModule = module {
    single { OnboardingDataStoreManager(androidContext()) }
}