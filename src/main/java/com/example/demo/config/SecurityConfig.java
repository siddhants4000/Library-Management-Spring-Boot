package com.example.demo.config;

import com.example.demo.enums.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.demo.enums.UserRole.*;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/student/admin/**", "/allocate/admin/book", "/book/admin/add").hasRole(ADMIN.name())
                .antMatchers("/book/all","/book/search").hasAnyRole(ADMIN.name(), STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails admin=User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles(ADMIN.name())
                .build();

        UserDetails student=User.builder()
                .username("user")
                .password(passwordEncoder().encode("user"))
                .roles(STUDENT.name())
                .build();
        return new InMemoryUserDetailsManager(admin, student);
    }
}