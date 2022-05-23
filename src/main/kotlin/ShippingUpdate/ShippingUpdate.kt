package ShippingUpdate

interface ShippingUpdate {
    fun getUpdate(): Pair<String, MutableList<String>>
}