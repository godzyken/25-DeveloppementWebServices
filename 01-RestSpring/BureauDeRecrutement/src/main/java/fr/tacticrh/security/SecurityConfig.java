/**
 * 
 */
package fr.tacticrh.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author 1603599
 * 
 * <b>CLASSE QUI CONFIGURE LA GESTION DE LA SECURITE DE L'APPLICATION</b>
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	
	
	/**
	 * <b>METHODE QUI DEFINIT :
	 * <br/>Le mode de gestion des utilisateurs.
	 * <br/>Les roles d'utilisateurs.
	 * <br/>Les utilisateurs et leurs mots de passe.
	 * 
	 * @param pAuthenticationManagerBuilder
	 */
	@Override
	protected void configure (AuthenticationManagerBuilder pAuthenticationManagerBuilder) throws Exception {
		
		pAuthenticationManagerBuilder.inMemoryAuthentication().withUser("admin").password("1234").roles("ADMIN", "USER");
		pAuthenticationManagerBuilder.inMemoryAuthentication().withUser("user").password("1234").roles("USER");
	}
	
	/**
	 * <b>METHODE QUI DEFINIT :
	 * <br/>Les URL HTTP accessibles pour chaque role d'utilisateur.
	 * <br/>Les URL HTTP relatives à l'authentification.
	 * 
	 * @param pHttpSecurity
	 */
	@Override
	protected void configure (HttpSecurity pHttpSecurity) throws Exception {
		
		pHttpSecurity.formLogin().permitAll();
		pHttpSecurity.formLogin().loginPage("/identifier");
		pHttpSecurity.formLogin().loginProcessingUrl("/validerIdentification");
		pHttpSecurity.formLogin().defaultSuccessUrl("/personne/gererPersonnes");
		pHttpSecurity.formLogin().failureUrl("/refuserAcces");
		
		pHttpSecurity.logout().logoutUrl("/deconnecter");
		pHttpSecurity.logout().logoutSuccessUrl("/identifier");
		
		pHttpSecurity.authorizeRequests().antMatchers("/personne/entrer").hasRole("ADMIN");
		pHttpSecurity.authorizeRequests().antMatchers("/personne/gererPersonnes").hasRole("ADMIN");
		pHttpSecurity.authorizeRequests().antMatchers("/personne").hasRole("ADMIN");
		pHttpSecurity.authorizeRequests().antMatchers("/candidature").hasRole("ADMIN");
		pHttpSecurity.authorizeRequests().antMatchers("/curriculum").hasRole("ADMIN");

		
		pHttpSecurity.exceptionHandling().accessDeniedPage("/refuserAcces");
		
		
		
		
	}
}
