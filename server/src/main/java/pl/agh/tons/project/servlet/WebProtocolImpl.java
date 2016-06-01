package pl.agh.tons.project.servlet;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * Created by psk on 15.05.16.
 */
public class WebProtocolImpl implements WebProtocol {

    private Gson gson = new Gson();

    private Response response;

    @Override
    public String prepareResponse(Response response) {
        return gson.toJson(response);
    }

    @Override
    public Map<String, Object> prepareRequest(HttpServletRequest request) throws IOException {
        return gson.fromJson(request.getReader(), Map.class);
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
