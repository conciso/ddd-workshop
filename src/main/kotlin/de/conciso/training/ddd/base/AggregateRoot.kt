package de.conciso.training.ddd.base

abstract class AggregateRoot<ID>(id: ID): Entity<ID>(id)