package yukinarisoftware.wf.Filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginFilterSession extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (request.getRequestURI().equals("/session/login")) {
            chain.doFilter(request, response);
        } else {
            HttpSession session = request.getSession(true);
            String username = (String) session.getAttribute("username");

            if (username == null) {
                response.setStatus(401);
                response.getWriter().println("you must login first");
            } else {
                chain.doFilter(request, response);
            }
        }
    }
}
