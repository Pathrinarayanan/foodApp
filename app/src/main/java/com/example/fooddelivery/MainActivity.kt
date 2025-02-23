package com.example.fooddelivery

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fooddelivery.Home.BestSellersPage
import com.example.fooddelivery.Home.FavoritesPage
import com.example.fooddelivery.Home.HelpCenter
import com.example.fooddelivery.Home.HomeCV
import com.example.fooddelivery.Home.HomeSplashScreen
import com.example.fooddelivery.Home.MainPage
import com.example.fooddelivery.Home.MyOrders
import com.example.fooddelivery.Home.ProductDetailsPage
import com.example.fooddelivery.Home.model.FlowData
import com.example.fooddelivery.Home.model.MenuItem
import com.example.fooddelivery.authentication.ui.BottomBar
import com.example.fooddelivery.authentication.ui.Login
import com.example.fooddelivery.onboarding.ui.OnBoardingPage
import com.example.fooddelivery.ui.theme.FoodDeliveryTheme
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

class MainActivity : ComponentActivity() {
    private lateinit var viewmodel: MainViewmodel
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        window.statusBarColor = resources.getColor(R.color.yellow_base)
        viewmodel = ViewModelProvider(this).get(MainViewmodel::class.java)
        setContent {
            FoodDeliveryTheme {
                val navController = rememberNavController()
                val currentBackStackEntry = navController.currentBackStackEntryAsState()
                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomBar(){page->
                            when (page) {
                                0 -> navController.navigate("home")
                                1 -> navController.navigate("bestSellers")
                                2 -> navController.navigate("favorites")
                                3 -> navController.navigate("myOrders")
                                4 -> navController.navigate("help")
                            }
                        }
                    }

                ) { innerPadding ->
                    NavHost(startDestination = "splash", navController = navController, modifier = Modifier.padding(paddingValues = innerPadding) ) {
                        composable("Main"){
                            MainPage(navController,viewmodel)
                        }
                        composable("home") {
                            HomeCV(viewmodel, navController)
                        }
                        composable("login") {
                            Login()
                        }
                        composable("onboarding") {
                            OnBoardingPage(navController)
                        }
                        composable("help") {
                            HelpCenter()
                        }
                        composable("favorites") {
                            FavoritesPage()
                        }
                        composable("myOrders") {
                            MyOrders()
                        }
                        composable("bestSellers") {
                            BestSellersPage(viewmodel)
                        }
                        composable("splash") {
                            HomeSplashScreen(navController,viewmodel)
                        }
                        composable("details/{menuItem}", arguments = listOf(navArgument("menuItem") {type = NavType.StringType })){currentBackStackEntry->
                            val menuItem = currentBackStackEntry.arguments?.getString("menuItem")

                            val decodedMenu = URLDecoder.decode(menuItem, StandardCharsets.UTF_8.toString())
                            val data = Json.decodeFromString<MenuItem>(decodedMenu ?:"")
                            ProductDetailsPage(data,viewmodel)
                        }

                    }
                }

            }
        }
        viewmodel.viewModelScope.launch {
            viewmodel.getHomePageData()
        }
        initObservers()
    }
    fun initObservers(){
        viewmodel.viewModelScope.launch {
            viewmodel.sharedFlow.collect{
                when(it){
                    is FlowData.Toast->{
                        Toast.makeText(applicationContext, it.msg, Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodDeliveryTheme {
        Greeting("Android")
    }
}