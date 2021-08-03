package blog.Repository

import blog.models.Pokemon
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PokemonRepository : CrudRepository<Pokemon, String> {


    @Query("select * from pokemon")
    fun findMessages(): List<Pokemon>

    @Query("SELECT * FROM POKEMON where number=:number")
    fun findPokemonByNumber(number: Int): Pokemon?


    }


