package hilfling.backend.hilfling.repository

import hilfling.backend.hilfling.model.*
import me.liuwj.ktorm.database.Database
import me.liuwj.ktorm.dsl.eq
import me.liuwj.ktorm.entity.add
import me.liuwj.ktorm.entity.find
import me.liuwj.ktorm.entity.toList
import org.springframework.beans.factory.annotation.Autowired

class GangRepository {
    @Autowired
    lateinit var database: Database

    fun findById(id: Int): Gang? {
        return database.gangs.find { it.id eq id }
    }

    fun findAll(): List<Gang> {
        return database.gangs.toList()
    }

    fun create(name: String): Gang {
        val gang = Gang{
            this.name = name
        }
        database.gangs.add(gang)
        return gang
    }
}