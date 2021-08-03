package blog.RESTControllers

import org.springframework.web.bind.annotation.GetMapping
import blog.Services.RegistrationService

class RegistrationController (val service: RegistrationService){
    @GetMapping
    fun Register(userName: String, password: String){

    }
}