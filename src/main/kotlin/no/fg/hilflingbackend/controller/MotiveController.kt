package no.fg.hilflingbackend.controller

import no.fg.hilflingbackend.dto.MotiveDto
import no.fg.hilflingbackend.model.Motive
import no.fg.hilflingbackend.repository.MotiveRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/motives")
open class MotiveController(override val repository: MotiveRepository) : BaseController<Motive, MotiveDto>(repository) {

  @PostMapping(params = ["type=2"])
  fun create(
    @RequestParam("title") title: String,
    @RequestParam("categoryId") categoryId: UUID,
    @RequestParam("eventOwnerId") eventOwnerId: UUID,
    @RequestParam("albumId") albumId: UUID
  ): Int {
    println(title)
    println(categoryId)
    println(eventOwnerId)
    println(albumId)

    repository.create(title, categoryId, eventOwnerId, albumId)

    return 1
  }
}
