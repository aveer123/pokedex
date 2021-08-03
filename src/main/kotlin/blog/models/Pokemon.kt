package blog.models

import blog.DataClasses.Pokemon
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.ArrayList
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany

@Table("POKEMON")
@Entity
class Pokemon {
    @Id
    var id: String? = null
        get() = field
        set(value) {
            field = value
        }

    var name: String = ""

    var number: Int = -1


//    @ManyToMany
//    @JoinTable(name = "user_pokemon",
//        joinColumns = [JoinColumn(name = "fk_pokemon")],
//        inverseJoinColumns = [JoinColumn(name = "fk_user")]
//    )
//    var users: List<User> = ArrayList()
}