package com.board.newb_board_server.config;

import com.board.newb_board_server.security.JwtAuthenticationFilter;
import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(request -> request
                                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                                .requestMatchers("/status", "/images/**", "/login", "/signUp" , "/board/*", "/api/v1/auth/**").permitAll()
                                .anyRequest()
//                                .anonymous() // 일단 테스트라서 어노니머스로 설정해놓음
                                .authenticated()	// 어떠한 요청이라도 인증필요
                ).sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin(login -> login	// form 방식 로그인 사용
//                                .loginPage("http://localhost:3000/login")	// [A] 커스텀 로그인 페이지 지정
//                                .loginProcessingUrl("/login")	// [B] submit 받을 url
//                                .usernameParameter("userid")	// [C] submit할 아이디
//                                .passwordParameter("passwd")	// [D] submit할 비밀번호
                                .defaultSuccessUrl("http://localhost:3000/main", true)
                )
                .logout(withDefaults());	// 로그아웃은 기본설정으로 (/logout으로 인증해제)

        return http.build();
    }
}