package bg.hotel.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import bg.hotel.entities.UserRole;

@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
	@Override
	public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Authentication authentication) throws IOException, ServletException {
		String url = determineTargetUrl(authentication);
		if (authentication != null && authentication.getDetails() != null) {
			try {
				httpServletRequest.getSession().invalidate();
				// you can add more codes here when the user successfully logs
				// out,
				// such as updating the database for last active.
			} catch (Exception e) {
				e.printStackTrace();
				e = null;
			}
		}
		
		httpServletResponse.setStatus(HttpServletResponse.SC_OK);
		// redirect to login
		httpServletResponse.sendRedirect(url);
	}
	
	/**
	 * Builds the target URL according to the logic defined in the main class
	 * Javadoc.
	 */
	protected String determineTargetUrl(Authentication authentication) {
		
		UserRole userRole = (UserRole)authentication.getDetails();
		if(UserRole.ADMIN_ROLE.equals(userRole.getRole()) || UserRole.RECEPTION_ROLE.equals(userRole.getRole())){
			return "/login.xhtml";
		} else {
			return "/login.xhtml?error=2";
		}

	}
}
