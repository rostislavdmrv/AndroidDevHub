package bg.tu_varna.sit.pmiu_lab6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.contentColorFor
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import bg.tu_varna.sit.pmiu_lab6.ui.theme.PMIuLab6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PMIuLab6Theme {
    NextActivity()
                }
            }
        }
    }


@Preview(showSystemUi = true)
@Composable
fun NextActivity()
{
    var context = LocalContext.current
    var intent = Intent(context, SecondActivity2::class.java)
    var intentSend= Intent(Intent.ACTION_SEND)
    intentSend.type= "text/plane"
    intentSend.putExtra(Intent.EXTRA_EMAIL, arrayOf("s21621513@onlineedu.tu-varna.bg"))
    intentSend.putExtra(Intent.EXTRA_SUBJECT ,"This is a subject")
    intentSend.putExtra(Intent.EXTRA_TEXT ,"This is a text")
    Column(Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
        {
  Button(onClick = {
      context.startActivity(intent)
  })
  {
      Text(stringResource(R.string.next))
  }
            Button(onClick =  {
    context.startActivity(intentSend)
                })
            {
                Text(stringResource(R.string.send))
            }
}
}


@Composable
@Preview(showSystemUi = true)
fun TextFieldCompos(modifier: Modifier = Modifier)
{
    var text by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }
    Column (
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = text,
            modifier= modifier)
        TextField(
            value= text,
            onValueChange = {text = it },
            label ={ Text(stringResource(R.string.enter)) },
            modifier= modifier.fillMaxSize().padding(16.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                autoCorrect = true
            ),
            textStyle = TextStyle(
                    color= Color.Blue
        ),
            placeholder = { Text( stringResource(R.string.enter)) },
            maxLines = 1,
            minLines = 1,
            singleLine= true
        )

        TextField(
            value= email,
            onValueChange = {email = it },
            label ={ Text(stringResource(R.string.enter)) },
            modifier= modifier.fillMaxSize().padding(16.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                autoCorrect = true
            ),
            textStyle = TextStyle(
                color= Color.Blue
            ),
            placeholder = { Text( stringResource(R.string.enter)) },
            maxLines = 1,
            minLines = 1,
            singleLine= true
        )

        TextField(
            value= number,
            onValueChange = {number = it },
            label ={ Text(stringResource(R.string.enter)) },
            modifier= modifier.fillMaxSize().padding(16.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                autoCorrect = true
            ),
            textStyle = TextStyle(
                color= Color.Blue
            ),
            placeholder = { Text( stringResource(R.string.enter)) },
            maxLines = 1,
            minLines = 1,
            singleLine= true
        )
    }
}


