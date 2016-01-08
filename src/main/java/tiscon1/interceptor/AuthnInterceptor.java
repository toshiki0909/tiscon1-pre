package tiscon1.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import tiscon1.model.UserPrincipal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A interceptor for authentication.
 *
 * @author kawasima
 */
public class AuthnInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        UserPrincipal principal = (UserPrincipal) httpServletRequest.getAttribute("principal");
        if (principal == null) {
            httpServletResponse.setStatus(401);
            return false;
        }
        return true;
    }
}
