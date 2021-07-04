package de.conciso.training.ddd

import de.conciso.training.ddd.base.AggregateRoot
import de.conciso.training.ddd.base.ValueObject
import java.util.*

class Kunde(var kundenId: KundenId): AggregateRoot<KundenId>(kundenId) {
}

data class KundenId(private val wert: UUID): ValueObject {

}
