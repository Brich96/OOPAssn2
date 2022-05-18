// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    var trackingTextState by remember { mutableStateOf("") }
    @Composable
    fun ShippingInfoCard() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .clickable{ },
            elevation = 10.dp
        ) {
            Column {
                Text(text)
            }
        }
    }

    MaterialTheme {
        Column {
            Row {
                TextField(trackingTextState, { newValue ->
                    trackingTextState = newValue
                })
                Button(onClick = {
                    // Button on click event here
                }) {
                    Text("Track")
                }
            }
            ShippingInfoCard()
        }

//        Column {
//            Button(onClick = {
//                text = "Hello, Desktop!"
//            }) {
//                Text(text)
//            }
//            Button(onClick = {
//                text2 = "Hello, Button2!"
//            }) {
//                Text(text2)
//            }
//        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
