package de.conciso.training.ddd.flugbuchung.prozess

import de.conciso.training.ddd.KundenId

data class BuchungDurchgeführt(val kundenId: KundenId, val buchungsnummer: Buchungsnummer) : BuchungDomainEvent {

    override fun accept(listener: BuchungListener) {
        listener.visit(this)
    }

}