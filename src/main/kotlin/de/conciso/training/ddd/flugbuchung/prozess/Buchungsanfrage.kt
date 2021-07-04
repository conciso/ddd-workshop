@file:Suppress("NonAsciiCharacters")

package de.conciso.training.ddd.flugbuchung.prozess

import de.conciso.training.ddd.KundenId
import de.conciso.training.ddd.base.AggregateRoot
import de.conciso.training.ddd.base.EventBus
import de.conciso.training.ddd.base.ValueObject
import de.conciso.training.ddd.flugbuchung.inventar.Flugnummer
import de.conciso.training.ddd.flugbuchung.inventar.Platznummer
import java.lang.IllegalStateException
import java.util.*

class Buchungsanfrage(private val kunde: KundenId, internal val flugnummer: Flugnummer) :
    AggregateRoot<BuchungsanfrageId>(BuchungsanfrageId(UUID.randomUUID())) {

    private var sitzplatzWunsch: Platznummer? = null

    fun ergänzeSitzplatzwunsch(sitzplatzWunsch: Platznummer) {
        this.sitzplatzWunsch = sitzplatzWunsch
    }

    fun führeBuchungDurch(eventBus: EventBus): Buchung {
        val sitzplatz = sitzplatzWunsch ?: throw IllegalStateException("Es wurde noch kein Sitzplatz ausgewählt")
        val buchung = Buchung(Buchungsnummer(UUID.randomUUID()), kunde, flugnummer, sitzplatz)
        eventBus.publish(BuchungDurchgeführt(kunde, buchung.id))
        return buchung
    }

}

data class BuchungsanfrageId(private val wert: UUID) : ValueObject