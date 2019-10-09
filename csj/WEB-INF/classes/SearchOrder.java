/*import javax.servlet.annotation.WebServlet;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
*/

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













@WebServlet("/SearchOrder")

public class SearchOrder extends HttpServlet{
    private String error_msg;
    private String add_msg;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        displaySearch(request, response, pw, false);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        XWrite write = new XWrite();
        try{
            write.createXML(request,response);
        }catch (Exception e ){

        }
        HttpSession session = request.getSession(true);
        session.setAttribute("add_msg", "add complete");
        displaySearch(request, response, pw, true);
    }



    protected void displaySearch(HttpServletRequest request,
                                       HttpServletResponse response, PrintWriter pw, boolean error)
            throws ServletException, IOException {
        Utilities utility = new Utilities(request, pw);
        utility.printHtml("Header.html");
        utility.printHtml("SaleNavigation.html");
        String type = request.getParameter("type");
        String o = "#";
        if(type.equals("update"))
        {
          o = "UpdateOrder";
        }else if(type.equals("search"))
        {
          o = "MOrder";
        }
        pw.print("<div class='post' style='float: none; width: 100%'>");
        pw.print("<h2 class='title meta'><a style='font-size: 24px;'>Add Product</a></h2>"
                + "<div class='entry'>"
                + "<div style='width:200px; margin:25px; margin-left: auto;margin-right: auto;'>");
        if (error)
            pw.print("<h4 style='color:red'>"+error_msg+"</h4>");
        HttpSession session = request.getSession(true);
        if(session.getAttribute("add_msg")!=null){
            pw.print("<h4 style='color:red'>"+session.getAttribute("add_msg")+"</h4>");
            session.removeAttribute("add_msg");
        }
        pw.print("<form method='post' action='"+o+"'>"
                + "<table style='width:100%'><tr><td>"
                + "<h3>name</h3></td><td></td><td><input type='text' name='username' value='' class='input' required></input>"
                + "</td></tr><td>"
                + "<input type='submit' class='btnbuy' name='ByUser' value='submit' style='float: right;height: 20px margin: 20px; margin-right: 10px;'></input>"
                + "</form>" + "</div></div></div>");
    }
}
