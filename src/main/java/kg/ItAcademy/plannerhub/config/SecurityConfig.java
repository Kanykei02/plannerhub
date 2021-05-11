package kg.ItAcademy.plannerhub.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().anyRequest().permitAll()
//                authorizeRequests()
//                .antMatchers("/api/auth/**").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/users/**").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/users/**").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.GET, "/api/list/**").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/list/**").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/api/list/**").hasAnyRole("USER", "ADMIN")
//                .antMatchers(HttpMethod.POST, "/api/planner/**").hasAnyRole("USER", "ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/api/planner/**").hasAnyRole("USER", "ADMIN")
                .and()
                .httpBasic()
                .and().logout().and().formLogin();
    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery("select username, password from users where username=?")
//                .authoritiesByUsernameQuery("select u.username, ur.role_name from user_role ur join users u on ur.user_id = u.id where u.username=?");
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}