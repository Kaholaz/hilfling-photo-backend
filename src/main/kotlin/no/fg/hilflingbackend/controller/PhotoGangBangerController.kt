package no.fg.hilflingbackend.controller

import no.fg.hilflingbackend.model.PhotoGangBanger
import no.fg.hilflingbackend.repository.PhotoGangBangerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/photo_gang_bangers")
class PhotoGangBangerController {
  @Autowired
  lateinit var repository: PhotoGangBangerRepository

  @GetMapping("/{id}")
  fun getById(@PathVariable("id") id: UUID): PhotoGangBanger? {
    return repository.findById(id)
  }

  @GetMapping
  fun getAll(): List<PhotoGangBanger> {
    return repository.findAll()
  }

  @GetMapping("/actives")
  fun getActives(): List<PhotoGangBanger> {
    return repository.findAllActives()
  }

  @GetMapping("/active_pangs")
  fun getActivePangs(): List<PhotoGangBanger> {
    return repository.findAllActivePangs()
  }

  @GetMapping("/inactive_pangs")
  fun getInActivePangs(): List<PhotoGangBanger> {
    return repository.findAllInActivePangs()
  }

  @PostMapping
  fun create(
    @RequestBody photoGangBanger: PhotoGangBanger
  ): PhotoGangBanger {
    return repository.create(photoGangBanger)
  }
}