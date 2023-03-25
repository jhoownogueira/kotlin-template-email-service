package jhow.controller

import jhow.model.Email
import jhow.model.EmailService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/email")
class EmailController(
    val emailService: EmailService
) {
    @PostMapping
    fun sendEmail(@RequestBody email: Email) {
        emailService.sendEmail(email)
    }
}