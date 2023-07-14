package com.board.newb_board_server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CorsConfig implements WebMvcConfigurer {

    private static final long MAXSEC = 3600;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // 허용할 도메인 설정
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowCredentials(true) // 쿠키 인증 요청 허용
                .exposedHeaders("Access-Control-Allow-Headers", "Access-Control-Allow-Origin", "Authorization, x-xsrf-token, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, " +
                        "Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers", HttpHeaders.CONTENT_DISPOSITION)
//                                .allowedHeaders("*")
                .maxAge(MAXSEC);
    }
}
