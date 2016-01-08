package tiscon1.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import tiscon1.model.UserPrincipal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author kawasima
 */
public class PrincipalInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession(false);

        if (session != null) {
            UserPrincipal principal = (UserPrincipal) session.getAttribute("principal");
            if (principal != null) {
                httpServletRequest.setAttribute("principal", principal);
            }
        }

        return true;
    }
}
