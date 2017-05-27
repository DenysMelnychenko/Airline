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

import com.airlineweb.message.Message;
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
	private static final String PASSWORD_TO_SHORT = "passwordToShort";
	private static final String REPEAT_PASSWORD_TO_SHORT = "repeatPasswordToShort";
	private static final String PASSWORD_TO_SHORT_MESSAGE = "Password is too short. Minimum 5 symbols";
	private static final String PASSWORD_TO_LONG = "passwordToLong";
	private static final String REPEAT_PASSWORD_TO_LONG = "repeatPasswordToLong";
	private static final String PASSWORD_TO_LONG_MESSAGE = "Password is too long. Maximum is 25 symbols";
	private static final String PASSWORD_MISMATCH = "passwordsMismatch";
	private static final String PASSWORD_MISMATCH_MESSAGE = "Passwords do not match";
	private static final String EMAIL_VALIDATION_ERROR_MESSAGE = "There was a mistake when entering email";
	private static final String EMAIL_VALIDATION_ERROR = "emailValidationError";

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;

		if (httpRequest.getMethod().equalsIgnoreCase(POST)) {

			String email = request.getParameter(EMAIL);
			String password = request.getParameter(PASSWORD);
			String repeatPassword = request.getParameter(REPEAT_PASSWORD);

			if (RegistrationCheker.isRegistrationValid(email, password, repeatPassword)) {

				chain.doFilter(request, response);

			}
			if (RegistrationCheker.isEmailValid(email) == false) {

				request.setAttribute(EMAIL_VALIDATION_ERROR, EMAIL_VALIDATION_ERROR_MESSAGE);
				logger.debug("The attribute " + EMAIL_VALIDATION_ERROR + " was specified with value - "
						+ EMAIL_VALIDATION_ERROR_MESSAGE);
			}

			if (!RegistrationCheker.isPasswordlValid(password)) {

				if (password.length() < 5) {

					request.setAttribute(PASSWORD_TO_SHORT, PASSWORD_TO_SHORT_MESSAGE);
				}
				if (password.length() > 25) {

					request.setAttribute(PASSWORD_TO_LONG, PASSWORD_TO_LONG_MESSAGE);
				}
			}

			if (!RegistrationCheker.isRepeatPasswordValid(password, repeatPassword)) {

				if (repeatPassword.length() < 5) {

					request.setAttribute(REPEAT_PASSWORD_TO_SHORT, PASSWORD_TO_SHORT_MESSAGE);
				}

				if (repeatPassword.length() > 25) {

					request.setAttribute(REPEAT_PASSWORD_TO_LONG, PASSWORD_TO_LONG_MESSAGE);
				}

				if (!repeatPassword.equals(password)) {
					request.setAttribute(PASSWORD_MISMATCH, PASSWORD_MISMATCH_MESSAGE);
				}
			}

			request.getRequestDispatcher(REG_JSP_PATH).forward(request, response);
		}

		logger.debug("Filter pass request throгgh ");

		chain.doFilter(request, response);

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
