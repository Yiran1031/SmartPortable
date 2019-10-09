
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

@WebServlet("/ProductUpdate")

public class ProductUpdate extends HttpServlet{
    private String error_msg;
    private String add_msg;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        displayorder(request, response, pw, false);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String type = request.getParameter("type");
        String cond = request.getParameter("cond");
        String discount = request.getParameter("discount");
        String num = request.getParameter("num");
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        MySqlDataStoreUtilities.UpdateProduct(id,name,Double.parseDouble(price),type,cond,Double.parseDouble(discount),Integer.parseInt(num));
        HttpSession session = request.getSession(true);
        session.setAttribute("add_msg", "add complete");
        displayorder(request, response, pw, true);
    }



    protected void displayorder(HttpServletRequest request,
                                       HttpServletResponse response, PrintWriter pw, boolean error)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String type = request.getParameter("type");
        String cond = request.getParameter("cond");
        String discount = request.getParameter("discount");
        String num = request.getParameter("num");
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
        pw.print("<form method='post' action='ProductUpdate'>"
                + "<table style='width:100%'><tr><td>"
                + "<h3>id</h3></td><td></td><td><input type='text' name='id' value='"+id+"' class='input' required readonly=\"readonly\"></input>"
                + "</td></tr><tr><td>"
                + "<h3>name</h3></td><td></td><td><input type='text' name='name' value='"+name+"' class='input' required></input>"
                + "</td></tr><tr><td>"
                + "<h3>price</h3></td><td></td><td><input type='text' name='price' value='"+price+"' class='input' required ></input>"
                + "</td></tr><tr><td>"
                + "<h3>type</h3></td><td></td><td><input type='text' name='type' value='"+type+"' class='input' required></input>"
                + "</td></tr><tr><td>"
                + "<h3>condition</h3></td><td></td><td><input type='text' name='cond' value='"+cond+"' class='input' required></input>"
                + "</td></tr><tr><td>"
                + "<h3>discount</h3></td><td></td><td><input type='text' name='discount' value='"+discount+"' class='input' required></input>"
                + "</td></tr><tr><td>"
                + "<h3>Store number</h3></td><td></td><td><input type='text' name='num' value='"+num+"' class='input' required></input>"
                + "</td></tr><tr><td>"
                + "</table>"
                + "<input type='submit' class='btnbuy' name='ByUser' value='submit' style='float: right;height: 20px margin: 20px; margin-right: 10px;'></input>"
                + "</form>" + "</div></div></div>");
        utility.printHtml("Footer.html");
    }
}
