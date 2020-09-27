package hilfling.backend.hilfling.controller

import hilfling.backend.hilfling.model.Album
import hilfling.backend.hilfling.repository.AlbumRepository
import me.liuwj.ktorm.database.Database
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/albums")
class AlbumController {

    @Autowired
    val repository = AlbumRepository()

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Int) : Album? {
        return repository.findById(id)
    }

    @GetMapping
    fun getAll() : List<Album> {
        return repository.findAll()
    }

    @PostMapping
    fun create(
            @RequestParam("album") album: Album
    ): Album {
        return repository.create(album)
    }
}