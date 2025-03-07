package com.empmanagement.employee_service.SecurityConfig;

import com.empmanagement.employee_service.JwtFilter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(csrf -> csrf.disable()) // Disable CSRF
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/h2-console/**", "/auth/**", "/error").permitAll() // Public endpoints
//                        .requestMatchers("/company").hasRole("admin")
//                        .requestMatchers("/employee").hasRole("user")
//                        .requestMatchers("/address").hasAnyRole("user", "admin")
//                        .anyRequest().authenticated() // Secure other endpoints
//                )
//                .headers(headers -> headers.frameOptions(frame -> frame.disable())) // Allow H2 Console
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authenticationProvider(authenticationProvider()) // Ensure the authentication provider is used
//                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
//                .httpBasic(Customizer.withDefaults())
//                .build();
//    }
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .csrf(csrf -> csrf.disable()) // Disable CSRF
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/h2-console/**", "/auth/**", "/error").permitAll()
                    .requestMatchers("/company").hasRole("admin")
                    .requestMatchers("/employee").hasAnyRole("user","admin")
                    .requestMatchers("/address").hasAnyRole("user", "admin")
                    .anyRequest().authenticated() // Secure other endpoints
            )
            .headers(headers -> headers.frameOptions(frame -> frame.disable())) // Allow H2 Console
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authenticationProvider()) // Ensure the authentication provider is used
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
            .httpBasic(Customizer.withDefaults())
            .build();
}

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://127.0.0.1:3000")); // Allow frontend origin
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));
        configuration.setAllowCredentials(true); // Allow sending cookies if needed

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults(""); // Removes "ROLE_" prefix
    }

}
