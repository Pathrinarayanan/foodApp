package com.example.fooddelivery.Home

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.fooddelivery.Home.model.MenuItem

import com.example.fooddelivery.Home.model.NavigationDrawerItem
import com.example.fooddelivery.MainViewmodel
import com.example.fooddelivery.R
import com.example.fooddelivery.authentication.ui.BottomBar
import com.google.gson.Gson
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import kotlin.math.roundToInt


@Composable
fun NavigationItem(data :NavigationDrawerItem, fontsize : Int){
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(data.id),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )
            }
            Text(
                data.title,
                fontSize = fontsize.sp,
                color = colorResource(R.color.yellow_2)
            )

        }

    }
}

@Composable
fun MyorderItem(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White)
            .padding(top = 16.dp)
    ){
        Image(
            painter = painterResource(R.drawable.strawberry),
            contentDescription = null,
            modifier = Modifier.size(80.dp, 100.dp)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ){
            Row(modifier = Modifier.padding(top =10.dp)){
                Text("Strawberry shake", color = colorResource(R.color.font_brown), fontWeight = FontWeight.W600)
                Spacer(modifier = Modifier.weight(1f))
                Text("₹20.00", color = colorResource(R.color.orange_base), fontWeight = FontWeight.W600)
            }
            Row(modifier = Modifier.padding(top =8.dp)){
                Text("29 Nov, 01:20 pm ", color = colorResource(R.color.font_brown), fontWeight = FontWeight.W400)
                Spacer(modifier = Modifier.weight(1f))
                Text("2 items", color = colorResource(R.color.font_brown), fontWeight = FontWeight.W400)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(top =5.dp)){
                Box(
                    modifier = Modifier
                        .height(28.dp)
                        .wrapContentWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(color = colorResource(R.color.orange_base)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("cancel order", color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,modifier = Modifier.padding(horizontal = 6.dp) )
                }
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .height(28.dp)
                        .wrapContentWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(color = colorResource(R.color.orange_2)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Track Driver", color = colorResource(R.color.orange_base),
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,modifier = Modifier.padding(horizontal = 10.dp) )
                }
            }

            }

        }
}



@Composable
fun OrderSuccessPage(){
    Scaffold (
        bottomBar = {
            Box(modifier = Modifier
                .wrapContentSize()
                .background(color = colorResource(R.color.yellow_base))) {
                BottomBar()
            }
        }
    ){
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(color = colorResource(R.color.yellow_base)),
            contentAlignment = Alignment.Center
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(15.dp),
                modifier = Modifier.padding(horizontal = 50.dp)
            ){
                Image(
                    painter = painterResource(R.drawable.order_success),
                    contentDescription = null,
                    modifier = Modifier.size(140.dp)
                )
                Text("Order Confirmed!", fontSize = 24.sp, fontWeight = FontWeight.W600, color = colorResource(R.color.font_brown))
                Text("Your order has been placed succesfully", fontSize = 16.sp, fontWeight = FontWeight.W600,color = colorResource(R.color.font_brown))
                Text("Delivery by Thu, 29th, 4:00 PM", fontSize = 16.sp, fontWeight = FontWeight.W400,modifier =Modifier.padding(top =10.dp),color = colorResource(R.color.font_brown))
                Text("Track my Order", fontSize = 16.sp, fontWeight = FontWeight.W700,modifier =Modifier.padding(top =10.dp),color = colorResource(R.color.orange_base))
                Text("If you have any questions, please reach out directly to our customer support", fontSize = 16.sp, fontWeight = FontWeight.W400,modifier =Modifier.padding(top =100.dp),color = colorResource(R.color.font_brown))

            }
        }
    }

}


@Composable
fun OrderConfirmItem(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White)
            .padding(top = 10.dp)

    ){
        Image(
            painter = painterResource(R.drawable.strawberry),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp)
                .size(80.dp, 100.dp)
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ){
            Row(modifier = Modifier.fillMaxWidth()){
                Spacer(modifier = Modifier.weight(1f))
                Image(painter = painterResource(R.drawable.trash_icon), contentDescription = null, modifier = Modifier.size(20.dp))
            }
            Row(modifier = Modifier.padding(top =10.dp)){
                Text("Strawberry shake", color = colorResource(R.color.font_brown), fontWeight = FontWeight.W600)
                Spacer(modifier = Modifier.weight(1f))
                Text("₹20.00", color = colorResource(R.color.orange_base), fontWeight = FontWeight.W600)
            }
            Row(modifier = Modifier.padding(top =8.dp)){
                Text("29 Nov, 01:20 pm ", color = colorResource(R.color.font_brown), fontWeight = FontWeight.W400)
                Spacer(modifier = Modifier.weight(1f))
                Text("2 items", color = colorResource(R.color.font_brown), fontWeight = FontWeight.W400)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top =5.dp)){
                Box(
                    modifier = Modifier
                        .height(28.dp)
                        .wrapContentWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(color = colorResource(R.color.orange_base)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("cancel order", color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,modifier = Modifier.padding(horizontal = 6.dp) )
                }
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier.padding(top =5.dp),
                    verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)){
                    Icon(
                        Icons.Filled.Create,
                        contentDescription = null,
                        modifier = Modifier.size(15.dp),
                        tint = colorResource(R.color.orange_base)
                    )
                    Image(
                        painter = painterResource(R.drawable.less_icon),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                    )
                    Text("2", fontSize = 18.sp,
                        fontWeight = FontWeight.W600,
                        color = colorResource(R.color.font_brown))
                    Image(
                        painter = painterResource(R.drawable.more_icon),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                    )
                }
            }

            }

        }
}



