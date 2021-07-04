@file:Suppress("NonAsciiCharacters")

package de.conciso.training.ddd.treueprogramm

import de.conciso.training.ddd.KundenId
import de.conciso.training.ddd.base.AggregateRoot
import de.conciso.training.ddd.base.ValueObject
import java.util.*

class Abonnent(abonnentId: AbonnentId, val kundenId: KundenId) : AggregateRoot<AbonnentId>(abonnentId) {

    private var treuepunkte: Int = 0

    fun gewähreTreuepunkte() {
        treuepunkte += 100
    }

}

data class AbonnentId(private val wert: UUID) : ValueObject
