package com.example.fooddelivery.onboarding.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.R


@Composable
fun CarousalContainer(index : Int){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        for(i in 0..2) {
            Box(
                modifier = Modifier
                    .height(4.dp)
                    .width(20.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        color =
                        if(i == index)
                             colorResource(R.color.orange_base)
                        else
                            colorResource(R.color.yellow_2)
                    )
            )
        }
    }
}


@Composable
fun OnBoard(
   @DrawableRes backgroundImage :Int,
   @DrawableRes Icon :Int,
   title :String,
   index: Int,
   ctaText : String,
   goNextPage : ()-> Unit
){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ){
        Image(
            painter = painterResource(backgroundImage),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .clip(
                    RoundedCornerShape(20.dp)
                )
                .background(Color.White),
            contentAlignment = Alignment.TopCenter
        ){
            Column (
                modifier = Modifier
                    .padding(top = 23.dp)
                    .padding(horizontal = 60.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ){
                Image(
                    painter = painterResource(Icon),
                    contentDescription = null,
                    modifier = Modifier.size(35.dp)
                )
                Text(
                    title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.orange_base)
                )
                Text(
                    "Lorem ipsum dolor sit amet, conse ctetur  adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna.",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(R.color.font_brown)
                )
                CarousalContainer(index)
                Button(
                    onClick ={
                        goNextPage()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.orange_base)),
                    modifier = Modifier.width(130.dp)
                ) {
                    Text(ctaText)
                }
            }
        }
    }
}
@Preview
@Composable
fun OnBoardingPage(){
    val pages = 3
    var currentIndex by remember { mutableStateOf(0) }
    val bgs = listOf( R.drawable.onboarding1,R.drawable.onboarding2_bg, R.drawable.onboarding3_bg)
    val icons = listOf(R.drawable.onboarding1_icon,R.drawable.onboarding_icon2, R.drawable.onbording_icon3)

    val titles = listOf(
        "Order for Food",
        "Easy Payment",
        "Fast Delivery"
    )
     val ctaTexts = listOf(
        "Next",
        "Next",
        "Get Started"
    )


        OnBoard(
            bgs[currentIndex],
            icons[currentIndex],
            titles[currentIndex],
            currentIndex,
            ctaTexts[currentIndex],
            goNextPage = {
                if( currentIndex <pages-1)
                    currentIndex+=1
            }
        )

}

