package ShippingUpdate

class DeliveredShippingUpdate(val parsible: MutableList<String>) : ShippingUpdate {
    override fun getUpdate(): Pair<String, MutableList<String>> {
        return Pair("statusUpdate",mutableListOf("Delivered", "Delivered at ${parsible[2]}"))
    }
}