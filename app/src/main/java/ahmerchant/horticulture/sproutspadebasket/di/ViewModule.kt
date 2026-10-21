package ahmerchant.horticulture.sproutspadebasket.di

import ahmerchant.horticulture.sproutspadebasket.ui.viewmodel.AppViewModel
import ahmerchant.horticulture.sproutspadebasket.ui.viewmodel.CartViewModel
import ahmerchant.horticulture.sproutspadebasket.ui.viewmodel.CheckoutViewModel
import ahmerchant.horticulture.sproutspadebasket.ui.viewmodel.OnboardingViewModel
import ahmerchant.horticulture.sproutspadebasket.ui.viewmodel.OrderViewModel
import ahmerchant.horticulture.sproutspadebasket.ui.viewmodel.ProductDetailsViewModel
import ahmerchant.horticulture.sproutspadebasket.ui.viewmodel.ProductViewModel
import ahmerchant.horticulture.sproutspadebasket.ui.viewmodel.SplashViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel {
        AppViewModel(
            cartRepository = get()
        )
    }

    viewModel {
        SplashViewModel(
            onboardingRepository = get()
        )
    }

    viewModel {
        OnboardingViewModel(
            onboardingRepository = get()
        )
    }

    viewModel {
        ProductViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        ProductDetailsViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        CheckoutViewModel(
            cartRepository = get(),
            productRepository = get(),
            orderRepository = get(),
        )
    }

    viewModel {
        CartViewModel(
            cartRepository = get(),
            productRepository = get(),
        )
    }

    viewModel {
        OrderViewModel(
            orderRepository = get(),
        )
    }
}