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
        // Pair Status Update and array of function and data
        if(updatePair.first == "statusUpdate") {
            statusUpdate(updatePair.second)
        } else if (updatePair.first == "noteUpdate") {
            noteUpdate(updatePair.second)
        } else {
//            Incorrect status update
        }
    }

    private fun noteUpdate(status: MutableList<String>) {
        this.status = status[0]
        notes.add(status[1])
    }

    private fun statusUpdate(status: MutableList<String>) {
        this.status = status[0]
        updateHistory.add(status[1])
    }

}