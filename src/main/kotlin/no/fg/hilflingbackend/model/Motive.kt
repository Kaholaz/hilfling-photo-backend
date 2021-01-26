package no.fg.hilflingbackend.model

import me.liuwj.ktorm.database.Database
import me.liuwj.ktorm.entity.Entity
import me.liuwj.ktorm.entity.sequenceOf
import me.liuwj.ktorm.schema.uuid
import me.liuwj.ktorm.schema.varchar
import no.fg.hilflingbackend.dto.MotiveDto

interface Motive : BaseModel<Motive> {
  companion object : Entity.Factory<Motive>()

  var title: String

  // Foreign keys
  var category: Category
  var eventOwner: EventOwner
  var album: Album
}

fun Motive.toDto() = MotiveDto(
  title = this.title,
  category = this.category,
  eventOwner = this.eventOwner,
  album = this.album
)

object Motives : BaseTable<Motive>("motive") {
  val title = varchar("title").bindTo { it.title }

  // Foreign keys
  val categoryId = uuid("category_id").references(Categories) { it.category }
  val eventOwnerId = uuid("event_owner_id").references(EventOwners) { it.eventOwner }
  val albumId = uuid("album_id").references(Albums) { it.album }
}

val Database.motives get() = this.sequenceOf(Motives)
