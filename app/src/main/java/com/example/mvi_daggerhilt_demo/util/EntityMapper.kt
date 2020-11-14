package com.example.mvi_daggerhilt_demo.util

interface EntityMapper<Entity, DomainModel> {
    fun mapFromEntity(entity: Entity): DomainModel

    fun mapToEntity(domainModel: DomainModel):Entity
}