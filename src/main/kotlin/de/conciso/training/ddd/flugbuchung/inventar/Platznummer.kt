package de.conciso.training.ddd.flugbuchung.inventar

import de.conciso.training.ddd.base.ValueObject

data class Platznummer(val reihe: Reihe, val gang: Gang) : ValueObject

data class Reihe(val wert: Int) {

    init {
        if (wert <= 0) throw IllegalArgumentException("Nur positive Reihennummern erlaubt.")
    }

}

enum class Gang { A, B, C, D, E, F }
