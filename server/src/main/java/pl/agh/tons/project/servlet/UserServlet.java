package pl.agh.tons.project.servlet;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.slf4j.Logger;
import pl.agh.tons.project.model.User;
import pl.agh.tons.project.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by psk on 10.04.16.
 */
@Singleton
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(UserServlet.class);

    private UserService userService;

    @Inject
    public UserServlet(UserService userService) {
        this.userService = userService;
    }

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException {

        String json = null;

        if ("/member".equalsIgnoreCase(request.getServletPath())) {
            json = userService.showUsers();
        } else if ("/member/loans".equalsIgnoreCase(request.getServletPath())) {
            User testUser = new User("Peter", "Tester", "admin@admin.pl", "admin");
            testUser.setId(1);
            json = userService.showLoans(testUser);
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

}