@Composable
fun MyOrders(){
    Scaffold (
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(
                        color = colorResource(R.color.yellow_base)
                    )
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(start = 35.dp)
                        .padding(vertical = 40.dp)
                ){
                    Icon(
                        Icons.Filled.KeyboardArrowLeft,
                        contentDescription = null,
                        tint = colorResource(R.color.orange_base)
                    )

                    Text(
                        "My Orders",
                        fontSize = 28.sp,
                        color = colorResource(R.color.font2),
                        fontWeight = FontWeight.W700,
                        modifier = Modifier
                            .padding(horizontal = 35.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center

                    )
                }

            }
        },
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(colorResource(R.color.yellow_base))
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
            ,
        ) {
            Column(
                modifier = Modifier.padding(top = 35.dp, start = 35.dp, end = 35.dp)
            ) {

                TabRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    selectedTabIndex = 0,
                    indicator = {
                        TabRowDefaults.Indicator(
                            color = Color.Transparent
                        )
                    }
                ) {
                    Tab(
                        selected = true,
                        onClick = {

                        },
                        content = {
                            Box(
                                modifier = Modifier
                                    .height(28.dp)
                                    .padding(horizontal = 10.dp)
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(color = colorResource(R.color.orange_base)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("Active", color = Color.White, fontSize = 18.sp)
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Tab(
                        selected = true,
                        onClick = {

                        },
                        content = {
                            Box(
                                modifier = Modifier
                                    .height(28.dp)
                                    .wrapContentWidth()
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(color = colorResource(R.color.orange_base)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("Completed", color = Color.White, fontSize = 18.sp, modifier = Modifier
                                    .padding(horizontal = 5.dp)
                                    .fillMaxWidth())
                            }
                        }
                    )
                    Tab(
                        selected = true,
                        onClick = {

                        },
                        content = {
                            Box(
                                modifier = Modifier
                                    .height(28.dp)
                                    .padding(horizontal = 10.dp)
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(color = colorResource(R.color.orange_base)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("Canceled", color = Color.White, fontSize = 18.sp)
                            }
                        }
                    )
                }
//                Box(
//                    modifier = Modifier.fillMaxSize(),
//                    contentAlignment = Alignment.Center
//                ){
//                    Column (
//                        verticalArrangement = Arrangement.spacedBy(20.dp),
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        modifier = Modifier.padding(horizontal = 20.dp)
//                    ){
//                        Image(
//                            painter = painterResource(R.drawable.transfer_document_icon),
//                            contentDescription = null,
//                            modifier = Modifier.size(150.dp)
//                        )
//                        Text(
//                            "You don't have any active orders at this time",
//                            fontWeight = FontWeight.Medium,
//                            color = colorResource(R.color.orange_base),
//                            fontSize = 30.sp,
//                            textAlign = TextAlign.Center
//                        )
//                    }
//                }
                Spacer(modifier = Modifier
                    .padding(top = 20.dp)
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(Color(0xffffd8c7)))
                for(i in 0..3) {
                    MyorderItem()
                    Spacer(
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .height(1.dp)
                            .fillMaxWidth()
                            .background(Color(0xffffd8c7))
                    )
                }
            }



        }
    }
}


@Composable
fun  ProductDetailsPage(menuItem: MenuItem?, viewmodel: MainViewmodel) {
    val baseUrl = viewmodel.homeData.value?.base_image_url
    Scaffold (
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(
                        color = colorResource(R.color.yellow_base)
                    )
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(start = 35.dp)
                        .padding(vertical = 40.dp)
                ){
                    Icon(
                        Icons.Filled.KeyboardArrowLeft,
                        contentDescription = null,
                        tint = colorResource(R.color.orange_base)
                    )

                    Text(
                        menuItem?.name ?:"",
                        fontSize = 14.sp,
                        color = colorResource(R.color.font_brown),
                        fontWeight = FontWeight.W700,
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .wrapContentWidth(),

                        )
                    Image(
                        painter = painterResource(R.drawable.closed_heart),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .width(30.dp)
                            .height(16.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(color = colorResource(R.color.orange_base)),
                        contentAlignment = Alignment.Center

                    ) {
                        Text(
                            "5 ⭐",
                            color = colorResource(R.color.white),
                            fontSize = 10.sp
                        )
                    }
                }

            }
        },

    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(colorResource(R.color.yellow_base))
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
            ,
        ) {
            Column(
                modifier = Modifier.padding(top = 35.dp, start = 35.dp, end = 35.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Image(
                    painter = if(menuItem?.image_url.isNullOrEmpty().not()) rememberAsyncImagePainter(baseUrl+ menuItem?.image_url) else painterResource(R.drawable.pizza) ,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.FillBounds
                )
                Spacer(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(Color(0xffffd8c7))
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "₹${menuItem?.price}",
                        color = colorResource(R.color.orange_base),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W600
                    )
                    Text(
                        "₹${ (menuItem?.price ?:0) + 20}",
                        color = colorResource(R.color.yellow_base),
                        textDecoration = TextDecoration.LineThrough,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W600
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(Color(0xffffd8c7))
                )
                Text(
                    menuItem?.name ?:"",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600, color = colorResource(R.color.font_brown)
                )
                Text(
                    menuItem?.description?:"",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400, color = colorResource(R.color.font_brown)
                )
                Text(
                    "Personal Portion",
                    modifier = Modifier.padding(top = 20.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600, color = colorResource(R.color.font_brown)
                )


                val pizzaSizes = listOf("Small (4 slides)", "Medium (8 slides)", "Jumbo (10 slides)")
                var selectedSize by remember { mutableStateOf(pizzaSizes[0]) }

                    pizzaSizes.forEach { size ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(30.dp)
                                .clickable { selectedSize = size }

                        ) {
                            Text(
                                text = size,
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            RadioButton(
                                selected = (size == selectedSize),
                                onClick = { selectedSize = size },
                                colors = RadioButtonDefaults.colors(selectedColor = colorResource(R.color.orange_base), unselectedColor = colorResource(R.color.orange_base))
                            )

                        }


                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ){
                    Text("Add to Cart", fontWeight = FontWeight.W600, color = Color.White,modifier = Modifier
                        .clip(
                            RoundedCornerShape(12.dp)
                        )
                        .background(color = colorResource(R.color.orange_base))
                        .padding(horizontal = 16.dp, vertical = 10.dp))
                }
            }
        }
    }
}

@Composable
fun PaymentPage(){
    Scaffold (
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(
                        color = colorResource(R.color.yellow_base)
                    )
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(start = 35.dp)
                        .padding(vertical = 40.dp)
                ){
                    Icon(
                        Icons.Filled.KeyboardArrowLeft,
                        contentDescription = null,
                        tint = colorResource(R.color.orange_base)
                    )

                    Text(
                        "Payment",
                        fontSize = 28.sp,
                        color = colorResource(R.color.font2),
                        fontWeight = FontWeight.W700,
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .fillMaxWidth(),

                    )
                }

            }
        },
        bottomBar = {
            BottomBar()
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(colorResource(R.color.yellow_base))
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
            ,
        ) {
            Column(
                modifier = Modifier.padding(top = 35.dp, start = 35.dp, end = 35.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    Text("Shipping Address", fontSize = 20.sp, color = colorResource(R.color.font_brown))
                    Icon(
                        Icons.Filled.Create,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = colorResource(R.color.orange_base)
                    )
                }
                Box(
                    modifier = Modifier
                        .height(35.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(colorResource(R.color.yellow_2)),
                    contentAlignment = Alignment.CenterStart
                ){
                    Text("778 Locust View Drive Oaklanda, CA", fontSize = 16.sp, color = colorResource(R.color.font_brown),modifier = Modifier.padding(start = 10.dp))
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Order Summary",
                        color = colorResource(R.color.font_brown),
                        fontWeight = FontWeight.W600
                    )
                    Spacer(modifier =Modifier.weight(1f))
                    Box(
                        modifier = Modifier
                            .wrapContentWidth()
                            .wrapContentHeight()
                            .clip(RoundedCornerShape(12.dp))
                            .background(color = colorResource(R.color.orange_2))
                            .padding(horizontal = 10.dp, vertical = 5.dp)

                    ){
                        Text(
                            "Edit",
                            fontSize = 12.sp,
                            color = colorResource(R.color.orange_base)
                        )
                    }

                }

                for(i in 0..2) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text("Strawberry Shake", color = colorResource(R.color.font_brown))
                        Text("2 items", color = colorResource(R.color.orange_base))
                        if(i == 2){
                            Spacer(modifier = Modifier.weight(1f))
                            Text("₹40.00", fontSize = 20.sp, color = colorResource(R.color.font_brown), fontWeight = FontWeight.W700)

                        }
                    }

                }


                Spacer(modifier = Modifier
                    .padding(top = 10.dp)
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(Color(0xffffd8c7)))
                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ){
                    Text(
                        "Delivery Time",
                        color = colorResource(R.color.font_brown),
                        fontWeight = FontWeight.W600
                    )
                    Row {
                        Text(
                            "Estimated Delivery",
                            color = colorResource(R.color.font_brown),
                            fontWeight = FontWeight.W400
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            "25 mins",
                            color = colorResource(R.color.orange_base),
                            fontWeight = FontWeight.W600,
                            fontSize = 20.sp
                        )

                    }
                    Spacer(modifier = Modifier
                        .padding(top = 10.dp)
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(Color(0xffffd8c7)))

                    Box(
                        modifier = Modifier
                            .padding(top = 50.dp)
                            .wrapContentWidth()
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(color = colorResource(R.color.orange_2))
                            .padding(horizontal = 15.dp)
                            .padding(vertical = 10.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Text("Pay Now", color = colorResource(R.color.orange_base))
                    }
                }

            }



        }
    }
}

