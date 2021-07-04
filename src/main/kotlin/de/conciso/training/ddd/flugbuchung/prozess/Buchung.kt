package de.conciso.training.ddd.flugbuchung.prozess

import de.conciso.training.ddd.KundenId
import de.conciso.training.ddd.base.AggregateRoot
import de.conciso.training.ddd.base.ValueObject
import de.conciso.training.ddd.flugbuchung.inventar.Flugnummer
import de.conciso.training.ddd.flugbuchung.inventar.Platznummer
import java.util.*

class Buchung(
    buchungsnummer: Buchungsnummer,
    val kundenId: KundenId,
    val flugnummer: Flugnummer,
    val sitzplatz: Platznummer
) : AggregateRoot<Buchungsnummer>(buchungsnummer)

data class Buchungsnummer(private val wert: UUID) : ValueObject