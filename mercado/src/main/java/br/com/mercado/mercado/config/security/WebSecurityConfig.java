package br.com.mercado.mercado.config.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/login")
                .failureForwardUrl("/error.html")
                .and()
                .logout()
                .logoutSuccessUrl("/index")
                .and()
                .httpBasic()
                .and()
                .authorizeRequests()
                /*DETERMINA QUE PARA REALIZAR ESSA REQUEST PRECISA TER UMA DAS PERMISSÕES ABAIXO
                 * EXEMPLO DA URL: http://localhost:8095/usuario/novoCadastro
                 * VEJA QUE EM UM ITEM("hasRole('ADMIN')) NÃO ESTOU PASSANDO O PREFIXO ROLE_, ESSE PREFIXO NÃO É OBRIGATÓRIO
                 * QUANDO USAMOS o hasRole*/
                .antMatchers(HttpMethod.GET,"/login/**").permitAll()
                //.antMatchers(HttpMethod.GET, "/prod/**").permitAll()
                .antMatchers(HttpMethod.GET,"/listvenda/**").permitAll()
                .antMatchers(HttpMethod.GET,"/nota/**").permitAll()
                .antMatchers(HttpMethod.GET,"/savevenda").permitAll()
                /*DETERMINA QUE PARA REALIZAR ESSA REQUEST PRECISA TER UMA DAS PERMISSÕES ABAIXO
                 * EXEMPLO DA URL: http://localhost:8095/usuario/consultar */
                .antMatchers(HttpMethod.POST, "/prod").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/prod/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/listvenda/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/nota").hasRole("USER")
                //.antMatchers(HttpMethod.POST, "/prod").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf().disable();


    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        auth.inMemoryAuthentication()
                .withUser("alisson")
                .password(passwordEncoder().encode("123456"))
                .roles("ADMIN")
                .and()
                .withUser("shay")
                .password(passwordEncoder().encode("123456"))
                .roles("USER");

        /* auth.userDetailsService(userDetailsService)
        *           .passworEncoder(passwordEncoder)*/
    }

    @Bean
    protected PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
