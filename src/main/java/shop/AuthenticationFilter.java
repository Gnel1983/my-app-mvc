package shop;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        User user = (User) (((HttpServletRequest) request).getSession().getAttribute("userAttribute"));
        if (user != null) {
            filterChain.doFilter(request,response);
        } else {
            ((HttpServletResponse)response).sendRedirect("/login");
        }


    }


}
