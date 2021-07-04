package de.conciso.training.ddd.base

import nl.jqno.equalsverifier.EqualsVerifier
import org.junit.jupiter.api.Test
import org.reflections.Reflections

class ValueObjectTest {

    @Test
    fun testEqualHashcode() {
        val valueObjectClasses = Reflections("de.conciso.training").getSubTypesOf(ValueObject::class.java)
        EqualsVerifier.forClasses(valueObjectClasses).verify()
    }

}
