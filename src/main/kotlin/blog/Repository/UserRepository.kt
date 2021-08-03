package blog.Repository


import blog.models.User
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository



@Repository
interface UserRepository : CrudRepository<User, String> {
    @Query("select * from users")
    fun getUsers(): List<User>

    fun save(user: User): User?{
        return this.save(user)

    }

    fun findByEmail(email: String): User?

    fun getById(id: String): User
}