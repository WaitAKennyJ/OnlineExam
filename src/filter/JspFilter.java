package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kennywzj on 2018/7/1.
 */
@WebFilter(filterName = "JspFilter")
public class JspFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String url = httpServletRequest.getRequestURI();
        if (url != null && url.endsWith(".jsp")) {
            // TODO 这里可以跳转到主页
            String contextPath = httpServletRequest.getContextPath();
            httpServletResponse.sendRedirect(contextPath + "/user/index.do");
            return;
        }
        chain.doFilter(httpServletRequest, httpServletResponse);

    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }


}
