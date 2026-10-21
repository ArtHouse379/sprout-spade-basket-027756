package ahmerchant.horticulture.sproutspadebasket.ui.composable.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import ahmerchant.horticulture.sproutspadebasket.ui.composable.screen.cart.IRRRWCartScreen
import ahmerchant.horticulture.sproutspadebasket.ui.composable.screen.checkout.IRRRWCheckoutScreen
import ahmerchant.horticulture.sproutspadebasket.ui.composable.screen.home.IRRRWHomeScreen
import ahmerchant.horticulture.sproutspadebasket.ui.composable.screen.onboarding.IRRRWOnboardingScreen
import ahmerchant.horticulture.sproutspadebasket.ui.composable.screen.order.IRRRWOrdersScreen
import ahmerchant.horticulture.sproutspadebasket.ui.composable.screen.productdetails.IRRRWProductDetailsScreen
import ahmerchant.horticulture.sproutspadebasket.ui.composable.screen.settings.IRRRWSettingsScreen
import ahmerchant.horticulture.sproutspadebasket.ui.composable.screen.splash.IRRRWSplashScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Splash,
        modifier = modifier,
    ) {
        composable<NavRoute.Splash> {
            IRRRWSplashScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(route = NavRoute.Home) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                onNavigateToOnboarding = {
                    navController.navigate(route = NavRoute.Onboarding) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Onboarding> {
            IRRRWOnboardingScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(NavRoute.Home) {
                        popUpTo(NavRoute.Onboarding) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Home> {
            IRRRWHomeScreen(
                onNavigateToProductDetails = { id: Int ->
                    navController.navigate(
                        route = NavRoute.ProductDetails(id = id)
                    )
                }
            )
        }

        composable<NavRoute.ProductDetails> { backStackEntry ->
            val productDetails: NavRoute.ProductDetails = backStackEntry.toRoute()
            IRRRWProductDetailsScreen(
                productId = productDetails.id,
            )
        }

        composable<NavRoute.Cart> {
            IRRRWCartScreen(
                onNavigateToCheckoutScreen = {
                    navController.navigate(NavRoute.Checkout)
                }
            )
        }

        composable<NavRoute.Checkout> {
            IRRRWCheckoutScreen(
                onNavigateToOrdersScreen = {
                    navController.navigate(NavRoute.Orders) {
                        popUpTo(NavRoute.Home) { inclusive = false }
                    }
                }
            )
        }

        composable<NavRoute.Orders> {
            IRRRWOrdersScreen()
        }

        composable<NavRoute.Settings> {
            IRRRWSettingsScreen()
        }
    }
}