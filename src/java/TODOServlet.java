
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/TODO.html"})
public class TODOServlet extends HttpServlet {

    private static List<String> todos = new ArrayList<String>() {
        {
            add("Estudar Java");
            add("Estudar HTML");
            add("Profit!");
        }
    };

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>TODOs</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>TODOs</h1>");
        out.println("<form action='post'>");
        out.println("<label>Atividade: <input name='atividade' /></label>");
        out.println("<input type='submit'>");
        out.println("<input type='reset'>");
        out.println("</form>");
        out.println("<ul>");
        for (String todo : todos) {
            out.println("<li>" + todo + "</li>");
        }

        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String atividade = request.getParameter("atividade");
        todos.add(atividade);
        doGet(request, response);
        
 }
    
    

}
