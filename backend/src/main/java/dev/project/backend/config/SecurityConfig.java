package dev.project.backend.config;

import dev.project.backend.config.filter.JwtAuthenticationFilter;
import dev.project.backend.entities.Role;
import dev.project.backend.utils.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig {
    private CorsConfigurationSource corsConfigurationSource;
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuth;

    @Autowired
    public SecurityConfig(CorsConfigurationSource corsConfigurationSource, AuthenticationProvider authenticationProvider, JwtAuthenticationFilter jwtAuth) {
        this.corsConfigurationSource = corsConfigurationSource;
        this.authenticationProvider = authenticationProvider;
        this.jwtAuth = jwtAuth;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception {
        http.authorizeHttpRequests(
                configure -> configure
                        .requestMatchers("api/public/**", "api/login/").permitAll()
                        .requestMatchers("api/patient/**").hasRole(Roles.PATIENT.name())
                        .requestMatchers("api/physician/**").hasRole(Roles.PHYSICIAN.name())
        );
        http.cors(configure -> configure.configurationSource(corsConfigurationSource));
        http.csrf(AbstractHttpConfigurer::disable);
        http.sessionManagement(configure -> configure.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.authenticationProvider(authenticationProvider);
        http.addFilterBefore(jwtAuth, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
