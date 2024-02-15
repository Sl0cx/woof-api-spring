package com.m2i.woof.config;

import com.m2i.woof.service.security.UserDetServiceImpl;
import com.nimbusds.jose.jwk.source.ImmutableSecret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;
import javax.crypto.spec.SecretKeySpec;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserDetServiceImpl userDetService;
    private String certKey = "zKLMXzTgO9tCBB5NkKPwK2nzkhyABfOrVnhH/cdGK10vS3vSHzUURjVJHgzqEDiZdtgPhHm4zSo7fWsuN80hPc/6jnModwC3nZxNsKOikvU5jcFZgQDK7/Mh4OIQOa8IEbzbwvKsUKuG7WmHUEDXKU9AKWSbhe4UTMCI6JSZLv0j3hcK9jRIn11MV73+K1w18sWv/oKhoH2kuiOVapIY3LYMoZuAPx42bfn7eNE4zT1UyFPlP2gybQ3Aygnb4s24i0SjAvlvtknZM3HKODNcLzDKvLS/EnsUvuj8cmQai6UZ/a47kRBJ96MsBfCuUtZUemg2V+BRERzAGP75IU+0ex5DgwpZr+SLeUz9qOerFyU=";

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .userDetailsService(userDetService)
                // Jeton qui sera envoyé à chaque vue générée et qui sera soumis au serveur à chaque requete http (get, post..etc)
                //par défaut ici on le désactive car non utile
                .csrf(AbstractHttpConfigurer::disable)
                //Spring security ne va jamais crée de sesion HttpSesion pour obtenir les info de l'utilisateur connecté
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(autorize -> autorize
                        .requestMatchers( "user/login").permitAll()
                        .requestMatchers( "user/inscription").hasRole(String.valueOf(com.m2i.woof.model.Role.ADMIN))
                        .requestMatchers( "v3/api-docs/**",
                                "swagger-ui.html").permitAll()
                        .anyRequest()
                        .authenticated()
                ).httpBasic(Customizer.withDefaults())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                .build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        //Pas besoin de cette ligne son on génére le certificat via oppenssl
        SecretKeySpec secretKey = new SecretKeySpec(this.certKey.getBytes(), 0, this.certKey.getBytes().length,"RSA");
        return NimbusJwtDecoder.withSecretKey(secretKey).macAlgorithm(MacAlgorithm.HS256).build();
    }

    @Bean
    public JwtEncoder jwtEncoder(){
        return new NimbusJwtEncoder(new ImmutableSecret<>(this.certKey.getBytes()));
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
