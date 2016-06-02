package pl.agh.tons.project.servlet;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.agh.tons.project.model.User;
import pl.agh.tons.project.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by psk on 16.05.16.
 */
@Singleton
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = LoggerFactory.getLogger(LoginServlet.class);

    private UserService userService;
    private WebProtocol webProtocol;

    @Inject
    public LoginServlet(UserService userService, WebProtocol webProtocol) {
        LOG.debug("Create login servlet...");

        this.userService = userService;
        this.webProtocol = webProtocol;
    }

    protected void doPost(HttpServletRequest httpRequest, HttpServletResponse httpResponse)
            throws IOException, ServletException {

        Map<String, Object> requestMap = webProtocol.prepareRequest(httpRequest);

        httpResponse.setContentType("application/json");
        httpResponse.setCharacterEncoding("UTF-8");

        String email = (String) requestMap.get("email");
        String password = (String) requestMap.get("password");

        User user = userService.getByEmailAndPassword(email, password);

        Response<User> response = new Response(user);
        if (user != null) {
            response.setMsg("Witamy!");
            response.setSuccess(true);
        } else {
            response.setMsg("Nieprawidlowe dane uzytkownika!");
        }

        httpResponse.getWriter().write(webProtocol.prepareResponse(response));
    }
}
