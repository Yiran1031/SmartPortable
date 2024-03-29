import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

@WebServlet("/CheckOut")

public class CheckOut extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        Utilities Utility = new Utilities(request, pw);
        storeOrders(request, response);
    }
    protected void storeOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
          String type = request.getParameter("type");
        try{
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            Utilities utility = new Utilities(request,pw);
//check if user has logged in
            if(!utility.isLoggedin())
            {
                HttpSession session = request.getSession(true);
                session.setAttribute("login_msg", "Please Login");
                response.sendRedirect("LoginServlet");
                return;
            }

            HttpSession session=request.getSession();

            String userName = session.getAttribute("username").toString();
            String orderTotal = request.getParameter("orderTotal");
            utility.printHtml("Header.html");
            utility.printHtml("LeftNavigationBar.html");
            pw.print("<form name ='CheckOut' action='Payment' method='post'>");
            pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
            pw.print("<a style='font-size: 24px;'>Order</a>");
            pw.print("</h2><div class='entry'>");
            pw.print("<table  class='gridtable'><tr><td>Customer Name:</td><td>");
            pw.print(userName);
            pw.print("</td></tr>");
            // for each order iterate and display the order name price
            for (OrderItem oi : utility.getCustomerOrders())
            {
                pw.print("<tr><td> Product Purchased:</td><td>");
                pw.print(oi.getName()+"</td></tr><tr><td>");
                pw.print("<input type='hidden' name='orderPrice' value='"+oi.getPrice()+"'>");
                pw.print("<input type='hidden' name='orderName' value='"+oi.getName()+"'>");
                pw.print("Product Price:</td><td>"+ oi.getPrice());
                pw.print("</td></tr>");
                MySqlDataStoreUtilities.updateNumber(type,oi.getName(),MySqlDataStoreUtilities.getNumber(type,oi.getName())-1);
            }
            pw.print("<tr><td>");
            pw.print("Total Order Cost</td><td>"+orderTotal);
            pw.print("<input type='hidden' name='orderTotal' value='"+orderTotal+"'>");
            pw.print("</td></tr></table><table><tr></tr><tr></tr>");
            pw.print("<tr><td>");
            pw.print("Credit/accountNo</td>");
            pw.print("<td><input type='text' name='creditCardNo'>");
            pw.print("</td></tr>");
            pw.print("<tr><td>");
            pw.print("Customer Address</td>");
            pw.print("<td><input type='text' name='userAddress'>");
            pw.print("</td></tr>");
            pw.print("<tr><td colspan='2'>");
            pw.print("<input type='submit' name='submit' class='btnbuy' value = 'confirm'>");
            pw.print("</td></tr></table></form>");
            pw.print("</div></div></div>");
            utility.printHtml("Footer.html");
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


}
