package OnlineShoping.config;

import OnlineShoping.config.jwt.JwtRequestFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    public JwtRequestFilter jwtFilter(){
        return new JwtRequestFilter();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http. cors().and().csrf().disable().
              authorizeRequests().
              antMatchers("/auth/**").permitAll().
              anyRequest().authenticated().and().
              exceptionHandling().and().
              sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
              logout().clearAuthentication(true).invalidateHttpSession(true).
              deleteCookies("JESSIONID").
              logoutSuccessUrl("/login");

      http.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);


    }
}
