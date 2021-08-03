package blog.Services

import blog.models.User
import blog.Repository.UserRepository
import org.springframework.stereotype.Service


@Service("UserService")
class UserService (val db: UserRepository){
    fun getUsers(): List<User> = db.getUsers()

    fun postUser(user: User): User{
        print(user)
        return db.save(user) as User
    }

    fun findByEmail(email: String): User?{
        return this.db.findByEmail(email)


    }

    fun getById(id: String): User{
        return this.db.getById(id)
    }


}