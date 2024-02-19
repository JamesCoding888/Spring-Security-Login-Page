package j2ee.filter;

import javax.servlet.*;
import java.io.IOException;

public class CustomFilter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code if needed
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("CustomFilter1 is executing");
        // Continue the filter chain
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        // Cleanup code if needed
    }
}


