package ShippingUpdate

class ShippedShippingUpdate(val parsible: MutableList<String>) : ShippingUpdate {
    override fun getUpdate(): Pair<String, MutableList<String>> {
       return Pair("statusUpdate",mutableListOf("Shipped", "Shipped at ${parsible[3]}"))
    }
}