// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    val simulator: TrackingSimulator = TrackingSimulator()
    simulator.runSimulation()
    var trackingTextState by remember { mutableStateOf("") }
    @Composable
    fun ShippingInfoCard(viewHelper: TrackerViewHelper) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .clickable{ },
            elevation = 10.dp
        ) {
            Column {
                Text(viewHelper.shipmentID)
            }
        }
    }

    MaterialTheme {
        val viewHelpers = remember { mutableStateListOf<TrackerViewHelper>() }
        Column {
            Row {
                TextField(trackingTextState, { newValue ->
                    trackingTextState = newValue
                })
                Button(onClick = {
                    // Button on click event here
                    if(trackingTextState != "") {
                        val shipment = simulator.findShipment(trackingTextState)
                        println(simulator.shipments)
                        println(shipment)
                        if(shipment != null) {
                            viewHelpers.add(TrackerViewHelper(shipment))
                        }
                    }
                }) {
                    Text("Track")
                }
            }
            LazyColumn {
                items(viewHelpers) { viewHelper ->
                    ShippingInfoCard(viewHelper)
                }
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
