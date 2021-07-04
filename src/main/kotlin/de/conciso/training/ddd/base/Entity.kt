package de.conciso.training.ddd.base

abstract class Entity<ID>(override val id: ID): IdentifiableDomainObject<ID>