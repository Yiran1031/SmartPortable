import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.io.*;

@WebServlet("/CancelOrder")

public class SalesCancel extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        Utilities utility = new Utilities(request, pw);

        String username= request.getParameter("U");
        utility.printHtml("Header.html");
        utility.printHtml("SaleNavigation.html");
        pw.print("<form name ='ViewOrder' action='ViewOrder' method='get'>");
        pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
        pw.print("<a style='font-size: 24px;'>Order</a>");
        pw.print("</h2><div class='entry'>");

        if(request.getParameter("Order")==null)
        {
            pw.print("<table align='center'><tr><td>Enter OrderNo &nbsp&nbsp<input name='orderId' type='text'></td>");
            pw.print("<td><input type='submit' name='Order' value='ViewOrder' class='btnbuy'></td></tr></table>");
        }

        HashMap<Integer, ArrayList<OrderPayment>> orderPayments = new HashMap<Integer, ArrayList<OrderPayment>>();
      //  String TOMCAT_HOME = System.getProperty("catalina.home");

        try
        {
            // FileInputStream fileInputStream = new FileInputStream(new File(TOMCAT_HOME+"\\webapps\\Tutorial_1\\PaymentDetails.txt"));
            // ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            // orderPayments = (HashMap)objectInputStream.readObject();
              orderPayments = MySqlDataStoreUtilities.selectOrder();
        }
        catch(Exception e)
        {
        }

        if(request.getParameter("orderName") != null)
        {
            String orderName=request.getParameter("orderName");
            int orderId=0;
            orderId=Integer.parseInt(request.getParameter("orderId"));
            ArrayList<OrderPayment> ListOrderPayment =new ArrayList<OrderPayment>();
            //get the order from file
            try
            {

                // FileInputStream fileInputStream = new FileInputStream(new File(TOMCAT_HOME+"\\webapps\\csj\\PaymentDetails.txt"));
                // ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                // orderPayments = (HashMap)objectInputStream.readObject();
                orderPayments = MySqlDataStoreUtilities.selectOrder();
            }
            catch(Exception e)
            {

            }
            //get the exact order with same ordername and add it into cancel list to remove it later
            for (OrderPayment oi : orderPayments.get(orderId))
            {
                if(oi.getOrderName().equals(orderName) && oi.getUserName().equals(username))
                {
                    ListOrderPayment.add(oi);
                    pw.print("<h4 style='color:red'>Your Order is Cancelled</h4>");
                }
            }
            for (OrderPayment oi : ListOrderPayment)
            {
                if(oi.getOrderName().equals(orderName) && oi.getUserName().equals(username))
                {
                    MySqlDataStoreUtilities.deleteOrder(oi.getOrderId(),oi.getOrderName());
                    pw.print("<h4 style='color:red'>Your Order is Cancelled</h4>");
                }
            }
            //remove all the orders from hashmap that exist in cancel list
            // orderPayments.get(orderId).removeAll(ListOrderPayment);
            // if(orderPayments.get(orderId).size()==0)
            // {
            //     orderPayments.remove(orderId);
            // }
            // //save the updated hashmap with removed order to the file
            // try
            // {
            //     FileOutputStream fileOutputStream = new FileOutputStream(new File(TOMCAT_HOME+"\\webapps\\csj\\PaymentDetails.txt"));
            //     ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            //     objectOutputStream.writeObject(orderPayments);
            //     objectOutputStream.flush();
            //     objectOutputStream.close();
            //     fileOutputStream.close();
            // }
            // catch(Exception e)
            // {
            //
            // }
        }else
        {
            pw.print("<h4 style='color:red'>Please select any product</h4>");
        }

        pw.print("</form></div></div></div>");
        utility.printHtml("Footer.html");
    }

}
