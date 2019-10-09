import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@WebServlet("/ProductsAvaiable")

public class ProductsAvaiable extends HttpServlet {

	//ArrayList <WearableTechnology> wts = new ArrayList <WearableTechnology> ();
  // HashMap<String, WearableTechnology> wts = MySqlDataStoreUtilities.selectAllWt();
  // //ArrayList <Phone> ps = new ArrayList <Phone> ();
  // HashMap<String, Phone> phones = MySqlDataStoreUtilities.selectAllPhone();
	// //ArrayList <Laptops> ls = new ArrayList <Laptops> ();
  // HashMap<String, Laptops> ls = MySqlDataStoreUtilities.selectAllLaptop();
  // //ArrayList <VoiceAssistant> vas = new ArrayList <VoiceAssistant>();
  // HashMap<String, VoiceAssistant> vas = MySqlDataStoreUtilities.selectAllVa();

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		// mostsold = MongoDBDataStoreUtilities.mostsoldProducts();
		// mostsoldzip = MongoDBDataStoreUtilities.mostsoldZip();
		// bestrated      = MongoDBDataStoreUtilities.topProducts();

    HashMap<String, WearableTechnology> wts = MySqlDataStoreUtilities.selectAllWt();
    HashMap<String, Phone> phones = MySqlDataStoreUtilities.selectAllPhone();
    HashMap<String, Laptops> ls = MySqlDataStoreUtilities.selectAllLaptop();
    HashMap<String, VoiceAssistant> vas = MySqlDataStoreUtilities.selectAllVa();


		Utilities utility = new Utilities(request, pw);
		utility.printHtml("Header.html");
		utility.printHtml("ManageLeftBar.html");
    pw.print("<div id='content'><div class='post'><h2 class='title meta'>");


    pw.print("<a style='font-size: 24px;'>WearableTechnology</a>");
    pw.print("</h2><div class='entry'><table class='gridtable'>");
    pw.println("<tr>");
    pw.println("<td border: 1px >");
    pw.println("name");
    pw.println("</td>");
    pw.println("<td border: 1px >");
    pw.println("Price");
    pw.println("</td>");
    pw.println("<td border: 1px >");
    pw.println("number");
    pw.println("</td>");
    pw.println("</tr>");
    for(Map.Entry<String, WearableTechnology> entry : wts.entrySet())
    {
        WearableTechnology w = entry.getValue();
        pw.println("<tr>");
        pw.println("<td border: 1px >");
        pw.println(w.getName());
        pw.println("</td>");
        pw.println("<td border: 1px >");
        pw.println(w.getPrice());
        pw.println("</td>");
        pw.println("<td border: 1px >");
        pw.println(w.getNum());
        pw.println("</td>");
        pw.println("</tr>");

    }
    pw.print("</table></div>");


    pw.print("<h2 class='title meta'><a style='font-size: 24px;'> Phone</a>");
    pw.print("</h2><div class='entry'><table class='gridtable'>");
    pw.println("<tr>");
    pw.println("<td border: 1px >");
    pw.println("name");
    pw.println("</td>");
    pw.println("<td border: 1px >");
    pw.println("Price");
    pw.println("</td>");
    pw.println("<td border: 1px >");
    pw.println("number");
    pw.println("</td>");
    pw.println("</tr>");
    for(Map.Entry<String, Phone> entry : phones.entrySet())
    {
        Phone p = entry.getValue();
        pw.println("<tr>");
        pw.println("<td border: 1px >");
        pw.println(p.getName());
        pw.println("</td>");
        pw.println("<td border: 1px >");
        pw.println(p.getPrice());
        pw.println("</td>");
        pw.println("<td border: 1px >");
        pw.println(p.getP_number());
        pw.println("</td>");
        pw.println("</tr>");

    }
    pw.print("</table></div>");



