package de.conciso.training.ddd.flugbuchung.prozess

import de.conciso.training.ddd.base.DomainEvent

interface BuchungDomainEvent : DomainEvent {
    fun accept(listener: BuchungListener)
}