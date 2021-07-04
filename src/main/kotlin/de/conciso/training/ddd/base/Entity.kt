package de.conciso.training.ddd.base

abstract class Entity<ID>(override val id: ID): IdentifiableDomainObject<ID> {

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other.javaClass != this.javaClass) return false
        return this.id == this::class.java.cast(other).id
    }

    override fun hashCode() = id.hashCode()

}