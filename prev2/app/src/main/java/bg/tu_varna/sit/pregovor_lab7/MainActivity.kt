package bg.tu_varna.sit.pregovor_lab7

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
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
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import bg.tu_varna.sit.pregovor_lab7.data.Constant
import bg.tu_varna.sit.pregovor_lab7.ui.theme.Pregovor_lab7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pregovor_lab7Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainCompose(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainCompose( modifier: Modifier = Modifier) {

    var context = LocalContext.current
    var intent = Intent(context,InsertActivity::class.java)
    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
        text = stringResource(R.string.app_name),
        modifier = modifier
        )
        TextField(
            value = name,
            onValueChange = { name = it},
            placeholder = {
                Text(stringResource(R.string.enter_name))
            },
            label = {
                Text(stringResource(R.string.enter_name))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            singleLine = true
        )
        Button(onClick = {
            intent.putExtra(Constant.EXTRA_NAME,name)
            context.startActivity(intent)

        }) {
            Text(stringResource(R.string.next))

        }

    }

}

@Preview(showBackground = true)
@Composable
fun MainComposePreview() {
    Pregovor_lab7Theme {
        MainCompose()
    }
}