import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PhoneList")
public class PhoneList extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String name = null;
        PrintWriter pw = response.getWriter();
        String CategoryName = request.getParameter("product");

        HashMap<String, Phone> hm = new HashMap<String, Phone>();
        HashMap<String, Phone> phones = MySqlDataStoreUtilities.selectAllPhone();
        if(CategoryName == null){
            hm.putAll(phones);
            name = "";
        }


        Utilities utility = new Utilities(request,pw);
        utility.printHtml("Header.html");
        utility.printHtml("LeftNavigationBar.html");
        pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
        pw.print("<a style='font-size: 24px;'>"+name+" Phone</a>");
        pw.print("</h2><div class='entry'><table id='bestseller'>");
        int i = 1; int size= hm.size();
        for(Map.Entry<String, Phone> entry : hm.entrySet())
        {
            Phone console = entry.getValue();
            if(i%3==1) pw.print("<tr>");
            pw.print("<td><div id='shop_item'>");
            pw.print("<h3>"+console.getName()+"</h3>");
            pw.print("<strong>$"+console.getPrice()+"</strong><ul>");
            pw.print("<li id='item'><img src='images/"+console.getImage()+"' alt='' /></li>");

            pw.print("<li><form method='post' action='Cart'>" +
                    "<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
                    "<input type='hidden' name='type' value='Phone'>"+
                    "<input type='hidden' name='product' value='"+CategoryName+"'>"+
                    "<input type='hidden' name='access' value=''>"+
                    "<input type='submit' class='btnbuy' value='Buy Now'></form></li>");
            pw.print("<li><form method='post' action='WriteReview'>"+"<input type='hidden' name='name' value='"+console.getName()+"'>"+
                    "<input type='hidden' name='type' value='consoles'>"+
                    "<input type='hidden' name='maker' value='"+CategoryName+"'>"+
                    "<input type='hidden' name='price' value='"+console.getPrice()+"'>"+
                    "<input type='hidden' name='access' value=''>"+
                    "<input type='submit' value='WriteReview' class='btnreview'></form></li>");
            pw.print("<li><form method='post' action='ViewReview'>"+"<input type='hidden' name='name' value='"+console.getName()+"'>"+
                    "<input type='hidden' name='type' value='consoles'>"+
                    "<input type='hidden' name='maker' value='"+CategoryName+"'>"+
                    "<input type='hidden' name='access' value=''>"+
                    "<input type='submit' value='ViewReview' class='btnreview'></form></li>");

            if(utility.isLoggedin())
            {
              HttpSession session = request.getSession(true);
              if(session.getAttribute("usertype").equals("storemanager"))
              {
                pw.print("<li><form method='post' action='ProductUpdate'>"+"<input type='hidden' name='name' value='"+console.getName()+"'>"+
                      "<input type='hidden' name='id' value='"+console.getId()+"'>"+
                      "<input type='hidden' name='name' value='"+console.getName()+"'>"+
                      "<input type='hidden' name='price' value='"+console.getPrice()+"'>"+
                      "<input type='hidden' name='type' value='"+console.getType()+"'>"+
                      "<input type='hidden' name='cond' value='"+console.getCondition()+"'>"+
                      "<input type='hidden' name='discount' value='"+console.getDiscount()+"'>"+
                      "<input type='hidden' name='num' value='"+console.getP_number()+"'>"+
                      "<input type='submit' value='update' class='btnreview'></form></li>");
              }
            }
            pw.print("</ul></div></td>");
            if(i%3==0 || i == size) pw.print("</tr>");
            i++;
        }
        pw.print("</table></div></div></div>");

        utility.printHtml("Footer.html");
    }
}
