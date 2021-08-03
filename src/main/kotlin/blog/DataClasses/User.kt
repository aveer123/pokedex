package blog.DataClasses


import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table


@Table("USERS")
data class User(@Id var id: String? = null, var name: String = "", var email: String = "", var password: String = "")
