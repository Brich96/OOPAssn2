import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TrackingSimulatorTest {

    @Test
    fun testAddAndFindShipmentWorkCorrectly() {
        val shipment = Shipment(listOf("created","s10000","1652712855468"))
        val simulator = TrackingSimulator()
        simulator.addShipment(shipment)
        val foundShipment = simulator.findShipment("s10000")

        assertEquals(shipment, foundShipment)
    }

//    @Test
//    fun runSimulation() {
//        val simulator = TrackingSimulator()
//
//        simulator.runSimulation()
//    }
}