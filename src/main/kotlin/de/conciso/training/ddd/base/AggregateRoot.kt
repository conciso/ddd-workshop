package de.conciso.training.ddd.base

abstract class AggregateRoot<ID>(override val id: ID): Entity<ID>(id) {
}