@Composable
fun OrderConfirmPage(){
    Scaffold (
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(
                        color = colorResource(R.color.yellow_base)
                    )
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(start = 35.dp)
                        .padding(vertical = 40.dp)
                ){
                    Icon(
                        Icons.Filled.KeyboardArrowLeft,
                        contentDescription = null,
                        tint = colorResource(R.color.orange_base)
                    )

                    Text(
                        "Confirm Order",
                        fontSize = 28.sp,
                        color = colorResource(R.color.font2),
                        fontWeight = FontWeight.W700,
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .fillMaxWidth(),

                    )
                }

            }
        },
        bottomBar = {
            BottomBar()
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(colorResource(R.color.yellow_base))
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
            ,
        ) {
            Column(
                modifier = Modifier.padding(top = 35.dp, start = 35.dp, end = 35.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    Text("Shipping Address", fontSize = 20.sp, color = colorResource(R.color.font_brown))
                    Icon(
                        Icons.Filled.Create,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = colorResource(R.color.orange_base)
                    )
                }
                Box(
                    modifier = Modifier
                        .height(35.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(colorResource(R.color.yellow_2)),
                    contentAlignment = Alignment.CenterStart
                ){
                    Text("778 Locust View Drive Oaklanda, CA", fontSize = 16.sp, color = colorResource(R.color.font_brown),modifier = Modifier.padding(start = 10.dp))
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Order Summary",
                        color = colorResource(R.color.font_brown),
                        fontWeight = FontWeight.W600
                    )
                    Spacer(modifier =Modifier.weight(1f))
                    Box(
                        modifier = Modifier
                            .wrapContentWidth()
                            .wrapContentHeight()
                            .clip(RoundedCornerShape(12.dp))
                            .background(color = colorResource(R.color.orange_2))
                            .padding(horizontal = 10.dp, vertical = 5.dp)

                    ){
                        Text(
                            "Edit",
                            fontSize = 12.sp,
                            color = colorResource(R.color.orange_base)
                        )
                    }

                }
                Spacer(modifier = Modifier
                    .padding(top = 10.dp)
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(Color(0xffffd8c7)))
                for(i in 0..3) {
                    OrderConfirmItem()
                    Spacer(
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth()
                            .background(Color(0xffffd8c7))
                    )
                }
            }



        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BestSellersPage(viewmodel: MainViewmodel) {
    BottomSheetScaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(
                        color = colorResource(R.color.yellow_base)
                    )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(start = 35.dp)
                        .padding(vertical = 40.dp)
                ) {
                    Icon(
                        Icons.Filled.KeyboardArrowLeft,
                        contentDescription = null,
                        tint = colorResource(R.color.orange_base)
                    )

                    Text(
                        "Best Sellers",
                        fontSize = 28.sp,
                        color = colorResource(R.color.font2),
                        fontWeight = FontWeight.W700,
                        modifier = Modifier
                            .padding(horizontal = 35.dp)

                    )
                }

            }
        },
        sheetPeekHeight = 720.dp,
        sheetDragHandle = null,
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(R.color.yellow_base))
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(Color.White),
            ) {
                Column(
                    modifier = Modifier.padding(top = 35.dp, start = 35.dp, end = 35.dp)
                ) {
                    Text(
                        "Discover our most popular dishes!",
                        color = colorResource(R.color.orange_base),
                        fontWeight = FontWeight.W600,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    val data: List<MenuItem> =
                        viewmodel.homeData.value?.data?.restaurant?.menu?.best_sellers ?: listOf()
                    val baseUrl = viewmodel.homeData.value?.base_image_url
                    LazyVerticalGrid(
                        modifier = Modifier
                            .padding(vertical = 20.dp),
                        verticalArrangement = Arrangement.spacedBy(15.dp),
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        columns = GridCells.Fixed(2),
                    ) {
                            data.forEach {
                                item {
                                    BestSellersItem(baseUrl ?: "", it)
                                }
                            }

                        }
                    }
                }

        })
}

