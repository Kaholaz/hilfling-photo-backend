package hilfling.backend.hilfling.repository

import hilfling.backend.hilfling.model.*
import me.liuwj.ktorm.database.Database
import me.liuwj.ktorm.dsl.eq
import me.liuwj.ktorm.entity.add
import me.liuwj.ktorm.entity.find
import me.liuwj.ktorm.entity.toList
import org.springframework.beans.factory.annotation.Autowired

class ArticleRepository {
    @Autowired
    lateinit var database: Database

    fun findById(id: Int): Article? {
        return database.articles.find { it.id eq id }
    }

    fun findAll(): List<Article> {
        return database.articles.toList()
    }

    fun create(
            article: Article
    ): Article {
        val articleFromDatabase = Article{
            this.title = article.title
            this.plainTextBody = article.plainTextBody
            this.securityLevel = article.securityLevel
            this.photoGangBanger = article.photoGangBanger
        }
        database.articles.add(articleFromDatabase)
        return articleFromDatabase
    }
}