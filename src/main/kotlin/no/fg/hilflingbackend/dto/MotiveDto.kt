package no.fg.hilflingbackend.dto

import no.fg.hilflingbackend.model.Album
import no.fg.hilflingbackend.model.Category
import no.fg.hilflingbackend.model.EventOwner
import no.fg.hilflingbackend.model.Motive
import java.util.*

data class MotiveDto (
  val motiveId: MotiveId = MotiveId(),
  val title: String,

  // Foreign keys
  val category: Category,
  val eventOwner: EventOwner,
  val album: Album
)

data class MotiveId(
  override val id: UUID = UUID.randomUUID()
) : UuidId {
  override fun toString(): String = id.toString()
}

fun MotiveDto.toEntity(): Motive {
  val dto = this
  return Motive {
    id = dto.motiveId.id
    title = dto.title
    category = dto.category
    eventOwner = dto.eventOwner
    album = dto.album
  }
}
