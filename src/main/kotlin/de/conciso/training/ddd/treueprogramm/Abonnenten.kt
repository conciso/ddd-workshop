package de.conciso.training.ddd.treueprogramm

import de.conciso.training.ddd.KundenId

class Abonnenten {

    private val nachAbonnentId = mutableMapOf<AbonnentId, Abonnent>()

    fun save(abonnent: Abonnent) {
        nachAbonnentId[abonnent.id] = abonnent
    }

    fun load(abonnentId: AbonnentId) = nachAbonnentId[abonnentId]

    fun loadByKundenId(kundenId: KundenId) =
        nachAbonnentId.values.filter { it.kundenId == kundenId }.firstOrNull()
}