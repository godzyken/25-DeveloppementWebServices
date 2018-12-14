/**
 * 
 */
package fr.tacticrh.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author franck Taba Taba
 *
 * <b>CLASSE QUI IMPLEMENTE LA CONFIGURATION DES MESSAGES DE LA SERVLET PRINCIPALE DE L'APPLICATION.</b>
 */
@Configuration
public class MessageWebMvcConfigurerAdapter implements WebMvcConfigurer {
	
	
	
	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b>
	 * <br/>Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageWebMvcConfigurerAdapter.class);

	
	
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		
		LOGGER.info("CLASS : MessageWebMvcConfigurerAdapter -- METHOD : configureMessageConverters -- BEGIN");

	    // http
	    HttpMessageConverter converter = new StringHttpMessageConverter();
	    converters.add(converter);
	    LOGGER.info("HttpMessageConverter added");

	    // string
	    converter = new FormHttpMessageConverter();
	    converters.add(converter);
	    LOGGER.info("FormHttpMessageConverter added");

	    // json
	    converter = new MappingJackson2HttpMessageConverter();
	    converters.add(converter);
	    LOGGER.info("MappingJackson2HttpMessageConverter added");
	    
		LOGGER.info("CLASS : MessageWebMvcConfigurerAdapter -- METHOD : configureMessageConverters -- END");
	}
}
