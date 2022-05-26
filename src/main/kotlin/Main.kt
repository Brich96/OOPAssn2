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
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@Composable
@Preview
fun App(simulator: TrackingSimulator) {
    var trackingTextState by remember { mutableStateOf("") }
    val viewHelpers = remember { mutableStateListOf<TrackerViewHelper>() }
    simulator.runSimulation()
//    rememberCoroutineScope().launch { simulator.runSimulation() }
    @Composable
    fun ShippingInfoCard(viewHelper: TrackerViewHelper) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .clickable{
                         viewHelpers.remove(viewHelper)
                },
            elevation = 10.dp
        ) {
            Column {
                Text(" Tracking shipment: " + viewHelper.shipmentID)
                Text("Status: " + viewHelper.shipmentStatus)
                Text("Location: " + viewHelper.shipmentLocation)
                Text("Expected Delivery: "  + viewHelper.expectedShipmentDeliveryDate)
                Text("")
                Text("Status Updates: ")
                viewHelper.shipmentUpateHistory.forEach {
                    Text(it)
                }

                Text("Notes: ")
                viewHelper.shipmentNotes.forEach {
                    Text(it)
                }
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
                    if(trackingTextState != "") {
                        val shipment = simulator.findShipment(trackingTextState)
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
    val simulator: TrackingSimulator = TrackingSimulator()

    Window(onCloseRequest = ::exitApplication) {
        App(simulator)
//        runBlocking {
//            launch {
//                simulator.runSimulation()
//            }
//        }
    }
}
