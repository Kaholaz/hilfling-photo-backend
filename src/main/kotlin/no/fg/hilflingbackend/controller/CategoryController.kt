package no.fg.hilflingbackend.controller

import no.fg.hilflingbackend.model.Category
import no.fg.hilflingbackend.repository.CategoryRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/categories")
open class CategoryController (override val repository: CategoryRepository): Controller<Category>(repository) {
}
