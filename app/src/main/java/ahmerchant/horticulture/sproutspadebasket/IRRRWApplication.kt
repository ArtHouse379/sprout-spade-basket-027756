package ahmerchant.horticulture.sproutspadebasket

import android.app.Application
import ahmerchant.horticulture.sproutspadebasket.di.dataModule
import ahmerchant.horticulture.sproutspadebasket.di.dispatcherModule
import ahmerchant.horticulture.sproutspadebasket.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class IRRRWApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val appModules = dataModule + viewModule + dispatcherModule

        startKoin {
            androidLogger()
            androidContext(this@IRRRWApplication)
            modules(appModules)
        }
    }
}
