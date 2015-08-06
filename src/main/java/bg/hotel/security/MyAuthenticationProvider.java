package bg.hotel.security;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import bg.hotel.entities.User;
import bg.hotel.services.UserService;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	@Autowired
    private ApplicationContext applicationContext;
    
    private UserService userService;
    
    @PostConstruct
    private void init() {
    	userService = applicationContext.getBean(UserService.class);
    }
	
    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        Authentication res = isValid(authentication);
        if (!res.isAuthenticated()) {
            throw new BadCredentialsException("Bad credentials");
        }
        return res;
    }

    private Authentication isValid(final Authentication authentication) {
        Authentication res = authentication;
        User user = userService.findUserByUsernameAndPassword((String)authentication.getPrincipal(), (String)authentication.getCredentials());
        if (user != null) {
            res = createSuccessAuthentication(user, res);
        }
        return res;
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    protected Authentication createSuccessAuthentication(final User user, final Authentication authentication) {
        // Ensure we return the original credentials the user supplied,
        // so subsequent attempts are successful even with encoded passwords.
        // Also ensure we return the original getDetails(), so that future
        // authentication events after cache expiry contain the details
        final UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), authentication.getAuthorities());
        result.setDetails(user.getUserRole());

        return result;
    }

}
