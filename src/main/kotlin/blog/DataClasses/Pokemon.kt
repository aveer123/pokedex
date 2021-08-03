package blog.DataClasses

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("POKEMON")
data class Pokemon(@Id val id: String?, val name: String, val number: Int)