@Composable
fun FavoritesPage(){
    Scaffold (
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(
                        color = colorResource(R.color.yellow_base)
                    )
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(start = 35.dp)
                        .padding(vertical = 40.dp)
                ){
                    Icon(
                        Icons.Filled.KeyboardArrowLeft,
                        contentDescription = null,
                        tint = colorResource(R.color.orange_base)
                    )

                        Text(
                            "Favorites",
                            fontSize = 28.sp,
                            color = colorResource(R.color.font2),
                            fontWeight = FontWeight.W700,
                            modifier = Modifier
                                .padding(horizontal = 35.dp)

                        )
                }

            }
        },
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(colorResource(R.color.yellow_base))
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
            ,
        ) {
            Column(
                modifier = Modifier.padding(top = 35.dp, start = 35.dp, end = 35.dp)
            ) {
                Text(
                    "It's time to buy your favorite dish.",
                    color = colorResource(R.color.orange_base),
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                LazyVerticalGrid(
                    modifier = Modifier.padding(vertical =20.dp,),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    columns = GridCells.Fixed(2),
                ) {
                    items(10) {
                        FavoriteItem()
                    }
                }
            }



        }
    }
}
@Composable
fun FavoriteItem(){
    Column(
        modifier = Modifier
            .width(150.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(12.dp))
        ) {

            Image(
                painter = painterResource(R.drawable.burger),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Row(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(26.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(color = colorResource(R.color.white))
                        .padding(4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.meals_icon),
                        contentDescription = null,
                        modifier = Modifier.matchParentSize()
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .size(26.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(color = colorResource(R.color.white))
                        .padding(5.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.filled_heart),
                        contentDescription = null,
                        modifier = Modifier.matchParentSize()
                    )
                }
            }
        }
        Text("Chicken Burger", fontSize = 16.sp, color = colorResource(R.color.orange_base), textAlign = TextAlign.Center, modifier = Modifier.padding(top =12.dp))
        Text("Lorem ipsum dolor sit amet, consectetur.", fontSize = 12.sp, color = colorResource(R.color.font_brown), modifier = Modifier.padding(start =15.dp,end =10.dp, top =5.dp))
    }
}

