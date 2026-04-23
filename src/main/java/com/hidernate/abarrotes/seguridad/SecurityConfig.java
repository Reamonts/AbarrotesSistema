package com.hidernate.abarrotes.seguridad;


import com.hidernate.abarrotes.Servicios.UsuarioServicio;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    private final UsuarioServicio userservice;

    public SecurityConfig(UsuarioServicio userservice) {
        this.userservice = userservice;
    }

    @Bean
    public PasswordEncoder codificaPass(){ return new BCryptPasswordEncoder(); }

    @Bean
    public AuthenticationManager autenticacion(AuthenticationConfiguration authConfig)
        throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityChain (HttpSecurity http, AuthenticationManager authmanager) throws Exception {
        http.
                csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers("/api/productos/**").hasAnyRole("ADMIN", "EMPLEADO")
                        .anyRequest().authenticated()
                )
                .authenticationManager(authmanager)
                .userDetailsService(userservice)
                .formLogin(form->form.permitAll())
                .httpBasic(basic->{});

        return http.build();
    }
}
