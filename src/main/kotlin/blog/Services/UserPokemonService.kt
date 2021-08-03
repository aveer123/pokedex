package blog.Services

import blog.Repository.UserPokemonRepository
import blog.models.Pokemon
import blog.models.User
import blog.models.UserPokemon
import org.springframework.stereotype.Service

@Service
class UserPokemonService (val db: UserPokemonRepository) {
    fun catch(userPokemon: UserPokemon){
        print("made it here 2")
        print(userPokemon)
        db.save(userPokemon)
    }

    fun getCaughtPokemon(userId: String): List<Pokemon>{
        var pokemonIdList = db.getCaughtPokemon(userId)
        var pokemonList: MutableList<Pokemon> = mutableListOf()
        for(i in pokemonIdList){
            var currentPokemon = db.findPokemonById(i)
            pokemonList.add(currentPokemon)
        }
        return pokemonList
    }
}