package pl.agh.tons.project.servlet;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.slf4j.Logger;
import pl.agh.tons.project.model.Loan;
import pl.agh.tons.project.model.User;
import pl.agh.tons.project.service.LoanService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by psk on 20.05.16.
 */
@Singleton
public class LoanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(LoanServlet.class);

    private LoanService loanService;
    private WebProtocol webProtocol;

    @Inject
    public LoanServlet(LoanService loanService, WebProtocol webProtocol) {
        this.loanService = loanService;
        this.webProtocol = webProtocol;
    }

    protected void doGet(HttpServletRequest httpRequest, HttpServletResponse httpResponse)
                                                        throws IOException, ServletException {

        httpResponse.setContentType("application/json");
        httpResponse.setCharacterEncoding("UTF-8");

        List<Loan> loans = loanService.getLoans(Integer.valueOf(httpRequest.getParameter("id")));

        Response<User> response = new Response(loans);
        httpResponse.getWriter().write(webProtocol.prepareResponse(response));
    }

    protected void doPost(HttpServletRequest httpRequest, HttpServletResponse httpResponse)
                                                        throws IOException, ServletException {


    }
}

