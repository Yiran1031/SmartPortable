
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;


@WebServlet("/DeleteProduct")

public class DeleteProduct extends HttpServlet{
    private String error_msg;
    private String add_msg;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        displayadd(request, response, pw, false);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        //XWrite write = new XWrite();
        String id = request.getParameter("id");
        String type = request.getParameter("type");
        try{
            //write.createXML(request,response);
            System.out.println(id);
            MySqlDataStoreUtilities.deleteProduct(id,type);
        }catch (Exception e ){

        }
        HttpSession session = request.getSession(true);
        session.setAttribute("add_msg", "delete complete");
        displayadd(request, response, pw, true);
    }



    protected void displayadd(HttpServletRequest request,
                                       HttpServletResponse response, PrintWriter pw, boolean error)
            throws ServletException, IOException {
        Utilities utility = new Utilities(request, pw);
        utility.printHtml("Header.html");
        utility.printHtml("ManageLeftBar.html");
        pw.print("<div class='post' style='float: none; width: 100%'>");
        pw.print("<h2 class='title meta'><a style='font-size: 24px;'>Add Product</a></h2>"
                + "<div class='entry'>"
                + "<div style='width:500px; margin:25px; margin-left: auto;margin-right: auto;'>");
        if (error)
            pw.print("<h4 style='color:red'>"+error_msg+"</h4>");
        HttpSession session = request.getSession(true);
        if(session.getAttribute("add_msg")!=null){
            pw.print("<h4 style='color:red'>"+session.getAttribute("add_msg")+"</h4>");
            session.removeAttribute("add_msg");
        }
        pw.print("<form method='post' action='DeleteProduct'>"
                + "<table style='width:100%'><tr><td>"
                + "<h3>id</h3></td><td></td><td><input type='text' name='id' value='' class='input' required></input>"
                + "</td></tr><tr><td>"
                + "</td><td></td><td><select name='type' class='input'>"
                + "<option value='SmartWatches' selected>Smart Watches</option>"
                + "<option value='FitnessWatches' selected>Fitness Watches</option> "
                + "<option value='Headphones' selected>Headphones</option>"
                + "<option value='VirtualReality' selected>Virtual Reality</option>"
                + "<option value='PetTracker' selected>Pet Tracker</option>"
                + "<option value='Phone'>Phone</option><option value='Laptops'>Laptops</option><option value='VoiceAssistant' selected>VoiceAssistant</option></select>"
                + "</td></tr></table>"
                + "<input type='submit' class='btnbuy' name='ByUser' value='delete' style='float: right;height: 20px margin: 20px; margin-right: 10px;'></input>"
                + "</form>" + "</div></div></div>");
        utility.printHtml("Footer.html");
    }
}
