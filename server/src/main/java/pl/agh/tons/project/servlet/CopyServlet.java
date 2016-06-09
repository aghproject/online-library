package pl.agh.tons.project.servlet;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.slf4j.Logger;
import pl.agh.tons.project.model.Copy;
import pl.agh.tons.project.service.CopyService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by psk on 30.05.16.
 */
@Singleton
public class CopyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(CopyServlet.class);

    private CopyService copyService;
    private WebProtocol webProtocol;

    @Inject
    public CopyServlet(CopyService copyService, WebProtocol webProtocol) {
        this.copyService = copyService;
        this.webProtocol = webProtocol;
    }

    protected void doGet(HttpServletRequest httpRequest, HttpServletResponse httpResponse)
            throws IOException, ServletException {

        httpResponse.setContentType("application/json");
        httpResponse.setCharacterEncoding("UTF-8");

        List<Copy> copies = copyService.getAllNotRentedBooks();

        Response<Copy> response = new Response(copies);
        response.setMsg("Wszystkie kopie ksiazek dostepne do wypozyczenia.");
        response.setSuccess(true);
        httpResponse.getWriter().write(webProtocol.prepareResponse(response));
    }

    protected void doPost(HttpServletRequest httpRequest, HttpServletResponse httpResponse)
            throws IOException, ServletException {


    }
}
