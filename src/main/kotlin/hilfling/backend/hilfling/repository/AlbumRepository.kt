package hilfling.backend.hilfling.repository

import hilfling.backend.hilfling.model.Album
import hilfling.backend.hilfling.model.albums
import me.liuwj.ktorm.database.Database
import me.liuwj.ktorm.dsl.eq
import me.liuwj.ktorm.entity.add
import me.liuwj.ktorm.entity.find
import me.liuwj.ktorm.entity.toList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
class AlbumRepository {
    @Autowired
    lateinit var database: Database

    fun findById(id: Int): Album? {
        return database.albums.find { it.id eq id }
    }

    fun findAll(): List<Album> {
        /*if (::database.isInitialized) {
            println("------------------")
            println("------------------")
            println("------------------")
            println("------------------")
            println("------------------")
            //return database.albums.toList()
            return listOf<Album>()
        }*/
        //return listOf<Album>()
        return database.albums.toList()
    }

    fun create(
            album: Album
    ): Album {
        val albumFromDatabase = Album {
            this.title = album.title
            this.isAnalog = album.isAnalog
            this.dateCreated = LocalDate.now()
        }
        database.albums.add(albumFromDatabase)
        return albumFromDatabase
    }
}