package learn.cat.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtConverter converter;

    public SecurityConfig(JwtConverter converter) {
        this.converter = converter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors();

        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/authenticate").permitAll()
                .antMatchers("/create_account").permitAll()
                .antMatchers("/refresh_token").permitAll()
                .antMatchers(HttpMethod.GET, "/api", "/api/*", "/api/cat/*", "/api/alias/*", "/api/location/*", "/api/report", "/api/sighting/*", "/api/users/*").permitAll()
////                .antMatchers(HttpMethod.POST, "/api").hasAnyRole("USER", "ADMIN")
////                .antMatchers(HttpMethod.PUT, "/api").hasAnyRole("USER", "ADMIN")
////                .antMatchers(HttpMethod.DELETE, "/api/*").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api", "/api/*", "/api/alias", "/api/cat", "/api/location", "/api/report", "/api/sighting", "/api/users").permitAll()
                .antMatchers(HttpMethod.PUT, "/api", "/api/*", "/api/cat/*", "/api/alias/*", "/api/location/*", "/api/report", "/api/sighting/*", "/api/users/*").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/*", "/api/cat/*", "/api/alias/*", "/api/location/*", "/api/report", "/api/sighting/*", "/api/users/*").permitAll()
//                //  Alias
//                .antMatchers(HttpMethod.POST, "/api/alias").hasAnyRole("USER", "ADMIN")
//                .antMatchers(HttpMethod.PUT, "/api/alias/*").hasAnyRole("USER", "ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/api/alias*").hasAnyRole("USER", "ADMIN")
//
//                // Cat
//                .antMatchers(HttpMethod.POST, "/api/cat").hasAnyRole("USER", "ADMIN")
//                .antMatchers(HttpMethod.PUT, "/api/cat/*").hasAnyRole("USER", "ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/api/cat*").hasAnyRole("USER", "ADMIN")
//
//                //  Location
//                .antMatchers(HttpMethod.POST, "/api/cat").hasAnyRole("USER", "ADMIN")
//                .antMatchers(HttpMethod.PUT, "/api/cat/*").hasAnyRole("USER", "ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/api/cat*").hasAnyRole("USER", "ADMIN")
//
//                //  Report
//                .antMatchers(HttpMethod.POST, "/api/report").hasAnyRole("USER", "ADMIN")
//                .antMatchers(HttpMethod.PUT, "/api/report/*").hasAnyRole("USER", "ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/api/report*").hasAnyRole("USER", "ADMIN")
//
//                //  Sighting
//                .antMatchers(HttpMethod.POST, "/api/sighting").hasAnyRole("USER", "ADMIN")
//                .antMatchers(HttpMethod.PUT, "/api/sighting/*").hasAnyRole("USER", "ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/api/sighting*").hasAnyRole("USER", "ADMIN")
//
//                //  Users
//                .antMatchers(HttpMethod.POST, "/api/users").hasAnyRole("USER", "ADMIN")
//                .antMatchers(HttpMethod.PUT, "/api/users/*").hasAnyRole("USER", "ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/api/users*").hasAnyRole("USER", "ADMIN")

                .antMatchers("/**").denyAll()
                .and()
                .addFilter(new JwtRequestFilter(authenticationManager(), converter))
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

//    @Autowired
//    private PasswordEncoder encoder;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        User.UserBuilder userBuilder = User.withUsername("user")
//                .password("user").passwordEncoder(password -> encoder.encode(password))
//                .roles("USER");
//
//        User.UserBuilder adminBuilder = User.withUsername("admin")
//                .password("admin").passwordEncoder(password -> encoder.encode(password))
//                .roles("ADMIN");
//
//        auth.inMemoryAuthentication()
//                .withUser(userBuilder)
//                .withUser(adminBuilder);
//    }

    @Bean
    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }
}