@Composable
fun BestSellersItem(baseUrl :String,item: MenuItem?) {
    Column(
        modifier = Modifier
            .width(150.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(12.dp)),
        ) {

            Image(
                painter = rememberAsyncImagePainter(baseUrl +item?.image_url),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
            Row(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(26.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(color = colorResource(R.color.white))
                        .padding(4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.meals_icon),
                        contentDescription = null,
                        modifier = Modifier.matchParentSize()
                    )

                }
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .size(26.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(color = colorResource(R.color.white))
                        .padding(5.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.filled_heart),
                        contentDescription = null,
                        modifier = Modifier.matchParentSize()
                    )
                }
            }
            Box(modifier = Modifier.matchParentSize(), contentAlignment = Alignment.BottomEnd) {
                Box(
                    modifier = Modifier
                        .padding(bottom = 12.dp)
                        .width(40.dp)
                        .height(20.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(color = colorResource(R.color.orange_base))
                        .padding(horizontal = 4.dp)
                        .padding(bottom = 4.dp),
                    contentAlignment = Alignment.Center

                ) {
                    Text(
                        "₹ ${item?.price}",
                        color = colorResource(R.color.white),
                        fontSize = 10.sp,
                        modifier =Modifier.fillMaxSize(),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(
                item?.name ?:"",
                fontSize = 16.sp,
                color = colorResource(R.color.orange_base),
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(0.8f)

                )
            Box(
                modifier = Modifier
                    .width(32.dp)
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(12.dp))
                    .background(color = colorResource(R.color.orange_base))
                    .padding(vertical = 4.dp, horizontal = 4.dp)
                    .weight(0.2f),
                contentAlignment = Alignment.CenterStart

            ) {
                Text(
                    "5 ⭐",
                    color = colorResource(R.color.white),
                    fontSize = 10.sp,
                    modifier = Modifier.fillMaxSize(),
                    textAlign = TextAlign.Center
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.padding( start = 10.dp, top = 5.dp)
        ) {
            Text(
                item?.description ?:"",
                fontSize = 12.sp,
                color = colorResource(R.color.font_brown),
                modifier = Modifier.weight(0.8f)
            )
            Box(
                modifier = Modifier
                    .size(25.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .background(color = colorResource(R.color.yellow_base))
                    .padding(6.dp),
                contentAlignment = Alignment.Center

            ) {
                 Image(
                     painter = painterResource(R.drawable.cart_icon),
                     contentDescription = null
                 )
            }

        }
    }
}
@Composable
fun FaqPage(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(R.color.font2))
        .padding(horizontal = 35.dp)
        .padding(top = 30.dp)
        ,
    ) {
        Box(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(30.dp))
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier.matchParentSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Search",
                    modifier = Modifier.padding(start = 12.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .size(20.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(color = colorResource(R.color.orange_base)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.filter_icon),
                        contentDescription = null
                    )
                }
            }
        }
        Spacer(modifier = Modifier
            .padding(top = 20.dp)
            .height(1.dp)
            .fillMaxWidth()
            .background(Color(0xffffd8c7)))
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 20.dp)
        ){

            Text(
                "Lorem ipsum dolor sit amet?",
                fontSize = 16.sp,
                fontWeight = FontWeight.W600,
                color = colorResource(R.color.font_brown),

            )
            Spacer(modifier =Modifier.weight(1f))
            Icon(
                Icons.Filled.KeyboardArrowDown,
                contentDescription = null,
                tint = colorResource(R.color.orange_base)
            )
        }
        Spacer(modifier = Modifier
            .padding(top = 20.dp)
            .height(1.dp)
            .fillMaxWidth()
            .background(Color(0xffffd8c7)))
        Text(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent pellentesque congue lorem, vel tincidunt tortor placerat a. Proin ac diam quam. Aenean in sagittis magna, ut feugiat diam.",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(R.color.font_brown),
            modifier = Modifier.padding(top =20.dp)

        )
}
}

@Composable
fun ContactUsPage(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White)
    ){
        val data = listOf(
         NavigationDrawerItem(R.drawable.headphones_icon, "Customer Service"),
         NavigationDrawerItem(R.drawable.global_icon, "Website"),
         NavigationDrawerItem(R.drawable.whatapp_icon, "Whatsapp"),
         NavigationDrawerItem(R.drawable.facebook, "Facebook"),
         NavigationDrawerItem(R.drawable.instagram, "Instagram"),

        )
        for(items in data)
            ContactUsItem(items.title, items.id)

    }
}

