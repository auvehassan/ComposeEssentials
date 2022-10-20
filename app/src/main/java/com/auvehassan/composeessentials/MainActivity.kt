package com.auvehassan.composeessentials

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.auvehassan.composeessentials.ui.theme.ComposeEssentialsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting(Message("TestAuthor", "TestBody"))
//            Text(text = "Hello android")
//            ComposeEssentialsTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    Greeting("Android")
//                }
//            }
        }
    }
}

data class Message(val author: String, val body: String)

//To make a function composable, add the @Composable annotation
@Composable
fun Greeting(message: Message) {
    Column {//The Column function lets you arrange elements vertically.
        Text(text = message.author)
        Text(text = message.body)

        Row {//Row to arrange items horizontally
            Text(text = message.author)
            Text(text = message.body)
        }
    }
}

//The @Preview annotation lets you preview your composable functions
@Preview
@Composable
fun DefaultPreview() {
    ComposeEssentialsTheme {
        Greeting(Message("Android Author", "Test Body"))
    }

}

