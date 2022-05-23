import ShippingUpdate.ShippingUpdate
import java.security.Timestamp
import java.util.*

class Shipment(private val parsible: List<String>) {
    var id: String
    var status: String
    var notes: MutableList<String>
    var updateHistory: MutableList<String>
    var expectedDeliveryDateTimestamp: Long?
    var currentLocation: String?

    init {
        id = parsible[1]
        status = "Created"
        notes = mutableListOf()
        updateHistory = mutableListOf("${parsible[2]} - Created")
        expectedDeliveryDateTimestamp = null
        currentLocation = null
    }
    fun addUpdate(update: ShippingUpdate) {
        val updatePair = update.getUpdate()
        // Pair Status UPdate and array of function and data
    }

    private fun statusUpdate(status: String) {

    }

}