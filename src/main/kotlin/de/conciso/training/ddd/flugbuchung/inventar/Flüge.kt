package de.conciso.training.ddd.flugbuchung.inventar

class Flüge {

    private val nachFlugnummer = mutableMapOf<Flugnummer, Flug>()

    fun save(flug: Flug) {
        nachFlugnummer[flug.id] = flug
    }

    fun load(flugnummer: Flugnummer) = nachFlugnummer[flugnummer]
}