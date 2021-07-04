package de.conciso.training.ddd.flugbuchung.prozess

class Buchungsanfragen {

    private val byId = mutableMapOf<BuchungsanfrageId, Buchungsanfrage>()

    fun save(buchungsanfrage: Buchungsanfrage) {
        byId[buchungsanfrage.id] = buchungsanfrage
    }

    fun load(buchungsanfrageId: BuchungsanfrageId) = byId[buchungsanfrageId]

    fun delete(buchungsanfrageId: BuchungsanfrageId) {
        byId.remove(buchungsanfrageId)
    }

}
