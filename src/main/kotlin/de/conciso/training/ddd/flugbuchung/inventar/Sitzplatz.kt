package de.conciso.training.ddd.flugbuchung.inventar

import de.conciso.training.ddd.base.Entity

class Sitzplatz constructor(val platznummer: Platznummer, val klasse: Klasse) : Entity<Platznummer>(platznummer) {

    private var reserviert = false

    fun reserviere(): Boolean {
        if (reserviert) return false
        reserviert = true
        return true
    }

    fun istFrei() = !reserviert

}
