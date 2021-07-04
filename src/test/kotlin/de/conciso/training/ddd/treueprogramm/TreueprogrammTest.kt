package de.conciso.training.ddd.treueprogramm

import de.conciso.training.ddd.KundenId
import de.conciso.training.ddd.base.EventBus
import de.conciso.training.ddd.flugbuchung.prozess.BuchungDurchgeführt
import de.conciso.training.ddd.flugbuchung.prozess.Buchungsnummer
import org.junit.jupiter.api.Test
import java.util.*

internal class TreueprogrammTest {

    @Test
    fun test() {

        val treueprogramm = Treueprogramm(Abonnenten())
        val eventBus = EventBus()
        eventBus.register(treueprogramm)
        eventBus.publish(BuchungDurchgeführt(KundenId(UUID.randomUUID()), Buchungsnummer(UUID.randomUUID())))
    }

}