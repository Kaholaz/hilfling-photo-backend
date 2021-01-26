package no.fg.hilflingbackend.repository

import me.liuwj.ktorm.database.Database
import me.liuwj.ktorm.dsl.QueryRowSet
import me.liuwj.ktorm.dsl.delete
import me.liuwj.ktorm.dsl.eq
import me.liuwj.ktorm.entity.*
import no.fg.hilflingbackend.dto.MotiveDto
import no.fg.hilflingbackend.dto.MotiveId
import no.fg.hilflingbackend.dto.Page
import no.fg.hilflingbackend.dto.toEntity
import no.fg.hilflingbackend.model.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.UUID
import javax.persistence.EntityNotFoundException

@Repository
open class MotiveRepository(val database: Database) : IRepository<Motive, MotiveDto> {

  override fun findById(id: UUID): MotiveDto? {
    return database.motives.find { it.id eq id }?.toDto()
  }

  override fun findAll(offset: Int, limit: Int): Page<MotiveDto> {
    val motives = database.motives.drop(offset).take(limit).toList().map { it.toDto() }
    return Page(
      offset,
      limit,
      1,
      currentList = motives
    )
  }

  override fun create(dto: MotiveDto): Int = database.motives.add(dto.toEntity())

  override fun patch(dto: MotiveDto): Int = database.motives.update(dto.toEntity())

  override fun delete(id: UUID): Int = database.delete(Motives) { it.id eq id }

  fun create(
    title: String,
    categoryId: UUID,
    eventOwnerId: UUID,
    albumId: UUID
  ): Int {
    val category = database.categories.find { it.id eq categoryId } ?: throw Error()
    val eventOwner = database.event_owners.find { it.id eq eventOwnerId } ?: throw Error()
    val album = database.albums.find { it.id eq albumId } ?: throw Error()

    val motive = Motive{
      this.title = title
      this.category = category
      this.eventOwner = eventOwner
      this.album = album
    }
    return database.motives.add(motive)
  }
}
/*
open class MotiveRepository {
  @Autowired
  open lateinit var database: Database

  fun findById(id: UUID): Motive? {
    return database.motives.find { it.id eq id }
  }

  fun findAll(): List<Motive> {
    return database.motives.toList()
  }

  fun create(
    motive: Motive
  ): Int = database.motives.add(motive)
}
*/
