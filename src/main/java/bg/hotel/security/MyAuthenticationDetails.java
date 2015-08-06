package bg.hotel.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class MyAuthenticationDetails extends WebAuthenticationDetails {

	private static final long serialVersionUID = 1L;

    public MyAuthenticationDetails(final HttpServletRequest request) {
        super(request);
    }
}
