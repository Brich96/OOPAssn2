package ShippingUpdate

class CanceledShippingUpdate(val parsible: MutableList<String>) : ShippingUpdate {
    override fun getUpdate(): Pair<String, MutableList<String>> {
        return Pair("statusUpdate",mutableListOf("Canceled", "Canceled at ${parsible[2]}"))
    }
}