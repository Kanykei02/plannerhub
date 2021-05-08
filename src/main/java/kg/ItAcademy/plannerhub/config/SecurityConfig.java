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
import org.springframework.http.HttpMethod;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
                authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/users/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/list/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/list/**").hasRole("ADMIN") // -- Метод создания подписчиков. Добавил разрешение только одмену.
                // Насколько это юзабельная штука для нас? возможно следует выпилить её
                .antMatchers(HttpMethod.DELETE, "/api/list/**").hasAnyRole("USER", "ADMIN") // Тоже вопрос. Есть метод удалить по ИД - это норм, разрешается юзеру.
                // Но есть метод удалить всех своих фолловеров, и следует ли давать юзеру право на это? Метод также под вопросом
                .antMatchers(HttpMethod.POST, "/api/planner/**").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/planner/**").hasAnyRole("USER", "ADMIN") // Нужно переделать метод удаления по ИД/
                // Во время удаления проверяется ИД криейтера, чтоб кто угодно не мог удалить задачу/планерку. Также добавить возможность админу. Метод удалить все планерки тоже наверн надо выпилить
                .and()
                .httpBasic()
                .and().logout().and().formLogin();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}