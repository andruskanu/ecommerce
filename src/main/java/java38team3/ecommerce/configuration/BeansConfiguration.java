package java38team3.ecommerce.configuration;

import org.hibernate.boot.archive.scan.internal.NoopEntryHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class BeansConfiguration {
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    dXNlcjpwYXNz
    // "Authorization": "Basic dXNlcjpwYXNz"

//    @Bean
////    public PasswordEncoder noOpPasswordEncoder(){
////        return NoOpPasswordEncoder.getInstance();
////    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(
//                        (authz) -> authz.antMatchers(HttpMethod.GET, "/api/users").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/users/**").authenticated()
////                .antMatchers("/api/users/**").hasAuthority("ROLE_USER_ADMIN")
//                        .anyRequest().permitAll() )
//                .formLogin().and()
//                .httpBasic().and()
//                .logout()
//                .and()
//                .csrf().ignoringAntMatchers("/api/**")
//                .and()
//                .headers().frameOptions().disable()
//        ;
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().and()
                .authorizeRequests(
                        (authz) -> authz.antMatchers("/api/users/**").permitAll()

////                .antMatchers("/api/users/**").hasAuthority("ROLE_USER_ADMIN")
                                .anyRequest().permitAll() )
                .formLogin().and()
                .httpBasic().and()
                .logout()
                .and()
//                .csrf().ignoringAntMatchers("/api/**")
//                .and()
                .headers().frameOptions().disable()
        ;
        return http.build();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
