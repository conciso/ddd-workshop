package de.conciso.training.ddd.base

import de.conciso.training.ddd.flugbuchung.prozess.BuchungDomainEvent
import de.conciso.training.ddd.flugbuchung.prozess.BuchungListener

class EventBus {

    private val listener = mutableListOf<BuchungListener>()

    fun register(listener: BuchungListener) {
        this.listener.add(listener)
    }

    fun publish(event: BuchungDomainEvent) {
        listener.forEach { event.accept(it) }
    }

}
