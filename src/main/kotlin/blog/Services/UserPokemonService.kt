package blog.Services

import blog.Repository.UserPokemonRepository
import blog.models.Pokemon
import blog.models.UserPokemon
import org.springframework.stereotype.Service

@Service
class UserPokemonService (val db: UserPokemonRepository) {
    fun catch(userPokemon: UserPokemon): String{
        db.save(userPokemon)
        return ("Caught pokemon")
    }

    fun getCaughtPokemon(userId: String): List<Pokemon>{
        val pokemonIdList = db.getCaughtPokemon(userId)
        val pokemonList: MutableList<Pokemon> = mutableListOf()
        for(i in pokemonIdList){
            val currentPokemon = db.findPokemonById(i)
            pokemonList.add(currentPokemon)
        }
        return pokemonList
    }
}