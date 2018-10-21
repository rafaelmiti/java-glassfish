
package infra.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListServlet", urlPatterns = {"/list"})
public class ListServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JsonObject json;
        PrintWriter out = response.getWriter();
        List<String> list = new ArrayList();
        
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
        
            JsonObjectBuilder builder = Json.createObjectBuilder();
            
            list.add("Foo");
            list.add("Bar");
            list.add("Baz");
            list.add("Vux");
            
            list.forEach((item) -> {
                builder.add(item, 1);
            });

            json = builder.build();
            out.print(json.toString());
        } catch (Exception e) {
            json = Json.createObjectBuilder().add("exception", e.getMessage()).build();
            out.print(json.toString());
        }
    }
}
