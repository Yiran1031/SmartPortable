import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/Cart")
public class Cart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        Utilities utility = new Utilities(request, pw);
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String product = request.getParameter("product");
        String access = request.getParameter("access");

        utility.storeProduct(name, type, product, access);
        displayCart(request,response);
    }
    protected void displayCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        Utilities utility = new Utilities(request,pw);
        String type = request.getParameter("type");
        Carousel carousel = new Carousel();
        // if user have not log yet, redirect to log page
        if(!utility.isLoggedin()){
            HttpSession session = request.getSession(true);
            session.setAttribute("login_msg", "Please Login to add items to cart");
            response.sendRedirect("LoginServlet");
            return;
        }

        utility.printHtml("Header.html");
        utility.printHtml("LeftNavigationBar.html");
        pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
        pw.print("<a style='font-size: 24px;'>Cart("+utility.CartCount()+")</a>");
        pw.print("</h2><div class='entry'>");
        pw.print("<form name ='Cart' action='CheckOut' method='post'>");
        if(utility.CartCount()>0)
        {
            pw.print("<table  class='gridtable'>");
            int i = 1;
            double total = 0;
            for (OrderItem oi : utility.getCustomerOrders())
            {
                pw.print("<tr>");
                pw.print("<td>"+i+".</td><td>"+oi.getName()+"</td><td>: "+oi.getPrice()+"</td>");
                pw.print("<input type='hidden' name='orderName' value='"+oi.getName()+"'>");
                pw.print("<input type='hidden' name='orderPrice' value='"+oi.getPrice()+"'>");
                pw.print("<input type='hidden' name='type' value='"+type+"'>");
                pw.print("</tr>");
                total = total +oi.getPrice();
              //  MySqlDataStoreUtilities.updateNumber(type,oi.getName(),MySqlDataStoreUtilities.getNumber(type,oi.getName())-1);
                i++;
            }
            pw.print("<input type='hidden' name='orderTotal' value='"+total+"'>");
            pw.print("<tr><th></th><th>Total</th><th>"+total+"</th>");
            pw.print("<tr><td></td><td></td><td><input type='submit' name='CheckOut' value='CheckOut' class='btnbuy' /></td>");
            pw.print("</table></form>");
            pw.print(carousel.carouselfeature(utility));

        }
        else
        {
            pw.print("<h4 style='color:red'>Your Cart is empty</h4>");
        }
        pw.print("</div></div></div>");
        utility.printHtml("Footer.html");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        Utilities utility = new Utilities(request, pw);

        displayCart(request, response);
    }

}
