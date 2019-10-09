import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import com.mongodb.AggregationOutput;


@WebServlet("/DataVisualization")
public class DataVisualization extends HttpServlet {

    static DBCollection myReviews;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        displayPage(request, response, pw);
    }

    protected void displayPage(HttpServletRequest request, HttpServletResponse response, PrintWriter pw)
            throws ServletException, IOException {

        Utilities utility = new Utilities(request, pw);
        utility.printHtml("Header.html");
        utility.printHtml("ManageLeftBar.html");

        pw.print("<div id='content'><div class='post'>");
        pw.print("<h2 class='title meta'><a style='font-size: 24px;'>Data Visualization</a></h2>"
                + "<div class='entry'>");

        pw.print("<h3><button id='btnGetChartData'>View Chart</h3>");
        pw.println("<div id='chart_div'></div>");
        pw.println("</div></div></div>");
        pw.println("<script type='text/javascript' src=\"https://www.gstatic.com/charts/loader.js\"></script>");
        pw.println("<script type='text/javascript' src='DataVisualization.js'></script>");
        utility.printHtml("Footer.html");

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // try {
        //     // ArrayList<Review> reviews = MongoDBDataStoreUtilities.selectReviewForChart();
        //     ArrayList<WearableTechnology> wt = MySqlDataStoreUtilities.WtChart();
        //     ArrayList<Phone> phone = MySqlDataStoreUtilities.phoneChart();
        //     ArrayList<Laptops> laptop = MySqlDataStoreUtilities.laptopChart();
        //     ArrayList<VoiceAssistant> va = MySqlDataStoreUtilities.VaChart();
        //
        //   //  ArrayList<Review> topReviewsPerCity = getTop3InEveryCity(reviews);
        //
        //     String reviewJson1 = new Gson().toJson(wt);
        //     String reviewJson2 = new Gson().toJson(phone);
        //     String reviewJson3 = new Gson().toJson(laptop);
        //     String reviewJson4 = new Gson().toJson(va);
        //     String reviewJson = reviewJson1+reviewJson2+reviewJson3+reviewJson4;
        //     reviewJson = reviewJson.replaceAll("\\]\\[",",");
        //     System.out.println(reviewJson);
        //
        //     response.setContentType("application/JSON");
        //     response.setCharacterEncoding("UTF-8");
        //     response.getWriter().write(reviewJson);
        //   //  response.getWriter().write(reviewJson2);
        //     //response.getWriter().write(reviewJson);
        //
        // } catch (Exception ex) {
        //     System.out.println(ex.getMessage());
        // }
        productChart(request,response);

    }

    protected void productChart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              try {
                  // ArrayList<Review> reviews = MongoDBDataStoreUtilities.selectReviewForChart();
                  ArrayList<WearableTechnology> wt = MySqlDataStoreUtilities.WtChart();
                  ArrayList<Phone> phone = MySqlDataStoreUtilities.phoneChart();
                  ArrayList<Laptops> laptop = MySqlDataStoreUtilities.laptopChart();
                  ArrayList<VoiceAssistant> va = MySqlDataStoreUtilities.VaChart();

                //  ArrayList<Review> topReviewsPerCity = getTop3InEveryCity(reviews);

                  String reviewJson1 = new Gson().toJson(wt);
                  String reviewJson2 = new Gson().toJson(phone);
                  String reviewJson3 = new Gson().toJson(laptop);
                  String reviewJson4 = new Gson().toJson(va);
                  String reviewJson = reviewJson1+reviewJson2+reviewJson3+reviewJson4;
                  reviewJson = reviewJson.replaceAll("\\]\\[",",");
                  System.out.println(reviewJson);

                  response.setContentType("application/JSON");
                  response.setCharacterEncoding("UTF-8");
                  response.getWriter().write(reviewJson);
                //  response.getWriter().write(reviewJson2);
                  //response.getWriter().write(reviewJson);

              } catch (Exception ex) {
                  System.out.println(ex.getMessage());
              }

    }

}
