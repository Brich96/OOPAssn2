import ShippingUpdate.*

class ShippingUpdateFactory {
    private val shipments: MutableList<Shipment> = mutableListOf()

    fun getFactoryItem(parsible: MutableList<String>): ShippingUpdate? {
//        var id: String, var status: String, var notes: MutableList<String>, var expectedDeliveryDateTimestamp: Long, var currentLocation: String
        if(parsible[0] == "shipped") {
            return ShippedShippingUpdate(parsible)
        } else if(parsible[0] == "location") {
            return LocationShippingUpdate(parsible)
        } else if(parsible[0] == "delayed") {
            return DelayedShippingUpdate(parsible)
        } else if(parsible[0] == "noteadded") {
            return NoteAddedShippingUpdate(parsible)
        } else if(parsible[0] == "lost") {
            return LostShippingUpdate(parsible)
        } else if(parsible[0] == "canceled") {
            return CanceledShippingUpdate(parsible)
        } else if(parsible[0] == "delivered") {
            return DeliveredShippingUpdate(parsible)
        } else {
            return null
        }
    }

    fun findShipment(id: String): Shipment? {
        return shipments.find { it.id == id }
    }
}