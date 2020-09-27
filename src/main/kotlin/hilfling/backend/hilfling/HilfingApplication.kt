package hilfling.backend.hilfling

import hilfling.backend.hilfling.configurations.KtormConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

//@EnableConfigurationProperties(
//    FileStorageProperties::class
//)

@SpringBootApplication
open class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
