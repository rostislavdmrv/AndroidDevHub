package com.example.pmiu_prep2

import android.content.Intent
import android.os.Bundle
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
import com.example.pmiu_prep2.data.Constant
import com.example.pmiu_prep2.ui.theme.Pmiuprep2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pmiuprep2Theme {
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
    var nameError by remember { mutableStateOf(false) }

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
            lineHeight = 68.sp,
            textAlign = TextAlign.Center,



        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = name,
            onValueChange = { name = it},
            placeholder = {
                Text(stringResource(R.string.how_is_your_name))
            },
            label = {
                Text(stringResource(R.string.enter_name))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            singleLine = true
        )
        if (nameError) {
            Text(
                text = stringResource(R.string.error_data),
                color = Color.Red,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (name.length >= 3) {
                intent.putExtra(Constant.EXTRA_NAME, name)
                context.startActivity(intent)
            } else {
                nameError = true
            }

        }) {
            Text(stringResource(R.string.next))

        }

    }
}

@Preview(showBackground = true)
@Composable

fun MainComposePreview() {
    Pmiuprep2Theme {
        MainCompose()
    }
}