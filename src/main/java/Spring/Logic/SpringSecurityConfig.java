package Spring.Logic;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//Basic Auth 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user").password("pass").roles("USER");
    }

   
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.httpBasic().and().authorizeRequests()
                        .antMatchers(HttpMethod.GET,"/endpoint/getallinput").hasRole("USER")
        //    .antMatchers(HttpMethod.GET,"/endpoint/getallinput").hasRole("USER");
//            .and()
            .and().csrf().disable().logout().clearAuthentication(true).logoutUrl("/appLogout").logoutSuccessUrl("/endpoint/getallinput")
            .deleteCookies("JSESSIONID")
            .invalidateHttpSession(true); 
    }

}
