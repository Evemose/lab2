package org.projectparams.lab2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@SuppressWarnings("deprecation")
public class SecurityConfig {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests.requestMatchers("/tests/attempts").hasRole("TEACHER")
                )
                .cors(withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(withDefaults())
                .formLogin(AbstractHttpConfigurer::disable)
                .build();
    }

    @Bean
    public UserDetailsManager users() {
        var student = User.builder()
                .username("user1")
                .password("123")
                .roles("STUDENT")
                .build();
        var teacher = User.builder()
                .username("user3")
                .password("123")
                .roles("TEACHER")
                .build();
        return new InMemoryUserDetailsManager(student, teacher);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
