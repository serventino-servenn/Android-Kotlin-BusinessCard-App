package com.serventino.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.serventino.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainApp()
                }
            }
        }
    }
}

@Composable
fun MainApp(modifier: Modifier = Modifier){
    Column(
        modifier = modifier
    ) {
        Column(modifier = Modifier
            .weight(1f)
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(R.drawable.serventino),
                contentDescription = "null",
                modifier = Modifier
                    .size(170.dp)
                    .clip(CircleShape)
                    .border(
                        BorderStroke(4.dp,Color(0xFF3ddc84)),
                        CircleShape
                    )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Serventino Ndong Etom",
                fontSize = 25.sp,
                fontWeight = FontWeight.Thin
            )
            Text(
                text = "Software developer",
                fontWeight = FontWeight.Normal,
                color = Color(0xFF3ddc84)
            )
        }
        Column(
            modifier = Modifier
                .weight(0.5f)
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
           Column(
               modifier = Modifier
                   .fillMaxWidth(.8f)
                   .fillMaxHeight(.8f)
                   .shadow(
                       elevation = 1.dp
                   ),
               verticalArrangement = Arrangement.Center,
               horizontalAlignment = Alignment.CenterHorizontally

           ) {
               ContactInfo(
                   image = Icons.Default.Share,
                   description = "share",
                   content = "@androidDev"
               )
               ContactInfo(
                   image = Icons.Default.Call,
                   description = "phone",
                   content = "+ 11 (213) 444 444"
               )
               ContactInfo(
                   image = Icons.Default.Email,
                   description = "email",
                   content = "serventinoetom@gmail.com"
               )

           }
        }

    }
}

@Composable
private fun ContactInfo(
    modifier: Modifier = Modifier,
    image:ImageVector,
    description:String,
    content:String
){
    Row(modifier = modifier) {
        Icon(
            imageVector = image,
            contentDescription = description
        )
        Spacer(modifier = Modifier.width(25.dp).height(30.dp))
        Text(
            text = content,
            color = Color(0xFF3ddc84),
            fontWeight = FontWeight.Light,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        MainApp()
    }
}