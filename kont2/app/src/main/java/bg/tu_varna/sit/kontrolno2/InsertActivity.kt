package bg.tu_varna.sit.kontrolno2

import android.content.Intent
import android.location.Address
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bg.tu_varna.sit.kontrolno2.data.Constant
import bg.tu_varna.sit.kontrolno2.data.Content
import bg.tu_varna.sit.kontrolno2.ui.theme.Kontrolno2Theme

class InsertActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name = intent.getStringExtra(Constant.EXTRA_NAME)
        enableEdgeToEdge()
        setContent {
            Kontrolno2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    InsertCompose(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun InsertCompose(name: String, modifier: Modifier = Modifier) {
    var context = LocalContext.current
    var intent = Intent(context,DisplayActivity::class.java)

    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var webAddress by remember { mutableStateOf("") }

    var isValidEmail by remember { mutableStateOf(true) }
    var isValidPhone by remember { mutableStateOf(true) }
    var isValidWebAddress by remember { mutableStateOf(true) }



    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.dobro_utro),
            modifier = Modifier.padding(top = 100.dp),
            color = Color.Yellow,
            fontSize = 68.sp,
            textAlign = TextAlign.Center,

            )
        Text(
            text = name,
            modifier = modifier,
            color = Color.Yellow,
            fontSize = 68.sp,
            lineHeight = 68.sp,
            textAlign = TextAlign.Center
        )

        if(!(isValidEmail && isValidPhone && isValidWebAddress))(
                Text(
                    text = stringResource(R.string.error_mess),
                    color = Color.Red,
                    modifier = modifier
                )

        )

        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = email,
            onValueChange = { email = it},
            placeholder = {
                Text(stringResource(R.string.how_is_your_email),
                    color = Color.Red)
            },
            label = {
                Text(stringResource(R.string.enter_email))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            singleLine = true,
            isError = !isValidEmail
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = phone,
            onValueChange = { phone = it},
            placeholder = {
                Text(stringResource(R.string.how_is_your_phone),
                    color = Color.Red)
            },
            label = {
                Text(stringResource(R.string.enter_phone))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            singleLine = true,
            isError = !isValidPhone
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = webAddress,
            onValueChange = { webAddress = it},
            placeholder = {
                Text(stringResource(R.string.how_is_your_web_address),
                    color = Color.Red)
            },
            label = {
                Text(stringResource(R.string.enter_webAddress))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            singleLine = true,
            isError = !isValidWebAddress
        )



        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {

            isValidPhone = Patterns.EMAIL_ADDRESS.matcher(email).matches()
            isValidPhone = Patterns.PHONE.matcher(phone).matches()
            isValidWebAddress = Patterns.WEB_URL.matcher(webAddress).matches()


            if(isValidEmail && isValidPhone && isValidWebAddress){

                val contact = Content(email,phone,webAddress)
                intent.putExtra(Constant.EXTRA_CONSTANT,contact)
                context.startActivity(intent)

            }


        }) {
            Text(stringResource(R.string.next))

        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Kontrolno2Theme {
        InsertCompose("Иван")
    }
}