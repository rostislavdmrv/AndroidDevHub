package bg.tu_varna.sit.kontrolno2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
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
import bg.tu_varna.sit.kontrolno2.data.Constant
import bg.tu_varna.sit.kontrolno2.data.Content
import bg.tu_varna.sit.kontrolno2.ui.theme.Kontrolno2Theme

class DisplayActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val name = intent.getStringExtra(Constant.EXTRA_NAME)
        val contact = intent.getParcelableExtra(Constant.EXTRA_CONSTANT, Content::class.java)

        enableEdgeToEdge()
        setContent {
            Kontrolno2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = name!!,
                        email = contact!!.email,
                        phone = contact.phone,
                        webAddress = contact.webAddress,

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
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Твойте данни са :",
            fontSize = 15.sp,
            lineHeight = 30.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = modifier
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = modifier.fillMaxSize().paddingFromBaseline(0.dp)
                .background(Color.DarkGray)
                .padding(horizontal = 16.dp, vertical = 16.dp),
                    verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Gray)) {
                        append("Име: ")
                    }
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append(name)
                    }
                },
                fontSize = 20.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Center,
                modifier = modifier
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Gray)) {
                        append("Телефон: ")
                    }
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append(phone)
                    }
                },
                fontSize = 20.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Center,
                modifier = modifier
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Gray)) {
                        append("Имейл: ")
                    }
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append(email)
                    }
                },
                fontSize = 20.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Center,
                modifier = modifier
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Gray)) {
                        append("Уеб адрес: ")
                    }
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append(webAddress)
                    }
                },
                fontSize = 20.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Center,
                modifier = modifier
            )

        }


    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    Kontrolno2Theme {
        Greeting("Иван","ddjn@mail.com","021056156","dodi.dod")
    }
}