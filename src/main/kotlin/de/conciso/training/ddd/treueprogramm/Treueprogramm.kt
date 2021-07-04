package de.conciso.training.ddd.treueprogramm

import de.conciso.training.ddd.flugbuchung.prozess.BuchungDurchgeführt
import de.conciso.training.ddd.flugbuchung.prozess.BuchungDomainEvent
import de.conciso.training.ddd.flugbuchung.prozess.BuchungListener

// Application Service
class Treueprogramm(val abonnenten: Abonnenten) : BuchungListener {

    override fun visit(event: BuchungDurchgeführt) {
        abonnenten.loadByKundenId(event.kundenId)
            ?.gewähreTreuepunkte()
    }

    fun visit(event: BuchungDomainEvent) {
        // nicht relevantes Event
    }

}