package blog.Services

import blog.models.Pokemon
import blog.Repository.PokemonRepository
import org.springframework.stereotype.Service

@Service("PokemonService")
class PokemonService (val db: PokemonRepository){

    fun findMessages(): List<Pokemon> {
        return db.findMessages()

    }

    fun post(pokemon: Pokemon): Pokemon{
        print(pokemon)
        return db.save(pokemon)
    }
    fun findPokemonByNumber(number: Int): Pokemon{
        return db.findPokemonByNumber(number) ?: throw Exception("No pokemon found by id")

    }
}
