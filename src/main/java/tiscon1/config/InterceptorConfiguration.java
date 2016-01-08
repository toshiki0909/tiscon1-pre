package tiscon1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import tiscon1.interceptor.AuthnInterceptor;
import tiscon1.interceptor.AuthzInterceptor;
import tiscon1.interceptor.PrincipalInterceptor;

/**
 * @author kawasima
 */
@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PrincipalInterceptor());
        registry.addInterceptor(new AuthnInterceptor())
                .addPathPatterns("/my/*");
        registry.addInterceptor(new AuthzInterceptor())
                .addPathPatterns("/my/*");
    }
}
