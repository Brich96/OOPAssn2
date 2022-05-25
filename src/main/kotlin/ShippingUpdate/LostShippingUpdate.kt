package ShippingUpdate

class LostShippingUpdate(val parsible: MutableList<String>) : ShippingUpdate {
    override fun getUpdate(): Pair<String, MutableList<String>> {
        return Pair("statusUpdate",mutableListOf("Lost in Transit", "Lost at ${parsible[2]}"))
    }
}