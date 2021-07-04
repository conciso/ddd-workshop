package de.conciso.training.ddd.flugbuchung.prozess

interface BuchungListener {
    fun visit(event: BuchungDurchgeführt)
}