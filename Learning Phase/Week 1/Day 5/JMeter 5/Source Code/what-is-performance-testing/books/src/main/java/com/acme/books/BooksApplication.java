package com.acme.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableSpringDataWebSupport
public class BooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}

	@EnableWebSecurity
	protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

		@Bean
		public BCryptPasswordEncoder passwordEncoder() {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			return bCryptPasswordEncoder;
		}
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
					.authorizeRequests()
					.antMatchers(HttpMethod.POST, "/books/**/review").authenticated()
					.antMatchers("/**").permitAll()
					.and()
						.formLogin()
						.loginPage("/login")
						.defaultSuccessUrl("/books")
                        .loginProcessingUrl("/doLogin")
						.failureUrl("/login?error=true")
						.permitAll()
					.and()
						.logout()
						.logoutSuccessUrl("/")
						.permitAll()
			;

			/*http.authorizeRequests().antMatchers("/").permitAll().and()
					.authorizeRequests().antMatchers("/console/**").permitAll();*/
			http.csrf().disable();
			http.headers().frameOptions().disable();

		}

	}
}

