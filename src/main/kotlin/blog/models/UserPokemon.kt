package blog.models

import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import javax.persistence.Entity

@Table("USER_POKEMON")
@Entity
class UserPokemon (){
    @org.springframework.data.annotation.Id
    var id: String? = null
        get() = field
        set(value) {
            field = value
        }

    @Column("USER_ID")
    var userId: String? = ""

    @Column("POKEMON_ID")
    var pokemonId: String? = ""
}