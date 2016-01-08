package tiscon1.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * A interceptor for authorization.
 *
 * @author kawasima
 */
public class AuthzInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        if (handler instanceof Method) {
            Method m = (Method) handler;
            PermitAll permitAll = m.getAnnotation(PermitAll.class);
            DenyAll denyAll = m.getAnnotation(DenyAll.class);
            RolesAllowed rolesAllowed = m.getAnnotation(RolesAllowed.class);

            if (permitAll != null) {
                return true;
            } else if (denyAll != null) {
                return false;
            } else if (rolesAllowed != null) {
                return true;
            } else {
                // TODO process Class-level annotation
            }
        }

        return true;
    }
}
