package Servlet.Filter;

import Mo.Member;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class UserFilter implements Filter {
    //存放会员的url集合
    private List<String> members;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 1.强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // 2.操作

        // 判断当前资源是否需要权限控制.
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String path = uri.substring(contextPath.length());

        if (members.contains(path)) {

            // 判断用户是否登录了.
            Member member = (Member) request.getSession().getAttribute("user");

            if (member == null) {
                response.sendRedirect(request.getContextPath()+"/privilegeException.jsp");
                return;
            }
            // 判断用户的角色，是否可以访问当前资源路径。
                // 这是user角色
                if (!(members.contains(path))) {
                    response.sendRedirect(request.getContextPath()+"/privilegeException.jsp");
                    return;
                }
            }

        // 3.放行

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        this.members = new ArrayList<String>();

        fillPath("user", members);

    }

    private void fillPath(String baseName, List<String> list) {

        ResourceBundle bundle = ResourceBundle.getBundle(baseName);

        String path = bundle.getString("url");

        String[] paths = path.split(",");

        for (String p : paths) {
            list.add(p);
        }

    }

}
