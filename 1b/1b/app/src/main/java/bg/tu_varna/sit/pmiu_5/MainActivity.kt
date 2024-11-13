package bg.tu_varna.sit.pmiu_5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bg.tu_varna.sit.pmiu_5.ui.theme.PMIU_5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PMIU_5Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        message = stringResource(R.string.message),
                        from = stringResource(R.string.form),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(message: String,from:String, modifier: Modifier = Modifier) {
    Column(modifier = modifier.background(Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            color = Color.Magenta,
            textAlign = TextAlign.Center,
            modifier = modifier
        )
        Text(
            text = from,
            fontSize = 36.sp,
            color = Color.Yellow,
            modifier = modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PMIU_5Theme {
        Greeting(
            message = stringResource(R.string.message),
            from = stringResource(R.string.form)
        )
    }
}