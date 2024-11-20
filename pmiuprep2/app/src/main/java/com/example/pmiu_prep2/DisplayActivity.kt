package com.example.pmiu_prep2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmiu_prep2.data.Constant
import com.example.pmiu_prep2.data.Contact
import com.example.pmiu_prep2.ui.theme.Pmiuprep2Theme

class DisplayActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name = intent.getStringExtra(Constant.EXTRA_NAME)
        val contact = intent.getParcelableExtra(Constant.EXTRA_CONSTANT, Contact::class.java)
        enableEdgeToEdge()
        setContent {
            Pmiuprep2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        email = contact!!.email,
                        phone = contact.phone,
                        webAddress = contact.webAddress,
                        name = name!!,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name:String,email: String,phone:String,webAddress:String, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = stringResource(R.string.dobro_utro),
            modifier = Modifier.padding(top = 100.dp),
            color = Color.Yellow,
            fontSize = 68.sp,
            lineHeight = 68.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = name,
            modifier = modifier,
            color = Color.Yellow,
            fontSize = 68.sp,
            lineHeight = 68.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "your data is :",
            fontSize = 20.sp,
            lineHeight = 80.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = modifier
        )
        Column(
            modifier = modifier
                .background(Color.Black)
                .padding(horizontal = 32.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Blue)) {
                        append("name ")
                    }
                    withStyle(style = SpanStyle(color = Color.Red)) {
                        append(name)
                    }
                },
                fontSize = 30.sp,
                lineHeight = 50.sp,
                color = Color.Green,
                textAlign = TextAlign.Center,
                modifier = modifier
            )
            Text(
                text = "email $email",
                fontSize = 30.sp,
                lineHeight = 50.sp,
                color = Color.Green,
                textAlign = TextAlign.Center,
                modifier = modifier
            )
            Text(
                text = "Your  phone is $phone",
                fontSize = 50.sp,
                lineHeight = 50.sp,
                color = Color.Red,
                textAlign = TextAlign.Center,
                modifier = modifier
            )
            Text(
                text = "WEB ADDRESS $webAddress",
                fontSize = 50.sp,
                lineHeight = 50.sp,
                color = Color.Red,
                textAlign = TextAlign.Center,
                modifier = modifier
            )
        }


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Pmiuprep2Theme {
        Greeting("IVAN","smsm@gmail.com","059222","email.dod")
    }
}