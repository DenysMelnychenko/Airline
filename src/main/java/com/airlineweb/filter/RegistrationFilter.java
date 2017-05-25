package com.airlineweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.airlineweb.servlet.Dashboard;
import com.airlineweb.util.RegistrationCheker;

@WebFilter("/registration")
public class RegistrationFilter implements Filter {

	private final static Logger logger = Logger.getLogger(RegistrationFilter.class);

	private static final String REG_JSP_PATH = "/registrationForm.jsp";
	private static final String POST = "post";
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";
	private static final String REPEAT_PASSWORD = "repeatPassword";
	private static final String EMAIL_VALIDATION_ERROR = "There was a mistake when entering email";
	private static final String PASSWORD_TO_SHORT = "Password is too short. Minimum 5 symbols";
	private static final String PASSWORD_TO_LONG = "Password is too long. Maximum is 25 symbols";
	private static final String PASSWORD_MISMATCH = "Password do not match";

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;

		if (httpRequest.getMethod().equals(POST)) {

			String email = request.getParameter(EMAIL);
			String password = request.getParameter(PASSWORD);
			String repeatPassword = request.getParameter(REPEAT_PASSWORD);

			if (RegistrationCheker.isRegistrationValid(email, password, repeatPassword)) {

				chain.doFilter(request, response);

			} else if (RegistrationCheker.isEmailValid(email) == false) {

				request.setAttribute("emailValidationError", EMAIL_VALIDATION_ERROR);

			} else if (RegistrationCheker.isPasswordlValid(password) == false) {

				if (password.length() < 5) {

					request.setAttribute("passwordToShort", PASSWORD_TO_SHORT);

				} else {

					request.setAttribute("passwordToLong", PASSWORD_TO_LONG);
				}

			} else if (RegistrationCheker.isRepeatPasswordValid(password, repeatPassword) == false) {

				if (repeatPassword.length() < 5) {

					request.setAttribute("passwordToShort", PASSWORD_TO_SHORT);

				} else if (repeatPassword.length() > 25) {

					request.setAttribute("passwordToLong", PASSWORD_TO_LONG);

				} else if (!repeatPassword.equals(password)) {
					request.setAttribute("passwordMismatch", PASSWORD_MISMATCH);
				}
			}

			request.getRequestDispatcher(REG_JSP_PATH).forward(request, response);

		}
		
		logger.debug("Filter pass request throгgh");
		
		chain.doFilter(request, response);

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