@Composable
fun ContactUsItem(title:String, @DrawableRes id :Int){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White)
            .padding(horizontal = 35.dp, vertical = 30.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ){
        Image(
            painter = painterResource(id),
            contentDescription = null,
        )
        Text(title , color = colorResource(R.color.font_brown), fontWeight = FontWeight.W600)
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            Icons.Filled.KeyboardArrowDown,
            contentDescription = null,
            tint = colorResource(R.color.orange_base),
            modifier = Modifier.padding(end =16.dp)
        )
    }
}
@Composable
fun HelpCenter(){
    Scaffold (
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(
                        color = colorResource(R.color.yellow_base)
                    )
            ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 35.dp, top =20.dp)
            ){
                Icon(
                    Icons.Filled.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = colorResource(R.color.orange_base)
                )
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .padding(bottom = 20.dp)
                ) {

                    Text(
                        "Help Center",
                        fontSize = 28.sp,
                        color = colorResource(R.color.font2),
                        fontWeight = FontWeight.W700,
                        modifier = Modifier
                            .padding(horizontal = 35.dp)
                            .padding(top = 16.dp)
                    )
                    Text(
                        "how can we help you?",
                        fontSize = 13.sp,
                        color = colorResource(R.color.orange_base),
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(horizontal = 35.dp)
                    )


                }
            }

            }
        },
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(colorResource(R.color.yellow_base))
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
                .verticalScroll(rememberScrollState())
            ,
        ) {
            Column(
                modifier = Modifier.padding(top = 35.dp, start = 35.dp, end = 35.dp)
            ) {
                TabRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    selectedTabIndex = 0,
                    indicator = {
                        TabRowDefaults.Indicator(
                            color = Color.Transparent
                        )
                    }
                ) {
                    Tab(
                        selected = true,
                        onClick = {

                        },
                        content = {
                            Box(
                                modifier = Modifier
                                    .height(28.dp)
                                    .padding(horizontal = 20.dp)
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(color = colorResource(R.color.orange_base)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("FAQ", color = Color.White, fontSize = 18.sp)
                            }
                        }
                    )

                    Tab(
                        selected = true,
                        onClick = {

                        },
                        content = {
                            Box(
                                modifier = Modifier
                                    .height(28.dp)
                                    .padding(horizontal = 20.dp)
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(color = colorResource(R.color.orange_base)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("Contact us", color = Color.White, fontSize = 18.sp)
                            }
                        }
                    )
                }
            }



            }
        }

    }



