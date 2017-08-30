package com.itss.vn.resource.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

@EnableResourceServer
@Order(3)
@Configuration
public class ResourceServer extends ResourceServerConfigurerAdapter{
	
	@Value("${oauth2.admin.resourceId}")
	private String resourceId;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.addFilterAfter(new TokenFilter(), AbstractPreAuthenticatedProcessingFilter.class);
		http.authorizeRequests()
			.antMatchers("/image/find/").authenticated()
			.anyRequest().permitAll()
			.and().csrf().disable();
	}
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(resourceId);
	}
}
