package ShippingUpdate

class DelayedShippingUpdate(val parsible: MutableList<String>) : ShippingUpdate {
    override fun getUpdate(): Pair<String, MutableList<String>> {
        return Pair("statusUpdate",mutableListOf("Delayed", "Delayed at ${parsible[2]}"))
    }
}