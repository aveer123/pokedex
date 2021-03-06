package blog.models

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import javax.persistence.Entity

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