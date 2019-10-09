import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogOut")

public class LogOut extends HttpServlet{
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
    {
        Utilities utility = new Utilities(request, null);
        HttpSession session = request.getSession(true);
        session.removeAttribute("username");
        session.removeAttribute("usertype");
        response.sendRedirect("Home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request,response);
    }
}
