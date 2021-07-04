package de.conciso.training.ddd.flugbuchung.prozess

import de.conciso.training.ddd.flugbuchung.inventar.Flug
import de.conciso.training.ddd.flugbuchung.inventar.Klasse
import de.conciso.training.ddd.flugbuchung.inventar.Platznummer

class SitzplatzZuweisung {

    fun weisePlatzZu(flug: Flug, gewünschteKlasse: Klasse, buchungsanfrage: Buchungsanfrage) : Platznummer? {
        var klasse: Klasse? = gewünschteKlasse
        var platznummer: Platznummer? = null
        while (platznummer == null && klasse != null ) {
            platznummer = flug.reserviere(gewünschteKlasse)
            klasse = klasse.nächstHöhere
        }
        if (platznummer != null) {
            buchungsanfrage.ergänzeSitzplatzwunsch(platznummer)
        }
        return platznummer
    }

}
