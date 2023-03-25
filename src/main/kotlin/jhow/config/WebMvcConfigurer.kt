package jhow.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig: WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {

         try {
             registry.addMapping("/**")
                 .allowedOrigins("*")
                 .allowedMethods("POST")
                 .allowedHeaders("*")
                 .allowCredentials(false) // set to true to allow cookies to be accessed
                 .maxAge(3600)
         } catch (e: Exception) {
             e.printStackTrace()
         }

    }
}
