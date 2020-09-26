package hilfling.backend.hilfling.repository

import hilfling.backend.hilfling.model.*
import me.liuwj.ktorm.database.Database
import me.liuwj.ktorm.dsl.eq
import me.liuwj.ktorm.entity.add
import me.liuwj.ktorm.entity.find
import me.liuwj.ktorm.entity.toList
import org.springframework.beans.factory.annotation.Autowired

class EventOwnerRepository {
    @Autowired
    lateinit var database: Database

    fun findById(id: Int): EventOwner? {
        return database.event_owners.find { it.id eq id }
    }

    fun findAll(): List<EventOwner> {
        return database.event_owners.toList()
    }

    fun create(name: String): EventOwner {
        val eventOwner = EventOwner{
            this.name = name
        }
        database.event_owners.add(eventOwner)
        return eventOwner
    }
}