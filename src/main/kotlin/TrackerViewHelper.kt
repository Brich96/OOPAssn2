class TrackerViewHelper(shipment: Shipment) {

    var shipmentID: String = shipment.id
    var shipmentNotes: MutableList<String> = shipment.notes
    var shipmentUpateHistory: MutableList<String> = shipment.updateHistory
    var expectedShipmentDeliveryDate: Long? = shipment.expectedDeliveryDateTimestamp
    var shipmentStatus: String = shipment.status
    var shipmentLocation: String? = shipment.currentLocation

    fun trackShipment(id: String) {
        // TODO: implement
    }

    fun stopTracking() {

    }


}