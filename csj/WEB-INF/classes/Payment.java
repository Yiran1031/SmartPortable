import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@WebServlet("/Payment")
public class Payment extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        Utilities utility = new Utilities(request, pw);
        if(!utility.isLoggedin())
        {
            HttpSession session = request.getSession(true);
            session.setAttribute("login_msg", "Please Login to Pay");
            response.sendRedirect("LoginServlet");
            return;
        }

        String userAddress=request.getParameter("userAddress");
        String creditCardNo=request.getParameter("creditCardNo");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR));
        Date date = c.getTime();

        if(!userAddress.isEmpty() && !creditCardNo.isEmpty() )
        {
            int orderId = utility.getOrderPaymentSize() + 1;
            System.out.println("...................................."+orderId);

            for (OrderItem oi : utility.getCustomerOrders())
            {


                utility.storePayment(orderId,oi.getName(),oi.getPrice(),userAddress,creditCardNo,date);
            }


            //remove order detial from cart.
            OrdersHashMap.orders.remove(utility.username());
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR)+ 14);
            Date today = calendar.getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String r = format.format(today);
            utility.printHtml("Header.html");
            utility.printHtml("LeftNavigationBar.html");
            pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
            pw.print("<a style='font-size: 24px;'>Order</a>");
            pw.print("</h2><div class='entry'>");

            pw.print("<h2>Your Order");
            pw.print("&nbsp&nbsp");
            pw.print("is stored ");
            pw.print("<br>Your Order No is "+(orderId));
            pw.print("<br>you will received your item at "+(r));
            pw.print("</h2></div></div></div>");
            utility.printHtml("Footer.html");
        }else
        {
            utility.printHtml("Header.html");
            utility.printHtml("LeftNavigationBar.html");
            pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
            pw.print("<a style='font-size: 24px;'>Order</a>");
            pw.print("</h2><div class='entry'>");

            pw.print("<h4 style='color:red'>Please enter valid address and creditcard number</h4>");
            pw.print("</h2></div></div></div>");
            utility.printHtml("Footer.html");
        }
    }
}
