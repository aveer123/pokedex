package blog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.annotation.Id
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import java.util.*
import blog.RESTControllers.PokemonController
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.stereotype.Repository


@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class PokedexApplication

fun main(args: Array<String>) {
	runApplication<PokedexApplication>(*args)
}

//@RestController
//class MessageResource(val service: MessageService) {
//	@GetMapping
//	fun index(): List<Pokemon> = service.findMessages()
//
//	@PostMapping
//	fun post(@RequestBody pokemon: Pokemon) {
//		service.post(pokemon)
//	}
//
//	@DeleteMapping
//	fun delete(@PathVariable id: Long){
//		TODO()
//	}
//}
//
//@Table("POKEMON")
//data class Pokemon(@Id val id: String?, val name: String, val number: Int, val isCaught: Boolean)

//interface MessageRepository : CrudRepository<Pokemon, String> {
//
//	@Query("select * from pokemon")
//	fun findMessages(): List<Pokemon>
//
//}

//@Service
//class MessageService(val db: MessageRepository) {
//
//	fun findMessages(): List<Pokemon> = db.findMessages()
//
//	fun post(pokemon: Pokemon){
//		print("yo")
//		db.save(pokemon)
//	}
//	fun delete(id: UUID){
//		TODO()
//	}
//}