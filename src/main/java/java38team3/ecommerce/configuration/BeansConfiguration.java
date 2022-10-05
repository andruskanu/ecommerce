package java38team3.ecommerce.configuration;

import org.hibernate.boot.archive.scan.internal.NoopEntryHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BeansConfiguration {
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    dXNlcjpwYXNz
    // "Authorization": "Basic dXNlcjpwYXNz"

    @Bean
    public PasswordEncoder noOpPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
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
        http
                .authorizeRequests(
                        (authz) -> authz.antMatchers("/api/users/**").permitAll()

////                .antMatchers("/api/users/**").hasAuthority("ROLE_USER_ADMIN")
                                .anyRequest().permitAll() )
                .formLogin().and()
                .httpBasic().and()
                .logout()
                .and()
                .csrf().ignoringAntMatchers("/api/**")
                .and()
                .headers().frameOptions().disable()
        ;
        return http.build();
    }
}
