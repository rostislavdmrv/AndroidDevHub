package bg.tu_varna.sit.pregovor_lab7

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import bg.tu_varna.sit.pregovor_lab7.data.Constant
import bg.tu_varna.sit.pregovor_lab7.data.Contact
import bg.tu_varna.sit.pregovor_lab7.ui.theme.Pregovor_lab7Theme

class DisplayActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val name = intent.getStringExtra(Constant.EXTRA_NAME)
//        val email = intent.getStringExtra(Constant.EXTRA_EMAIL)
//        val phone = intent.getStringExtra(Constant.EXTRA_PHONE)

        val contact = intent.getParcelableExtra(Constant.EXTRA_CONSTANT,Contact::class.java)

        enableEdgeToEdge()
        setContent {
            Pregovor_lab7Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting3(
                        name = contact!!.name,
                        email = contact.email,
                        phone = contact.phone,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String,email:String,phone:String, modifier: Modifier = Modifier) {

    Column (
        modifier = modifier.fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Hello $name!",
            fontSize = 50.sp,
            lineHeight = 50.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = modifier
        )
        Text(
            text = "Your email is $email",
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

    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    Pregovor_lab7Theme {
        Greeting3("Android","email@email.com","4845112558")
    }
}