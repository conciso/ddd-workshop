package de.conciso.training.ddd.base

import nl.jqno.equalsverifier.EqualsVerifier
import nl.jqno.equalsverifier.Warning
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.reflections.Reflections
import java.lang.reflect.Modifier

class IdentifiableDomainObjectTest {

    @Test
    fun testEqualHashcode() {
        val identifiableDomainObjects = Reflections("de.conciso.training")
                .getSubTypesOf(IdentifiableDomainObject::class.java)
                .filter { !(it.isInterface || Modifier.isAbstract(it.modifiers)) }
        assertThat(identifiableDomainObjects).allSatisfy {
            EqualsVerifier.forClass(it).withOnlyTheseFields("id").verify()
        }
    }

}
