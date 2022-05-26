import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ShipmentTest {

    val shipment = Shipment(listOf("created","s10000","1652712855468"))

//    @BeforeEach
//    fun setUp() {
//        val shipment = Shipment(listOf("created","s10000","1652712855468"))
//    }

    @Test
    fun addUpdate() {
        val factory = ShippingUpdateFactory()
        val update = factory.getFactoryItem(mutableListOf("shipped","s10000","1652712855468","1652713940874"))
        if (update != null) {
            shipment.addUpdate(update)
        }

        assertEquals(2,shipment.updateHistory.size)
    }
}