package ShippingUpdate

class NoteAddedShippingUpdate(val parsible: MutableList<String>): ShippingUpdate {
    override fun getUpdate(): Pair<String, MutableList<String>> {
        return Pair("noteUpdate", mutableListOf("In Transit", parsible[3]))
    }
}