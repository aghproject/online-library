package pl.agh.tons.project.servlet;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.slf4j.Logger;
import pl.agh.tons.project.service.ReservationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by pskurski on 6/1/2016.
 */
@Singleton
public class ReservationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(ReservationServlet.class);

    private ReservationService reservationService;
    private WebProtocol webProtocol;

    @Inject
    public ReservationServlet(ReservationService reservationService, WebProtocol webProtocol) {
        this.reservationService = reservationService;
        this.webProtocol = webProtocol;
    }

    protected void doPost(HttpServletRequest httpRequest, HttpServletResponse httpResponse)
            throws IOException, ServletException {

        Map<String, Object> requestMap = webProtocol.prepareRequest(httpRequest);

        httpResponse.setContentType("application/json");
        httpResponse.setCharacterEncoding("UTF-8");

        int bookId = Integer.valueOf((String) requestMap.get("bookId"));
        int userId = ((Double) requestMap.get("userId")).intValue();

        reservationService.reserveBook(userId, bookId);

        Response response = new Response();
        response.setSuccess(true);
        response.setMsg("Rezerwacja na ksiazke zostala przyjeta!");

        httpResponse.getWriter().write(webProtocol.prepareResponse(response));
    }
}