@Composable
fun NotificationNavigationDrawer(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clip(
                RoundedCornerShape(topStart = 100.dp, bottomStart = 100.dp)
            )
            .background(color = colorResource(R.color.orange_base))
            .padding(25.dp)
            .padding(end = 50.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp),
    ) {
        val noficationItems  = listOf(
            NavigationDrawerItem(R.drawable.spoon_icon, "We have added a product you might like."),
            NavigationDrawerItem(R.drawable.heart_icon,"One of your favorite is on promotion."),
            NavigationDrawerItem(R.drawable.cart_icon,"Your order has been delivered"),
            NavigationDrawerItem(R.drawable.onbording_icon3,"The delivery is on his way"),
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.notification_icon),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            }
            Text(
                "Notificatons",
                fontSize = 24.sp,
                color = colorResource(R.color.yellow_2)
            )

        }
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color(0xffffd8c7))
        )
        Spacer(
            modifier = Modifier
                .height(10.dp)
                .fillMaxWidth()
        )

        for(i in noficationItems) {
            Column {
                NavigationItem(i,18)
                Spacer(
                    modifier = Modifier
                        .padding(top = 14.dp)
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(Color(0xffffd8c7))
                )
            }
        }
    }
}
@Composable
fun ProfileNavigationDrawer(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clip(
                RoundedCornerShape(topStart = 100.dp, bottomStart = 100.dp)
            )
            .background(color = colorResource(R.color.orange_base))
            .padding(25.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ){
        Column(
            modifier = Modifier.padding(start = 16.dp)
        ){
            Text("Bathri Narayanan", fontSize = 24.sp, color = colorResource(R.color.font2))
            Text("pathrinarayananmdu@gmail.com", fontSize = 16.sp, color = colorResource(R.color.yellow_2))
        }
        val profileItems  = listOf(
            NavigationDrawerItem(R.drawable.cart_icon, "My Orders"),
            NavigationDrawerItem(R.drawable.profile_icon,"My Profile"),
            NavigationDrawerItem(R.drawable.location_icon,"Delivery Address"),
            NavigationDrawerItem(R.drawable.onboarding_icon2,"Payment Methods"),
            NavigationDrawerItem(R.drawable.call_icon,"Contact us"),
            NavigationDrawerItem(R.drawable.chat_icon,"Help & FAQs"),
            NavigationDrawerItem(R.drawable.settings_icon,"Settings")
        )


        for(i in profileItems) {
            Column {
                NavigationItem(i,24)
                Spacer(
                    modifier = Modifier
                        .padding(top = 14.dp)
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(Color(0xffffd8c7))
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        NavigationItem(NavigationDrawerItem(R.drawable.log_out_icon,"Log Out"),24)
        Spacer(modifier = Modifier.height(20.dp))
    }
}


@Composable
fun MainPage(navController: NavController, viewmodel: MainViewmodel) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 5 })
    val coroutineScope = rememberCoroutineScope() // ✅ Remember a coroutine scope

    Scaffold(
        bottomBar = {
            BottomBar { index ->
                coroutineScope.launch {
                    pagerState.animateScrollToPage(index) // ✅ Smooth scrolling
                }
            }
        }
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()) {
            HorizontalPager(
                modifier = Modifier.wrapContentSize(),
                state = pagerState
            ) { page ->
                when (page) {
                    0 -> HomeCV(viewmodel,navController)
                    1 -> BestSellersPage(viewmodel)
                    2 -> FavoritesPage()
                    3 -> MyOrders()
                    4 -> HelpCenter()
                }
            }
        }
    }
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }
            .collect { page ->
                when (page) {
                    0 -> navController.navigate("home")
                    1 -> navController.navigate("bestSellers")
                    2 -> navController.navigate("favorites")
                    3 -> navController.navigate("myOrders")
                    4 -> navController.navigate("help")
                }
            }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeCV (viewmodel: MainViewmodel, navController: NavController){
    var profileVisible by remember { mutableStateOf(false) }
    var isProfile by remember { mutableStateOf(false) }
    var notifyVisible by remember { mutableStateOf(false) }
    var isNotify by remember { mutableStateOf(false) }
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val sheetWidth = screenWidth / 2
    val offsetX = remember { Animatable(sheetWidth.value) }
    BottomSheetScaffold  (
        scaffoldState = bottomSheetScaffoldState,
        content = {
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .background(
                        color = colorResource(R.color.yellow_base)
                    )
                    .padding(bottom = 20.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 35.dp)
                        .padding(top = 30.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .height(30.dp)
                            .width(200.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .background(Color.White)
                    ) {
                        Row(
                            modifier = Modifier.matchParentSize(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                "Search",
                                modifier = Modifier.padding(start = 12.dp)
                            )
                            Spacer(modifier =Modifier.weight(1f))
                            Box(
                                modifier = Modifier
                                    .padding(end = 5.dp)
                                    .size(20.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(color = colorResource(R.color.orange_base)),
                                contentAlignment = Alignment.Center
                            ){
                                Image(painter = painterResource(R.drawable.filter_icon), contentDescription = null)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Box(
                        modifier = Modifier
                            .size(26.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White), contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.cart_icon),
                            contentDescription = null,
                            modifier = Modifier.clickable (
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ){

                            }
                        )
                    }

                    Box(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .size(26.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) {
                                notifyVisible = true
                                isNotify = true
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.notify_icon),
                            contentDescription = null
                        )
                    }
                    Box(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .size(26.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) {
                                profileVisible = true;isProfile = true
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.profile_icon),
                            contentDescription = null
                        )
                    }

                }
                Text(
                    "Good Morning",
                    fontSize = 30.sp,
                    color = colorResource(R.color.font2),
                    fontWeight = FontWeight.W700,
                    modifier = Modifier
                        .padding(horizontal = 35.dp)
                        .padding(top = 16.dp)
                )
                Text(
                    "Rise and Shine, It's Breakfast time",
                    fontSize = 13.sp,
                    color = colorResource(R.color.orange_base),
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(horizontal = 35.dp)
                )




            }
        },
    sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(R.color.yellow_base))
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(Color.White)
                    .verticalScroll(rememberScrollState())
                ,
            ) {
                Column(
                    modifier = Modifier.padding(top = 35.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 35.dp, end = 35.dp)
                    ) {
                        FoodItems(R.drawable.snacks_icon, "Snacks")
                        FoodItems(R.drawable.meals_icon, "Meals")
                        FoodItems(R.drawable.vegan_icon, "Vegan")
                        FoodItems(R.drawable.desserts_icon, "Desserts")
                        FoodItems(R.drawable.drinks_icon, "Drinks")
                    }
                    Spacer(
                        modifier = Modifier
                            .padding(top = 15.dp)
                            .height(1.dp)
                            .fillMaxWidth()
                            .background(Color(0xffffd8c7))
                    )
                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(15.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(start = 35.dp, end = 35.dp)
                    ) {
                        Text(
                            "Best Sellers",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W600,
                            color = colorResource(R.color.font_brown)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                            modifier = Modifier.clickable (
                                indication =  null, 
                                interactionSource = remember { MutableInteractionSource() }
                            ){
                                navController.navigate("bestSellers")
                            }
                        ) {
                            Text(
                                "View All",
                                fontWeight = FontWeight.SemiBold,
                                color = colorResource(R.color.orange_base)
                            )
                            Icon(
                                Icons.Filled.KeyboardArrowRight,
                                contentDescription = null,
                                tint = colorResource(R.color.orange_base)
                            )
                        }

                    }
                    Row(
                        modifier = Modifier
                            .padding(top = 14.dp)
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        val bestSellers =viewmodel.homeData.value?.data?.restaurant?.menu?.best_sellers?.take(4)
                        val baseUrl = viewmodel.homeData.value?.base_image_url
                        val bestSellersSize = bestSellers?.size ?:0
                        bestSellers?.forEachIndexed {index, it->
                            Box(
                                modifier = Modifier
                                    .padding(
                                        start = if (index == 0) 35.dp else 0.dp,
                                        end = if (index == bestSellersSize - 1) 35.dp else 0.dp
                                    )
                                    .height(108.dp)
                                    .width(108.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .clickable {
                                        val gson = Gson()
                                        val data =gson.toJson(it)
                                        val encodedData = URLEncoder.encode(data, StandardCharsets.UTF_8.toString())
                                        navController.navigate("details/${encodedData}")
                                    },
                                contentAlignment = Alignment.BottomEnd
                            ) {
                                Image(
                                    rememberAsyncImagePainter(baseUrl + it?.image_url),
                                    contentDescription = null,
                                    modifier = Modifier.matchParentSize(),
                                    contentScale = ContentScale.FillBounds
                                )
                                Box(
                                    modifier = Modifier
                                        .padding(bottom = 12.dp)
                                        .width(40.dp)
                                        .height(20.dp)
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(color = colorResource(R.color.orange_base))
                                        .padding(horizontal = 4.dp)
                                        .padding(bottom = 4.dp),
                                    contentAlignment = Alignment.Center

                                ) {
                                    Text(
                                        "₹ ${it?.price}",
                                        color = colorResource(R.color.white),
                                        fontSize = 10.sp,
                                        modifier =Modifier.fillMaxSize(),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }

                    CarouselSection(viewmodel)
                    Text(
                        "Recommended",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W600,
                        color = colorResource(R.color.font_brown),
                        modifier = Modifier.padding(top = 16.dp, start = 35.dp, end = 35.dp)
                    )
                    LazyVerticalGrid(
                        modifier = Modifier
                            .padding(horizontal = 35.dp)
                            .fillMaxWidth()
                            .height(320.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        columns = GridCells.Fixed(2)
                    ) {
                        val recommened =
                            viewmodel.homeData.value?.data?.restaurant?.menu?.recommended
                        val baseUrl = viewmodel.homeData.value?.base_image_url
                        recommened?.drop(4)?.forEach {
                            item {
                                Box(
                                    modifier = Modifier
                                        .padding(top = 16.dp)
                                        .height(140.dp)
                                        .width(160.dp)
                                        .clip(RoundedCornerShape(12.dp)),
                                    contentAlignment = Alignment.BottomEnd
                                ) {
                                    Image(
                                        painter = rememberAsyncImagePainter(baseUrl + it.image_url),
                                        contentDescription = null,
                                        modifier = Modifier.matchParentSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                    Box(
                                        contentAlignment = Alignment.TopCenter,
                                        modifier = Modifier
                                            .padding(bottom = 12.dp)
                                            .width(40.dp)
                                            .height(16.dp)
                                            .clip(RoundedCornerShape(12.dp))
                                            .background(colorResource(R.color.orange_base))
                                    ) {
                                        Text(
                                            "₹ ${it.price}",
                                            color = colorResource(R.color.white),
                                            fontSize = 10.sp,
                                            textAlign = TextAlign.Center,
                                            modifier = Modifier.fillMaxSize()
                                        )
                                    }

                                }

                            }
                        }
                    }

                }
            }

    },
        sheetPeekHeight = 670.dp,
        sheetDragHandle = null,
        sheetContentColor = colorResource(R.color.yellow_base),
        containerColor = colorResource(R.color.yellow_base),
        contentColor = colorResource(R.color.yellow_base),
        sheetContainerColor = colorResource(R.color.yellow_base)
        )
    AnimatedVisibility(
        modifier = Modifier.fillMaxSize(),
        visible = (profileVisible && isProfile)  || (isNotify && notifyVisible),
        enter = slideInHorizontally(initialOffsetX = { it }) + fadeIn(),
        exit = slideOutHorizontally(targetOffsetX = { it }) + fadeOut()
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(sheetWidth)
                .offset { IntOffset(offsetX.value.roundToInt(), 0) }
                .background(Color.Transparent)
                .pointerInput(Unit) {
                    detectHorizontalDragGestures(
                        onDragEnd = {
                            if (offsetX.value > sheetWidth.value * 0.5f) {
                                notifyVisible = false
                                isNotify = false
                                profileVisible = false
                                isProfile = false
                            } else {
                                viewmodel.viewModelScope.launch {

                                    offsetX.animateTo(0f)
                                }
                            }
                        },
                        onHorizontalDrag = { change, dragAmount ->
                            change.consume()
                            viewmodel.viewModelScope.launch {
                                offsetX.snapTo(
                                    (offsetX.value + dragAmount).coerceIn(
                                        0f,
                                        sheetWidth.value
                                    )
                                )
                            }
                        }
                    )
                }
        ) {
            if(isNotify)
                 NotificationNavigationDrawer()
            if(isProfile)
                ProfileNavigationDrawer()
            }
    }
    }



@Composable
fun CarouselSection(viewmodel: MainViewmodel) {

    val data = viewmodel.homeData.value?.data?.restaurant?.menu?.advertise
    val baseUrl = viewmodel.homeData.value?.base_image_url
    val pagerState = rememberPagerState(initialPage = 0, pageCount = {maxOf(1,data?.size  ?:0)})
    LaunchedEffect(data) {

            if (data?.isEmpty()?.not() == true) {
                while(isActive) {
                val nextPage = (pagerState.currentPage + 1) % (data?.size ?: 1)
                pagerState.animateScrollToPage(nextPage)
                delay(1500)
            }
        }

    }

    Column(modifier = Modifier.fillMaxWidth()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        ) { page ->
            Row(
                modifier = Modifier
                    .padding(top = 20.dp, start = 35.dp, end = 35.dp)
                    .height(120.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = colorResource(R.color.orange_base))
            ) {
                Column(
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(start = 16.dp, top = 16.dp),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        data?.get(page)?.tagline ?:"",
                        color = Color.White,
                        fontSize = 12.sp
                    )
                    Text(
                        data?.get(page)?.offer ?:"",
                        color = Color.White,
                        fontSize = 20.sp,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Box(
                    modifier = Modifier.weight(0.5f)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(baseUrl + data?.get(page)?.image_url),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
        }

    }
}

@Composable
fun FoodItems(@DrawableRes img :Int, name :String){
    Column (
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier
                .wrapContentSize()
                .clip(RoundedCornerShape(30.dp))
                .background(color = colorResource(R.color.yellow_2))
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(img),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
        }
        Text(
            name,
            color = colorResource(R.color.font_brown),
            fontSize = 12.sp
        )
    }
}

@Composable
fun HomeSplashScreen(navController: NavController, viewmodel: MainViewmodel) {
    LaunchedEffect(viewmodel.homeData.value) {
        if(viewmodel.homeData.value!=null) {
            navController.navigate("home"){
                popUpTo("splash"){inclusive= true}
            }
        }

    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {

            Image(painter = painterResource(R.drawable.soru_time), contentDescription = "Logo",
                modifier = Modifier.size(450.dp),
                contentScale = ContentScale.FillBounds)
        }
    }

