package ahmerchant.horticulture.sproutspadebasket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ahmerchant.horticulture.sproutspadebasket.ui.composable.approot.AppRoot
import ahmerchant.horticulture.sproutspadebasket.ui.theme.IRRRWAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IRRRWAppTheme {
                AppRoot()
            }
        }
    }
}
