package bg.tu_varna.sit.pmiu_5v2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import bg.tu_varna.sit.pmiu_5v2.ui.theme.PMIU_5V2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PMIU_5V2Theme {
                DiceRollerApp()
            }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp(){
    DiceWithImagesAndButton(modifier=Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}
@Composable
fun DiceWithImagesAndButton(modifier: Modifier=Modifier){
    var result  by remember { mutableIntStateOf(1) }

    val image = when(result){
        1->R.drawable.dice_1
        2->R.drawable.dice_2
        3->R.drawable.dice_3
        4->R.drawable.dice_4
        5->R.drawable.dice_5
        else ->R.drawable.dice_6
    }
    Column(modifier=modifier,
        horizontalAlignment =Alignment.CenterHorizontally )
    {
        Image(
            painter = painterResource(image),
            contentDescription = "1"
        )
        Button(onClick = {(1..6).random()}) {
            Text(text = stringResource(R.string.roll),
                fontSize = 24.sp)
        }

    }
}