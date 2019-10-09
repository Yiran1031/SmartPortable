import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SubmitReview")

public class SubmitReview extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
	        Utilities utility= new Utilities(request, pw);
		storeReview(request, response);
	}
	protected void storeReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        try
                {
                response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
                Utilities utility = new Utilities(request,pw);
		if(!utility.isLoggedin()){
			HttpSession session = request.getSession(true);
			session.setAttribute("login_msg", "Please Login to add items to cart");
			response.sendRedirect("Login");
			return;
		}
                String productname=request.getParameter("productname");
                String producttype=request.getParameter("producttype");
								String productprice=request.getParameter("productprice");
								String retailerName = request.getParameter("RetailerName");
								String retailerpin=request.getParameter("RetailerZip");
								String retailercity = request.getParameter("RetailerCity");
								String retailerState = request.getParameter("RetailerState");
								String productOnSale = request.getParameter("ProductOnSale");
								String reviewrating=request.getParameter("reviewRating");
								String manufacturerName = request.getParameter("manufacturerName");
								String manufacturerRebate = request.getParameter("manufacturerRebate");
								String userId = request.getParameter("userId");
								String userAge = request.getParameter("UserAge");
								String userGender = request.getParameter("UserGender");
								String userOccupation = request.getParameter("UserOccupation");
                String reviewdate=request.getParameter("ReviewDate");
                String reviewtext=request.getParameter("ReviewText");
								String message=utility.storeReview(productname,producttype,productprice,retailerName,retailerpin,retailercity,retailerState, productOnSale,manufacturerName,manufacturerRebate,userId,userAge,userGender,userOccupation,reviewrating,reviewdate,reviewtext);

		utility.printHtml("Header.html");
		utility.printHtml("LeftNavigationBar.html");
		pw.print("<form name ='Cart' action='CheckOut' method='post'>");
                pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("<a style='font-size: 24px;'>Review</a>");
		pw.print("</h2><div class='entry'>");
      		if(message.equals("Successfull"))
      		pw.print("<h2>Review for &nbsp"+productname+" Stored </h2>");
                else
		pw.print("<h2>Mongo Db is not up and running </h2>");

		pw.print("</div></div></div>");
		utility.printHtml("Footer.html");

                    }
              	catch(Exception e)
		{
                 System.out.println(e.getMessage());
		}


		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

            }
}
