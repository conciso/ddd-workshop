@file:Suppress("NonAsciiCharacters")

package de.conciso.training.ddd.flugbuchung.inventar

import de.conciso.training.ddd.base.AggregateRoot

class Flug constructor(flugnummer: Flugnummer, private val sitzplätze: Set<Sitzplatz>) :
    AggregateRoot<Flugnummer>(flugnummer) {

    fun reserviere(klasse: Klasse): Platznummer? {
        return sitzplätze
            .filter { it.klasse == klasse }
            .filter { it.istFrei() }
            .firstOrNull()?.let { platz ->
                platz.reserviere()
                platz.platznummer
            }
    }

}