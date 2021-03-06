package pl.agh.tons.project.servlet;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.slf4j.Logger;
import pl.agh.tons.project.service.LoanService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by psk on 26.05.16.
 */
@Singleton
public class CategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(CategoryServlet.class);

    private LoanService loanService;
    private WebProtocol webProtocol;

    @Inject
    public CategoryServlet(LoanService loanService, WebProtocol webProtocol) {
        this.loanService = loanService;
        this.webProtocol = webProtocol;
    }

    protected void doGet(HttpServletRequest httpRequest, HttpServletResponse httpResponse)
            throws IOException, ServletException {

        httpResponse.setContentType("application/json");
        httpResponse.setCharacterEncoding("UTF-8");

    }
}
