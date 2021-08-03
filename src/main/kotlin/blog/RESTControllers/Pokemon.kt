package blog.RESTControllers

import blog.models.Pokemon
import org.springframework.web.bind.annotation.*
import blog.Services.PokemonService


@RestController
@RequestMapping("/api")
class PokemonController (val service: PokemonService){
    @GetMapping("/get-pokemon")
    fun index(): List<Pokemon> = service.findMessages()

    @GetMapping("/find-pokemon/{number}")
    fun findPokemon(@PathVariable number: Int): Pokemon{
        return service.findPokemonByNumber(number)
    }

    @PostMapping("/post-pokemon")
    fun post(@RequestBody pokemon: Pokemon) {
        service.post(pokemon)
    }

    @DeleteMapping
    fun delete(@PathVariable id: Long){
        TODO()
    }
}