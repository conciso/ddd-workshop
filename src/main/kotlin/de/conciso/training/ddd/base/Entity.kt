package de.conciso.training.ddd.base

abstract class Entity<ID>(override val id: ID): IdentifiableDomainObject<ID> {

    /*
    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other::class != this::class) return false
        return this.id == (other as Entity<ID>).id
    }

    override fun hashCode() = id.hashCode()
    */
}