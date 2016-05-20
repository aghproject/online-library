package pl.agh.tons.project.servlet;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * Created by psk on 15.05.16.
 */
public interface WebProtocol {

    /**
     * Prepare JSON response from server
     * @return  JSON string
     */
    String prepareResponse(Response response);

    /**
     * Get http request, translate json and put it into map
     * @param request   HttpServletRequest
     * @return  return json key-value pairs as a map
     */
    Map<String, Object> prepareRequest(HttpServletRequest request) throws IOException;
}
