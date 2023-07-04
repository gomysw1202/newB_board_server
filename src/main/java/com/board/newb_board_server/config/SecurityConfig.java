package com.board.newb_board_server.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.disable())
                .authorizeHttpRequests(request -> request
                                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                                .requestMatchers("/status", "/images/**", "/login", "/signUp").permitAll()
                                .anyRequest()
//                                .anonymous() // 일단 테스트라서 어노니머스로 설정해놓음
                                .authenticated()	// 어떠한 요청이라도 인증필요
                )
                .formLogin(login -> login	// form 방식 로그인 사용
                                .loginPage("http://localhost:3000/login")	// [A] 커스텀 로그인 페이지 지정
//                                .loginProcessingUrl("/authenticate")	// [B] submit 받을 url
                                .usernameParameter("userid")	// [C] submit할 아이디
                                .passwordParameter("passwd")	// [D] submit할 비밀번호
                                .defaultSuccessUrl("http://localhost:3000/main", true)
                )
                .logout(withDefaults());	// 로그아웃은 기본설정으로 (/logout으로 인증해제)

        return http.build();
    }
}