    pw.print("<h2 class='title meta'><a style='font-size: 24px;'>Laptops</a>");
    pw.print("</h2><div class='entry'><table class='gridtable'>");
    pw.println("<tr>");
    pw.println("<td border: 1px >");
    pw.println("name");
    pw.println("</td>");
    pw.println("<td border: 1px >");
    pw.println("Price");
    pw.println("</td>");
    pw.println("<td border: 1px >");
    pw.println("number");
    pw.println("</td>");
    pw.println("</tr>");
    for(Map.Entry<String, Laptops> entry : ls.entrySet())
    {
        Laptops l = entry.getValue();
        pw.println("<tr>");
        pw.println("<td border: 1px >");
        pw.println(l.getName());
        pw.println("</td>");
        pw.println("<td border: 1px >");
        pw.println(l.getPrice());
        pw.println("</td>");
        pw.println("<td border: 1px >");
        pw.println(l.getNum());
        pw.println("</td>");
        pw.println("</tr>");

    }
    pw.print("</table></div>");


    pw.print("<h2 class='title meta'><a style='font-size: 24px;'>VoiceAssistant</a>");
    pw.print("</h2><div class='entry'><table class='gridtable'>");
    pw.println("<tr>");
    pw.println("<td border: 1px >");
    pw.println("name");
    pw.println("</td>");
    pw.println("<td border: 1px >");
    pw.println("Price");
    pw.println("</td>");
    pw.println("<td border: 1px >");
    pw.println("number");
    pw.println("</td>");
    pw.println("</tr>");
    for(Map.Entry<String, VoiceAssistant> entry : vas.entrySet())
    {
        VoiceAssistant v = entry.getValue();
        pw.println("<tr>");
        pw.println("<td border: 1px >");
        pw.println(v.getName());
        pw.println("</td>");
        pw.println("<td border: 1px >");
        pw.println(v.getPrice());
        pw.println("</td>");
        pw.println("<td border: 1px >");
        pw.println(v.getNum());
        pw.println("</td>");
        pw.println("</tr>");

    }
    pw.print("</table></div></div></div>");



    utility.printHtml("Footer.html");
	// 	pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
	// 	pw.print("<a style='font-size: 24px;'>Best Products</a>");
	// 	pw.print("</h2><div class='entry'><table id='bestseller'>");
	// 	Iterator itr2 = bestrated.iterator();
  //       while(itr2.hasNext()) {
  //        Bestrating best = (Bestrating)itr2.next();
 	// 	pw.print("<tr>");
	// 	pw.print("<td>");
	// 	pw.print(best.getProductname());
	// 	pw.print("</td>");
	// 	pw.print("<td>");
	// 	pw.print(best.getRating());
	// 	pw.print("</td>");
	// 	pw.print("</tr>");
  //       }
	// 	pw.print("</table></div></div></div>");
  //
	// 	pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
	// 	pw.print("<a style='font-size: 24px;'>Most Sold Products by Zipcode</a>");
	// 	pw.print("</h2><div class='entry'><table id='bestseller'>");
	// 	Iterator itr1 = mostsoldzip.iterator();
  //        while(itr1.hasNext()) {
  //        Mostsoldzip mostzip = (Mostsoldzip)itr1.next();
 	// 	pw.print("<tr>");
	// 	pw.println("<td border: 1px >");
	// 	System.out.println(mostzip.getZipcode());
	// 	pw.println(mostzip.getZipcode());
	// 	pw.println("</td>");
	// 	pw.println("<td border: 1px >");
	// 	pw.println(mostzip.getCount());
	// 	pw.println("</td>");
	// 	pw.println("</tr>");
  //       }
	// 	pw.print("</table></div></div></div>");
  //
	// 	pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
	// 	pw.print("<a style='font-size: 24px;'>Most Sold Products</a>");
	// 	pw.print("</h2><div class='entry'><table id='bestseller'>");
  //
  //        Iterator itr = mostsold.iterator();
  //       while(itr.hasNext()) {
  //        Mostsold most = (Mostsold)itr.next();
 	// 	pw.println("<tr>");
	// 	pw.println("<td border: 1px >");
	// 	pw.println(most.getProductname());
	// 	pw.println("</td>");
	// 	pw.println("<td border: 1px >");
	// 	pw.println(most.getCount());
	// 	pw.println("</td>");
	// 	pw.println("</tr>");
  //       }
	// 	pw.print("</table></div></div></div>");
  //
	// //	pw.print("</table></div></div></div>");
  //
  //
  //
  //
	// 	utility.printHtml("Footer.html");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
