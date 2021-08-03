package blog.models

import blog.DataClasses.Pokemon
import net.minidev.json.annotate.JsonIgnore
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.util.ArrayList
import javax.persistence.*


@Table("USERS")
@Entity
class User {
    @Id
    var id: String? = null
        get() = field
        set(value) {
            field = value
        }

    @Column
    var name: String = ""

    @Column()
    var email = ""

    @Column
    var password = ""
        @JsonIgnore
        get() = field
        set(value) {
            val passwordEncoder = BCryptPasswordEncoder()
            field = passwordEncoder.encode(value)
        }

    fun comparePassword(password: String): Boolean{
        return BCryptPasswordEncoder().matches(password, this.password)
    }

//    @ManyToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
//    @JoinTable(name = "user_pokemon",
//        joinColumns = [JoinColumn(name = "fk_user")],
//        inverseJoinColumns = [JoinColumn(name = "fk_pokemon")]
//    )
//    var pokemon: List<Pokemon> = ArrayList()


}