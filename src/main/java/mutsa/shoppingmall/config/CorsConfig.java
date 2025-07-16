package mutsa.shoppingmall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000",
                                "http://3.35.240.152",
                                "https://3.35.240.152",
                                "http://shmall.store",
                                "https://shmall.store",
                                "https://shmall.store:8080",
                                "http://shmall.store:8080",
                                "https://week5-shopping-mall-fmc6.vercel.app"
                        )
                        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);  // 쿠키 허용
            }
        };
    }
}