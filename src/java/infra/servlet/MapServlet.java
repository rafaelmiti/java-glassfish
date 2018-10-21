
package infra.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MapServlet", urlPatterns = {"/map"})
public class MapServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JsonObject json;
        PrintWriter out = response.getWriter();
        Map<String,Integer> map = new HashMap();
        
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
        
            JsonObjectBuilder builder = Json.createObjectBuilder();
            
            map.put("Foo", 1);
            map.put("Bar", 2);
            map.put("Baz", 3);
            
            map.entrySet().forEach((entry) -> {
                builder.add(entry.getKey(), entry.getValue());
            });

            json = builder.build();
            
            out.print(json.toString());
        } catch (Exception e) {
            json = Json.createObjectBuilder().add("exception", e.getMessage()).build();
            out.print(json.toString());
        }
    }
}
