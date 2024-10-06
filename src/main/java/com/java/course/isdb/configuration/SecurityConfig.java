package com.java.course.isdb.configuration;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import static com.java.course.isdb.entity.Role.*;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers("/auth/**")
                                .permitAll()
                                .requestMatchers(checkPort(8180)).permitAll()
                                .requestMatchers("/swagger-ui/**")
                                .permitAll()
                                .requestMatchers("/v3/api-docs/**")
                                .permitAll()
                                .requestMatchers("/admins").hasAnyRole(ADMIN.name(), EMPLOYEE.name())
                                .requestMatchers("/admins/**").hasRole(ADMIN.name())
                                .requestMatchers("/stats").hasAnyRole(ADMIN.name(), EMPLOYEE.name())
                                .requestMatchers("/stats/**").hasRole(ADMIN.name())
                                .requestMatchers(GET, "/stats/**").hasRole(EMPLOYEE.name())
                                .requestMatchers("/dayoff-requests").hasAnyRole(ADMIN.name(), EMPLOYEE.name())
                                .requestMatchers("/dayoff-requests/**").hasRole(ADMIN.name())
                                .requestMatchers(GET, "/dayoff-requests/**").hasRole(EMPLOYEE.name())
                                .requestMatchers(PUT, "/dayoff-requests/**").hasRole(EMPLOYEE.name())
                                .requestMatchers("/work-time").hasAnyRole(ADMIN.name())
                                .requestMatchers(GET,"/tasks").hasAnyRole(ADMIN.name(), EMPLOYEE.name())
                                .requestMatchers(POST,"/tasks").hasAnyRole(ADMIN.name())
                                .requestMatchers(GET,"/tasks").hasAnyRole(ADMIN.name(), EMPLOYEE.name())
                                .requestMatchers(POST,"/tasks").hasAnyRole(ADMIN.name())
                                .requestMatchers("/food-compensation").hasAnyRole(ADMIN.name())
                                .requestMatchers("/food-compensation/**").hasAnyRole(ADMIN.name())
                                .requestMatchers("/equipment/**").hasAnyRole(ADMIN.name())
                                .requestMatchers("/equipment").hasAnyRole(ADMIN.name())
                                .requestMatchers(GET,"/courses").hasAnyRole(ADMIN.name(), EMPLOYEE.name())
                                .requestMatchers(GET,"/courses/enrollments").hasAnyRole(ADMIN.name(), EMPLOYEE.name())
                                .requestMatchers("/courses").hasAnyRole(ADMIN.name())
                                .requestMatchers("/courses/**").hasAnyRole(ADMIN.name())
                                .requestMatchers("/employees").hasAnyRole(ADMIN.name())
                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    private RequestMatcher checkPort(int port) {
        return (HttpServletRequest request) -> port == request.getLocalPort();
    }
}
