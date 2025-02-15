package com.example.fooddelivery.Home

import android.provider.ContactsContract.CommonDataKinds.Im
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.Home.model.NavigationDrawerItem
import com.example.fooddelivery.R
import com.example.fooddelivery.authentication.ui.BottomBar


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
                Text("$20.00", color = colorResource(R.color.orange_base), fontWeight = FontWeight.W600)
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
fun OrderConfirmItem(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White)
            .padding(top =10.dp)

    ){
        Image(
            painter = painterResource(R.drawable.strawberry),
            contentDescription = null,
            modifier = Modifier .padding(top = 16.dp, bottom = 16.dp).size(80.dp, 100.dp)
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
                Text("$20.00", color = colorResource(R.color.orange_base), fontWeight = FontWeight.W600)
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

@Preview
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
                    modifier = Modifier.height(35.dp).fillMaxWidth().clip(RoundedCornerShape(12.dp)).background(colorResource(R.color.yellow_2)),
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
@Composable
fun BestSellersPage(){
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
                    modifier = Modifier.padding(top = 35.dp, start = 35.dp, end = 35.dp)
                ) {
                    Text(
                        "Discover our most popular dishes!",
                        color = colorResource(R.color.orange_base),
                        fontWeight = FontWeight.W600,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    LazyVerticalGrid(
                        modifier = Modifier.padding(vertical =20.dp,),
                        verticalArrangement = Arrangement.spacedBy(15.dp),
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        columns = GridCells.Fixed(2),
                    ) {
                        items(10) {
                            BestSellersItem()
                        }
                    }
                }



            }
        }
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
fun BestSellersItem(){
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
            Box(modifier = Modifier.matchParentSize(), contentAlignment = Alignment.BottomEnd) {
                Box(
                    modifier = Modifier
                        .padding(bottom = 12.dp)
                        .width(40.dp)
                        .height(16.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(color = colorResource(R.color.orange_base)),
                    contentAlignment = Alignment.Center

                ) {
                    Text(
                        "$103.0",
                        color = colorResource(R.color.white),
                        fontSize = 10.sp
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
                "Chicken Burger",
                fontSize = 16.sp,
                color = colorResource(R.color.orange_base),
                textAlign = TextAlign.Center,

                )
            Box(
                modifier = Modifier
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.padding( start = 10.dp, top = 5.dp)
        ) {
            Text(
                "Lorem ipsum dolor sit amet, consectetur.",
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
            .padding(35.dp),
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
            .padding(35.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp),
    ){
        Column{
            Text("Bathri Narayanan", fontSize = 33.sp, color = colorResource(R.color.font2))
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
        Box(modifier = Modifier.padding(top =4.dp))
        NavigationItem(NavigationDrawerItem(R.drawable.log_out_icon,"Log Out"),24)
    }
}


@Composable
fun HomeCV (){
    Scaffold (
        topBar = {
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
                    //SEARCH BOX
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
                            contentDescription = null
                        )
                    }
                    Box(
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .size(26.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.notify_icon),
                            contentDescription = null
                        )
                    }
                    Box(
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .size(26.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White),
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
                    .verticalScroll(rememberScrollState())
                ,
            ) {
                Column(
                    modifier = Modifier.padding(top = 35.dp, start = 35.dp, end = 35.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                        verticalAlignment = Alignment.CenterVertically
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
                            horizontalArrangement = Arrangement.spacedBy(5.dp)
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
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        for (i in 1..4)
                            Box(
                                modifier = Modifier
                                    .height(108.dp)
                                    .width(70.dp),
                                contentAlignment = Alignment.BottomEnd
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.cake),
                                    contentDescription = null,
                                    modifier = Modifier.matchParentSize()
                                )
                                Box(
                                    modifier = Modifier
                                        .padding(bottom = 12.dp)
                                        .width(40.dp)
                                        .height(16.dp)
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(color = colorResource(R.color.orange_base)),
                                    contentAlignment = Alignment.Center

                                ) {
                                    Text(
                                        "$103.0",
                                        color = colorResource(R.color.white),
                                        fontSize = 10.sp
                                    )
                                }
                            }
                    }

                    Row(
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .height(120.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(20.dp))
                            .background(color = colorResource(R.color.orange_base))
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(0.5f)
                                .padding(start = 16.dp, top = 20.dp),
                            verticalArrangement = Arrangement.Center,
                        ) {
                            Text(
                                "Experience our delicious new dish",
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp
                            )
                            Text(
                                "30% OFF",
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 32.sp
                            )
                        }
                        Box(
                            modifier = Modifier.weight(0.5f)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.pizza),
                                contentDescription = null,
                                contentScale = ContentScale.FillBounds
                            )
                        }
                    }
                    Text(
                        "Recommend",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W600,
                        color = colorResource(R.color.font_brown),
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        val imgs = listOf(R.drawable.burger, R.drawable.dish)
                        for (img in imgs)
                            Box(
                                modifier = Modifier
                                    .padding(top = 16.dp)
                                    .height(140.dp)
                                    .width(160.dp),
                                contentAlignment = Alignment.BottomEnd
                            ) {
                                Image(
                                    painter = painterResource(img),
                                    contentDescription = null,
                                    modifier = Modifier.matchParentSize(),
                                    contentScale = ContentScale.FillBounds
                                )
                                Box(
                                    modifier = Modifier
                                        .padding(bottom = 12.dp)
                                        .width(40.dp)
                                        .height(16.dp)
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(color = colorResource(R.color.orange_base)),
                                    contentAlignment = Alignment.Center

                                ) {
                                    Text(
                                        "$103.0",
                                        color = colorResource(R.color.white),
                                        fontSize = 10.sp
                                    )
                                }
                            }
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