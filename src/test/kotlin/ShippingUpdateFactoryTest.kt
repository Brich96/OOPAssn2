import ShippingUpdate.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ShippingUpdateFactoryTest {

    @Test
    fun getFactoryItemReturnsShippedShippingUpdate() {
        val factory = ShippingUpdateFactory()
        val item = factory.getFactoryItem(mutableListOf("shipped","s10000","1652712855468","1652713940874"))
        assertTrue(item is ShippedShippingUpdate)
    }

    @Test
    fun getFactoryItemReturnsLocationShippingUpdate() {
        val factory = ShippingUpdateFactory()
        val item = factory.getFactoryItem(mutableListOf("location","s10000","1652712855468","Los Angeles CA"))
        assertTrue(item is LocationShippingUpdate)
    }

    @Test
    fun getFactoryItemReturnsDelayedUpdate() {
        val factory = ShippingUpdateFactory()
        val item = factory.getFactoryItem(mutableListOf("delayed","s10000","1652712855468","1652718051403"))
        assertTrue(item is DelayedShippingUpdate)
    }

    @Test
    fun getFactoryItemReturnsNoteAddedShippingUpdate() {
        val factory = ShippingUpdateFactory()
        val item = factory.getFactoryItem(mutableListOf("noteadded","s10000","1652712855468","package was damaged slightly during shipping"))
        assertTrue(item is NoteAddedShippingUpdate)
    }

    @Test
    fun getFactoryItemReturnsLostShippingUpdate() {
        val factory = ShippingUpdateFactory()
        val item = factory.getFactoryItem(mutableListOf("lost","s10000","1652712855468"))
        assertTrue(item is LostShippingUpdate)
    }

    @Test
    fun getFactoryItemReturnsCanceledShippingUpdate() {
        val factory = ShippingUpdateFactory()
        val item = factory.getFactoryItem(mutableListOf("canceled","s10003","1652712855468"))
        assertTrue(item is CanceledShippingUpdate)
    }

    @Test
    fun getFactoryItemReturnsDeliveredShippingUpdate() {
        val factory = ShippingUpdateFactory()
        val item = factory.getFactoryItem(mutableListOf("delivered","s10006","1652712855468"))
        assertTrue(item is DeliveredShippingUpdate)
    }
}