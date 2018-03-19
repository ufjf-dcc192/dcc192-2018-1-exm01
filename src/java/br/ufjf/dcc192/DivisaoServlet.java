package br.ufjf.dcc192;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DivisaoServlet", urlPatterns = {"/divisao.html"})
public class DivisaoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Divisão</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Divisão</h1>");
        out.println("<form method='post'>");
        out.println("<label>X: <input name='X' /></label>");
        out.println("<label>Y: <input name='Y' /></label>");
        out.println("<input type='submit' />");
        out.println("<input type='reset' />");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Integer X = Integer.valueOf(request.getParameter("X"));
            Integer Y = Integer.valueOf(request.getParameter("Y"));
            Integer D = X / Y;

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Divisão</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Divisão</h1>");
            out.println("<p>A divisão de X:"
                    + X + " por Y:"
                    + Y + " é "
                    + D + ".</p>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } catch (NumberFormatException | ArithmeticException e) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Divisão: Erro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Divisão: Erro</h1>");
            out.println("<p>Você deve passar X e Y. E Y deve ser diferente de 0!</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
