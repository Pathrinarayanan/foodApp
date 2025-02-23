package com.example.fooddelivery.authentication.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.R


@Preview
@Composable
fun Login() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.yellow_base)),
    ) {
        Row (
            modifier = Modifier.fillMaxWidth().padding(start = 30.dp, top = 50.dp),
            horizontalArrangement = Arrangement.spacedBy(40.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                Icons.Filled.KeyboardArrowLeft,
                contentDescription = null
            )
            Text(
                "Log In",
                fontSize = 30.sp,
                color = colorResource(R.color.font2),
                fontWeight = FontWeight.W600,

                )
        }

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(650.dp)
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White),
            contentAlignment = Alignment.TopCenter
        ) {
            Column (
                modifier = Modifier.padding(  35.dp)
            ){
                Text(
                    "Welcome",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W600,
                    color = colorResource(R.color.font_brown)
                )
                Text(
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    color = Color(0xff252525),
                    modifier = Modifier.padding(top =20.dp)
                )
                Text(
                    "Enter mobile Number",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600,
                    color = colorResource(R.color.font_brown),
                    modifier = Modifier.padding(top =40.dp)
                )
                Box(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                        .height(50.dp)
                        .clip(RoundedCornerShape(13.dp))
                        .background(color = colorResource(R.color.yellow_2))

                )
                Text(
                    "Password",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600,
                    color = colorResource(R.color.font_brown),
                    modifier = Modifier.padding(top =40.dp)
                )
                Box(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                        .height(50.dp)
                        .clip(RoundedCornerShape(13.dp))
                        .background(color = colorResource(R.color.yellow_2))

                )
                Text(
                    "Forget Password",
                    modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(top =10.dp),
                    textAlign = TextAlign.End,
                    color = colorResource(R.color.orange_base)
                )
                Box (modifier  = Modifier.fillMaxWidth().padding(top =40.dp), contentAlignment = Alignment.Center){
                    Button(
                        onClick = {
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.orange_base)),
                        modifier = Modifier.width(130.dp)
                    ) {
                        Text("Login")
                    }
                }
                Row (modifier  = Modifier.fillMaxWidth().padding(top =20.dp),
                    horizontalArrangement = Arrangement.Center,
                    ){
                    Text(
                        "Don’t have an account?",
                        color = colorResource(R.color.font_brown)
                    )
                     Text(
                        "Sign Up",
                         color =  colorResource(R.color.orange_base),
                         modifier = Modifier.padding(start = 10.dp)
                    )

                }

            }

        }
        Box(
            modifier = Modifier.wrapContentHeight().fillMaxWidth().background(Color.White)
        ) {
            BottomBar()

        }


    }
}

@Composable
fun BottomBar(onBottomIconClick : ((Int)->Unit)?= null){
    val icons = listOf(
        R.drawable.bottom1,
        R.drawable.bottom2,
        R.drawable.bottom3,
        R.drawable.bottom4,
        R.drawable.bottom5,
    )
    Row(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(topEnd = 50.dp, topStart = 50.dp))
            .background(colorResource(R.color.orange_base)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        for(i in icons.indices) {
            Icon(
                painter = painterResource(icons[i]),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.clickable (
                    indication =  null,
                    interactionSource = remember { MutableInteractionSource() }
                ){
                    onBottomIconClick?.invoke(i)
                }
            )
        }
    }
}