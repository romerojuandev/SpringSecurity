package com.concesionario.config;

import com.concesionario.service.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//
//        return httpSecurity
//                .csrf(csrf -> csrf.disable())
//                .httpBasic(Customizer.withDefaults())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(http ->
//                {
//                    //Endpoints públicos
//                    http.requestMatchers(HttpMethod.GET, "/auth/hello").permitAll();
//
//                    //Endpoints privados
//                    http.requestMatchers(HttpMethod.GET, "/auth/hello-secured").hasAuthority("CREATE");
//                    http.requestMatchers(HttpMethod.POST, "/auth/hello-secured").hasAnyAuthority("CREATE", "DELETE");
//                    http.requestMatchers(HttpMethod.PATCH, "/auth/hello-secured").hasAnyRole("ADMIN", DEVELOPER);
//
//                    //Endpoints no especificados
//                    http.anyRequest().denyAll();
//                    //http.anyRequest().authenticated();
//                })
//                .build();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {

        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailServiceImpl userDetailService){

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailService);
        return provider;
    }

    //SIMULACIÓN DE USUARIOS TRAIDOS DE LA BD
//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        List<UserDetails> userDetailsList = new ArrayList<>();
//
//        userDetailsList.add(User.withUsername("juancho")
//                .password("1720")
//                .roles("ADMIN")
//                .authorities("READ", "CREATE")
//                .build());
//
//        userDetailsList.add(User.withUsername("eli")
//                .password("1234")
//                .roles("USER")
//                .authorities("READ")
//                .build());
//
//        return new InMemoryUserDetailsManager(userDetailsList);
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        //SOLO USAR PARA PRUEBA, NUNCA PARA PRODUCCIÓN
        //return NoOpPasswordEncoder.getInstance();

        return new BCryptPasswordEncoder();
        //System.out.println(new BCryptPasswordEncoder().encode("1234"));
    }



}
