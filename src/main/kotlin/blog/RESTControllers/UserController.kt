package blog.RESTControllers

import blog.Services.PokemonService
import blog.Services.UserPokemonService
import blog.Services.UserService
import blog.dtos.LoginDTO
import blog.dtos.PokemonDTO
import blog.models.User
import blog.dtos.RegisterDTO
import blog.models.UserPokemon
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception
import java.util.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/api")
class UserController (var service: UserService, var userPokemonService: UserPokemonService, var pokemonService: PokemonService){
    @PostMapping("/register")
    fun register(@RequestBody body: RegisterDTO): ResponseEntity<Any>{
        val user = User()
        user.name = body.name
        user.email = body.email
        user.password = body.password

        val existingUser = service.findByEmail(user.email)
        if (existingUser != null){
            return ResponseEntity.status(400).body("Email already in use")
        }
        return ResponseEntity.ok(this.service.postUser(user))
    }

    @PostMapping("/login")
    fun login(@RequestBody body: LoginDTO, response: HttpServletResponse): ResponseEntity<Any>{
        val user = this.service.findByEmail(body.email) ?: return ResponseEntity.badRequest().body("User not found.")

        if(!user.comparePassword(body.password)){
            return ResponseEntity.badRequest().body("Invalid Password.")
        }

        var issuer = user.id

        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() + 60 * 24 *1000))
            .signWith(SignatureAlgorithm.HS256, "secret").compact()

        val cookie = Cookie("jwt", jwt)
        cookie.isHttpOnly = true

        response.addCookie(cookie)
        return ResponseEntity.ok("success")
    }
    @GetMapping("/user")
    fun user(@CookieValue("jwt") jwt: String?): ResponseEntity<Any>{
        try {
            if (jwt == null) {
                return ResponseEntity.status(401).body("Unauthenticated")
            }

            val body = Jwts.parser().setSigningKey("secret").parseClaimsJws(jwt).body

            return ResponseEntity.ok(this.service.getById(body.issuer))
        } catch (e: Exception) {
            return ResponseEntity.status(401).body("Unauthenticated")
        }
    }

    @PostMapping("/logout")
    fun logout(response: HttpServletResponse): ResponseEntity<Any> {
        var cookie = Cookie("jwt", "")
        cookie.maxAge = 0
        response.addCookie(cookie)

        return ResponseEntity.ok("success")
    }

    @PostMapping("catch")
    fun catchPokemon(@CookieValue("jwt") jwt: String?, @RequestBody body: PokemonDTO): ResponseEntity<Any>{
        try {
            if (jwt == null) {
                return ResponseEntity.status(401).body("Unauthenticated")
            }

            val userBody = Jwts.parser().setSigningKey("secret").parseClaimsJws(jwt).body
            val userId: String = this.service.getById(userBody.issuer).id as String
            val pokemonNumber = body.number
            val userPokemon= UserPokemon()
            userPokemon.userId = userId
            userPokemon.pokemonId = pokemonService.findPokemonByNumber(pokemonNumber as Int).id as String
            print(userPokemon.pokemonId)
            return ResponseEntity.ok(this.userPokemonService.catch(userPokemon))

        }catch (e: Exception){
            print(e)
            return ResponseEntity.status(401).body("Unauthenticated")
        }
    }

    @GetMapping("caught")
    fun getCaughtPokemon(@CookieValue("jwt") jwt: String?): ResponseEntity<Any>{
        if (jwt == null) {
            return ResponseEntity.status(401).body("Unauthenticated 1")
        }
        try {
            val userBody = Jwts.parser().setSigningKey("secret").parseClaimsJws(jwt).body
            val userId: String = this.service.getById(userBody.issuer).id as String
            return ResponseEntity.ok(userPokemonService.getCaughtPokemon(userId))
        }catch (e: ExpiredJwtException){
            return ResponseEntity.status(401).body("unauthenticated")
        }
    }
}