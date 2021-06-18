package com.injavawetrust.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/*
 * A custom AuthenticationEntryPoint can be used
 * to set necessary response headers, content-type, and so on before sending the
 * response back to the client
 * 
 */

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

	/*
	 * https://subscription.packtpub.com/book/application_development/9781788995979/4/ch04lvl1sec36/custom-authenticationentrypoint
	 * https://www.baeldung.com/spring-security-basic-authentication
	 */
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
			throws IOException {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter writer = response.getWriter();
		writer.println("HTTP Status 401 - AuthenticationEntryPointImpl#commence " + authEx.getMessage());
	}

}
