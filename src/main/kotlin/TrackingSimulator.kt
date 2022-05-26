import kotlinx.coroutines.*
import java.io.File

class TrackingSimulator {
    var shipments: MutableList<Shipment> = mutableListOf()

    fun findShipment(id: String): Shipment? {
        return shipments.find { it.id == id }
    }

    fun addShipment(shipment: Shipment) {
        shipments.add(shipment)
    }

    fun runSimulation() {
        File("src/main/kotlin/test.txt").forEachLine {
            val array = it.split(",").toMutableList()
            if(array[0] == "created") {
                shipments.add(Shipment(array))
            } else {
                val factory = ShippingUpdateFactory()
                val update = factory.getFactoryItem(array)
                if (update != null) {
                    findShipment(array[1])?.addUpdate(update)
                }
            }
        }
    }
}
