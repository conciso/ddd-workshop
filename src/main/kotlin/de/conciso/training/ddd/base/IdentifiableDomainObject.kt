package de.conciso.training.ddd.base

interface IdentifiableDomainObject<ID>: DomainObject {
    val id: ID
}