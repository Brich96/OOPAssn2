package ShippingUpdate

class LocationShippingUpdate(val parsible: MutableList<String>) : ShippingUpdate {
    override fun getUpdate(): Pair<String, MutableList<String>> {
        return Pair("statusUpdate",mutableListOf("In Transit", "Arrived in ${parsible[2]} at ${parsible[3]}"))
    }
}