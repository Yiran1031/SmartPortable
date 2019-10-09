
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













@WebServlet("/SalesUpdate")

public class SalesUpdate extends HttpServlet{
    private String error_msg;
    private String add_msg;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        displayorder(request, response, pw, false);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String oid = request.getParameter("orderId");
        String ona = request.getParameter("orderName");
        String pr = request.getParameter("price");
        String una = request.getParameter("userName");
        String add = request.getParameter("address");
        String card = request.getParameter("cardNo");
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        MySqlDataStoreUtilities.UpdateOrder(Integer.parseInt(oid),una,ona,Double.parseDouble(pr),add,card);
        HttpSession session = request.getSession(true);
        session.setAttribute("add_msg", "add complete");
        displayorder(request, response, pw, true);
    }



    protected void displayorder(HttpServletRequest request,
                                       HttpServletResponse response, PrintWriter pw, boolean error)
            throws ServletException, IOException {
        String oid = request.getParameter("orderId");
        String ona = request.getParameter("orderName");
        String pr = request.getParameter("price");
        String una = request.getParameter("userName");
        String add = request.getParameter("address");
        String card = request.getParameter("cardNo");
        Utilities utility = new Utilities(request, pw);
        utility.printHtml("Header.html");
        utility.printHtml("SaleNavigation.html");
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
        pw.print("<form method='post' action='SalesUpdate'>"
                + "<table style='width:100%'><tr><td>"
                + "<h3>orderId</h3></td><td></td><td><input type='text' name='orderId' value='"+oid+"' class='input' required readonly=\"readonly\"></input>"
                + "</td></tr><tr><td>"
                + "<h3>orderName</h3></td><td></td><td><input type='text' name='orderName' value='"+ona+"' class='input' required readonly=\"readonly\"></input>"
                + "</td></tr><tr><td>"
                + "<h3>price</h3></td><td></td><td><input type='text' name='price' value='"+pr+"' class='input' required readonly=\"readonly\"></input>"
                + "</td></tr><tr><td>"
                + "<h3>userName</h3></td><td></td><td><input type='text' name='userName' value='"+una+"' class='input' required></input>"
                + "</td></tr><tr><td>"
                + "<h3>address</h3></td><td></td><td><input type='text' name='address' value='"+add+"' class='input' required></input>"
                + "</td></tr><tr><td>"
                + "<h3>cardNo</h3></td><td></td><td><input type='text' name='cardNo' value='"+card+"' class='input' required></input>"
                + "</td></tr><tr><td>"
                + "</table>"
                + "<input type='submit' class='btnbuy' name='ByUser' value='submit' style='float: right;height: 20px margin: 20px; margin-right: 10px;'></input>"
                + "</form>" + "</div></div></div>");
        utility.printHtml("Footer.html");
    }
}
