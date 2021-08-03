package blog.Repository

import blog.models.Pokemon
import blog.models.User
import blog.models.UserPokemon
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface UserPokemonRepository : CrudRepository<UserPokemon, String> {
    @Query("select pokemon_id from user_pokemon where user_id = :userId ")
    fun getCaughtPokemon(userId: String): List<String>

    @Query("SELECT * FROM POKEMON where id=:userId")
    fun findPokemonById(userId: String): Pokemon

}
