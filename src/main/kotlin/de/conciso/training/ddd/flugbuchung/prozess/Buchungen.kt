package de.conciso.training.ddd.flugbuchung.prozess

class Buchungen {

    private val byId = mutableMapOf<Buchungsnummer, Buchung>()

    fun save(buchung: Buchung) {
        byId[buchung.id] = buchung
    }

}
