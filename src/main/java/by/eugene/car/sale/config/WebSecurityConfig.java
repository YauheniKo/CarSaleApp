package by.eugene.car.sale.config;



import by.eugene.car.sale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // эта аннотация нужна именно здель для работы аннотации @PreAuthorize("hasAuthority('ADMIN')") из UserController
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(8);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .authorizeRequests()
                    .antMatchers("/", "/registration","/static/**", "/activate/*").permitAll()//означает что главная страница и страница регистрации доступна всем
                    .anyRequest().authenticated()// для остальных запросов мы требуем авторизацию
                .and()
                    .formLogin()//включаем форм Логин
                    .loginPage("/login")// страница логина находится на этом маппинге
                    .permitAll()//и разрешаем этим пользоваться всем
                .and()
                    .logout()// включаем логаут
                    .permitAll();//и разрешаем им пользоваться всем
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder);


    }
}
