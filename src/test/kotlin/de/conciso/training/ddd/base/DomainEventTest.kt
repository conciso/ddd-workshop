package de.conciso.training.ddd.base

import nl.jqno.equalsverifier.EqualsVerifier
import org.junit.jupiter.api.Test
import org.reflections.Reflections

class DomainEventTest {

    @Test
    fun testEqualHashcode() {
        val domainEventClasses = Reflections("de.conciso.training").getSubTypesOf(DomainEvent::class.java)
        EqualsVerifier.forClasses(domainEventClasses).verify()
    }

}
