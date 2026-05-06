import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.exampleforsb.demo.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 1. 获取请求路径
        String requestURI = request.getRequestURI(); // /employee/login

        // 2. 判断是否是登录请求，如果包含 /login，直接放行
        if (requestURI.contains("/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 3. 获取请求头中的 token
        String token = request.getHeader("token");

        token = token.substring(7); // 去掉 "Bearer "

        try {
            // 3. 验证 token
            Claims claims = JwtUtil.parseToken(token);

            String username = claims.getSubject();

            // 可以把用户信息存起来（后面Controller用）
            request.setAttribute("username", username);

        } catch (Exception e) {
            response.setStatus(401);
            response.getWriter().write("INVALID TOKEN");
            return;
        }

        // 5. 校验 token
        if (!"123456".equals(token)) {
            response.setStatus(401);
            response.getWriter().write("INVALID TOKEN");
            return;
        }

        // 6. token 合法，放行
        filterChain.doFilter(request, response);
    }
}