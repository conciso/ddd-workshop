package de.conciso.training.ddd.flugbuchung.inventar

import de.conciso.training.ddd.base.ValueObject

enum class Klasse(val nächstHöhere: Klasse?): ValueObject {
    FIRST(null),
    BUSINESS(FIRST),
    ECONOMY(BUSINESS);
}