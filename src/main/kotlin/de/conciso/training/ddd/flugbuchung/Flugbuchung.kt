@file:Suppress("NonAsciiCharacters")

package de.conciso.training.ddd.flugbuchung

import de.conciso.training.ddd.KundenId
import de.conciso.training.ddd.base.EventBus
import de.conciso.training.ddd.flugbuchung.inventar.*
import de.conciso.training.ddd.flugbuchung.prozess.*
import java.util.*

// Application Service
class Flugbuchung(val flüge: Flüge, val buchungsanfragen: Buchungsanfragen, val buchungen: Buchungen, val sitzplatzZuweisung: SitzplatzZuweisung, val eventBus: EventBus) {


    fun stelleBuchungsanfrageFürFlug(kundenummer: UUID, flug: String): BuchungsanfrageId {
        val kundenId = KundenId(kundenummer)
        val flugnummer = Flugnummer(flug)
        val buchungsanfrage = Buchungsanfrage(kundenId, flugnummer)
        buchungsanfragen.save(buchungsanfrage)
        return buchungsanfrage.id
    }

    fun ergaenzeSitzplatzwunschZurBuchungsanfrage(buchungsanfrageId: UUID, gewünschteKlasse: String): Platznummer? {

        val anfrageId = BuchungsanfrageId(buchungsanfrageId)
        val buchungsanfrage = buchungsanfragen.load(anfrageId) ?: throw IllegalArgumentException("Buchungsanfrage mit Id $buchungsanfrageId unbekannt")

        val flugnummer = buchungsanfrage.flugnummer
        val flug = flüge.load(flugnummer) ?: throw IllegalArgumentException("Flug mit Flugnummer $flugnummer unbekannt")

        val klasse: Klasse = Klasse.valueOf(gewünschteKlasse)

        val platznummer = sitzplatzZuweisung.weisePlatzZu(flug, klasse, buchungsanfrage)

        flüge.save(flug)
        buchungsanfragen.save(buchungsanfrage)
        return platznummer
    }

    fun führeBuchungDurch(buchungsanfrageId: UUID) {
        val anfrageId = BuchungsanfrageId(buchungsanfrageId)
        val buchungsanfrage = buchungsanfragen.load(anfrageId) ?: throw IllegalArgumentException("Buchungsanfrage mit Id $buchungsanfrageId unbekannt")

        val buchung = buchungsanfrage.führeBuchungDurch(eventBus)

        buchungsanfragen.delete(anfrageId)
        buchungen.save(buchung)
    }

}