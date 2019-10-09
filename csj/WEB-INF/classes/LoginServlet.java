import java.io.*;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;

@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet{
    /*protected Map user = new HashMap();// use for test data
    public void init()
    {
        user.put("admin","admin");
    }*/
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String usertype = request.getParameter("usertype");
        HashMap<String, User> hm = new HashMap<String, User>();
        // String TOMCAT_HOME = System.getProperty("catalina.home");
        try{
            // FileInputStream fileInputStream = new FileInputStream(new File(TOMCAT_HOME+"\\webapps\\csj\\UserDetails.txt"));
            // ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            // hm = (HashMap)objectInputStream.readObject();
            hm = MySqlDataStoreUtilities.selectUser();
        }catch (Exception e)
        {

        }
        User user = hm.get(username);
        if(user!=null)
        {
            String user_password = user.getPassword();
            String user_type = user.getUsertype();
            System.out.println(user_type + usertype);
            if(password.equals(user_password) && user_type.equals(usertype))//if password is correct
            {
                if(user_type.equals("customer"))
                {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("username", user.getName());
                    session.setAttribute("usertype", user.getUsertype());
                    response.sendRedirect("Home");//direct user information to Home page by session.
                    return;
                }else if(user_type.equals("storemanager"))
                {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("username", user.getName());
                    session.setAttribute("usertype", user.getUsertype());
                    response.sendRedirect("Manage");//direct user information to Home page by session.
                    return;
                }else if(user_type.equals("salesman"))
                {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("username", user.getName());
                    session.setAttribute("usertype", user.getUsertype());
                    response.sendRedirect("SalesMan");//direct user information to Home page by session.
                    return;
                }else {
                    displayLogin(request, response, pw, true);
                }
            }   displayLogin(request, response, pw, true);
        }else{
            displayLogin(request, response, pw, true);
        }
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,java.io.IOException
    {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        displayLogin(request, response, pw, false);
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,java.io.IOException
    {
        processRequest(request,response);
    }

    protected void displayLogin(HttpServletRequest request,
                                HttpServletResponse response, PrintWriter pw, boolean error)
            throws ServletException, IOException {

        Utilities utility = new Utilities(request, pw);
        utility.printHtml("Header.html");
        pw.print("<div class='post' style='float: none; width: 100%'>");
        pw.print("<h2 class='title meta'><a style='font-size: 24px;'>Login</a></h2>"
                + "<div class='entry'>"
                + "<div style='width:400px; margin:25px; margin-left: auto;margin-right: auto;'>");
        if (error)
            pw.print("<h4 style='color:red'>Please check your username, password and user type!</h4>");
        HttpSession session = request.getSession(true);
        if(session.getAttribute("login_msg")!=null){
            pw.print("<h4 style='color:red'>"+session.getAttribute("login_msg")+"</h4>");
            session.removeAttribute("login_msg");
        }
        pw.print("<form method='post' action='LoginServlet'>"
                + "<table style='width:100%'><tr><td>"
                + "<h3>Username</h3></td><td><input type='text' name='username' value='' class='input' required></input>"
                + "</td></tr><tr><td>"
                + "<h3>Password</h3></td><td><input type='password' name='password' value='' class='input' required></input>"
                + "</td></tr><tr><td>"
                + "<h3>User Type</h3></td><td><select name='usertype' class='input'><option value='customer' selected>Customer</option><option value='storemanager'>Store Manager</option><option value='salesman'>Salesman</option></select>"
                + "</td></tr><tr><td></td><td>"
                + "<input type='submit' class='btnbuy' value='Login' style='float: right;height: 20px margin: 20px; margin-right: 10px;'></input>"
                + "</td></tr><tr><td></td><td>"
                + "<strong><a class='' href='Registration' style='float: right;height: 20px margin: 20px;'>New User? Register here!</a></strong>"
                + "</td></tr></table>"
                + "</form>" + "</div></div></div>");
        utility.printHtml("Footer.html");
    }
}
