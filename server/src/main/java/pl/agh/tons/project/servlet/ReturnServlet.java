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
import java.util.Map;

/**
 * Created by psk on 31.05.16.
 */
@Singleton
public class ReturnServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(LoanServlet.class);

    private LoanService loanService;
    private WebProtocol webProtocol;

    @Inject
    public ReturnServlet(LoanService loanService, WebProtocol webProtocol) {
        this.loanService = loanService;
        this.webProtocol = webProtocol;
    }

    protected void doPost(HttpServletRequest httpRequest, HttpServletResponse httpResponse)
            throws IOException, ServletException {

        Map<String, Object> requestMap = webProtocol.prepareRequest(httpRequest);

        httpResponse.setContentType("application/json");
        httpResponse.setCharacterEncoding("UTF-8");

        int bookId = Integer.valueOf((String) requestMap.get("copyId"));
        int userId = ((Double) requestMap.get("userId")).intValue();

        loanService.returnBook(bookId, userId);

        Response<User> response = new Response(new String("Ksiazka zostala zwrocona!"));
        httpResponse.getWriter().write(webProtocol.prepareResponse(response));
    }
}
