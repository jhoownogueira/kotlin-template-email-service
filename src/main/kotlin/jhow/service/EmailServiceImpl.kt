package jhow.service

import jhow.model.Email
import jhow.model.EmailService
import jakarta.mail.Authenticator
import jakarta.mail.PasswordAuthentication
import jakarta.mail.Session
import jakarta.mail.Transport
import jakarta.mail.internet.InternetAddress
import jakarta.mail.internet.MimeMessage

import org.springframework.stereotype.Service
import java.util.*

@Service
class EmailServiceImpl : EmailService {

    override fun sendEmail(email: Email) {
        val properties = Properties().apply {
            setProperty("mail.smtp.auth", "true")
            setProperty("mail.smtp.starttls.enable", "true")
            setProperty("mail.smtp.host", "smtplw.com.br")
            setProperty("mail.smtp.port", "587")
        }

        val session = Session.getInstance(properties, object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication("username", "password")
            }
        })

        val message = MimeMessage(session).apply {
            setFrom(InternetAddress(email.from))
            setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(email.to))
            subject = email.subject
            setText(email.body)
        }

        Transport.send(message)
    }
}