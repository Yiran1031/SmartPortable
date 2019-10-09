import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@WebServlet("/Utilities")

public class Utilities {
    HttpServletRequest req;
    PrintWriter pw;
    String url;
    HttpSession session;

    public Utilities(HttpServletRequest req, PrintWriter pw) {
        this.req = req;
        this.pw = pw;
        this.url = this.getFullURL();
        this.session = req.getSession(true);
    }

    public void printHtml(String file) {
        String result = HtmlToString(file);
        //to print the right navigation in header of username cart and logout etc
        if (file == "Header.html") {
            result = result + "<div id='menu' style='float: right;'><ul>";
            if (session.getAttribute("username") != null) {
                String username = session.getAttribute("username").toString();
                String usertype = session.getAttribute("usertype").toString();
                username = Character.toUpperCase(username.charAt(0)) + username.substring(1);
                result = result + "<li><a href='ViewOrder'><span class='glyphicon'>ViewOrder</span></a></li>"
                        + "<li><a><span class='glyphicon'>Hello," + username +","+ usertype + "</span></a></li>"
                        + "<li><a href='Account'><span class='glyphicon'>Account</span></a></li>"
                        + "<li><a href='LogOut'><span class='glyphicon'>Logout</span></a></li>";
            } else
                result = result + "<li><a href='ViewOrder'><span class='glyphicon'>View Order</span></a></li>" + "<li><a href='LoginServlet'><span class='glyphicon'>Login</span></a></li>";
            result = result + "<li><a href='Cart'><span class='glyphicon'>Cart ("+CartCount() + ")</span></a></li></ul></div></div><div id='page'>";
            pw.print(result);
        } else
            pw.print(result);
    }

    public String getFullURL() {
        String scheme = req.getScheme();
        String serverName = req.getServerName();
        int serverPort = req.getServerPort();
        String contextPath = req.getContextPath();
        StringBuffer url = new StringBuffer();
        url.append(scheme).append("://").append(serverName);

        if ((serverPort != 80) && (serverPort != 443)) {
            url.append(":").append(serverPort);
        }
        url.append(contextPath);
        url.append("/");
        return url.toString();
    }
    // get the html file and convert into string and return the string.
    public String HtmlToString(String file) {
        String result = null;
        try {
            String webPage = url + file;
            URL url = new URL(webPage);// create a new url object
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);

            int numCharsRead;
            char[] charArray = new char[1024];
            StringBuffer sb = new StringBuffer();
            while ((numCharsRead = isr.read(charArray)) > 0) {
                sb.append(charArray, 0, numCharsRead);
            }
            result = sb.toString();
        } catch (Exception e) {
        }
        return result;
    }

    //check out whether the user is logged in
    public boolean isLoggedin(){
        if (session.getAttribute("username")==null)
            return false;
        return true;
    }

    public void storeProduct(String name, String type, String product, String access){
        //if a user has not create cart yet, create a new arraylist to store item
        if(!OrdersHashMap.orders.containsKey(username()))
        {
            ArrayList<OrderItem> arr = new ArrayList<OrderItem>();
            OrdersHashMap.orders.put(username(), arr);
        }
        ArrayList<OrderItem> orderItems = OrdersHashMap.orders.get(username());//get user's item list
        if(type.equals("WearableTechnology"))
        {
            WearableTechnology wt;
            HashMap<String,WearableTechnology> wts = MySqlDataStoreUtilities.selectAllWt();
            wt = wts.get(name);
            //SaxParserDataStore.wts.get(name);
            OrderItem orderitem = new OrderItem(wt.getName(), wt.getPrice(), wt.getImage(), wt.getType());
            orderItems.add(orderitem);
        }else if(type.equals("Phone"))
        {
            Phone p;
            HashMap<String,Phone > phones = MySqlDataStoreUtilities.selectAllPhone();
            p = phones.get(name);
            //p = SaxParserDataStore.phones.get(name);
            OrderItem orderitem = new OrderItem(p.getName(), p.getPrice(), p.getImage(), p.getType());
            orderItems.add(orderitem);
        }else if(type.equals("Laptops"))
        {
            Laptops l;
            HashMap<String,Laptops> laptops = MySqlDataStoreUtilities.selectAllLaptop();
            l = laptops.get(name);
            // l = SaxParserDataStore.laptops.get(name);
            OrderItem orderitem = new OrderItem(l.getName(), l.getPrice(), l.getImage(), l.getType());
            orderItems.add(orderitem);
        }else if(type.equals("VoiceAssistant"))
        {
            VoiceAssistant va;
            HashMap<String,VoiceAssistant> vas = MySqlDataStoreUtilities.selectAllVa();
            va = vas.get(name);
            //SaxParserDataStore.vas.get(name);
            OrderItem orderitem = new OrderItem(va.getName(), va.getPrice(), va.getImage(), va.getType());
            orderItems.add(orderitem);
        }

    }

    public String username(){
        if (session.getAttribute("username")!=null)
            return session.getAttribute("username").toString();
        return null;
    }

    public int CartCount()
    {
        if(isLoggedin())
        {
            System.out.println("size="+getCustomerOrders().size());
            return getCustomerOrders().size();
        }
        return 0;
    }
    public ArrayList<OrderItem> getCustomerOrders(){
        ArrayList<OrderItem> order = new ArrayList<OrderItem>();
        if(OrdersHashMap.orders.containsKey(username()))
            order= OrdersHashMap.orders.get(username());
        return order;
    }

    public int getOrderPaymentSize(){
        HashMap<Integer, ArrayList<OrderPayment>> orderPayments = new HashMap<Integer, ArrayList<OrderPayment>>();
      //  String TOMCAT_HOME = System.getProperty("catalina.home");
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
        int size=0;
        for(Map.Entry<Integer, ArrayList<OrderPayment>> entry : orderPayments.entrySet()){
          size = entry.getKey();
          System.out.println("............................................."+size);
        }
        return size;
    }
    public void storePayment(int orderId, String orderName,double orderPrice,String userAddress,String creditCardNo,Date date){

        HashMap<Integer, ArrayList<OrderPayment>> orderPayments= new HashMap<Integer, ArrayList<OrderPayment>>();
        // String TOMCAT_HOME = System.getProperty("catalina.home");
        // get the payment details file
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
        if(orderPayments==null)
        {
            orderPayments = new HashMap<Integer, ArrayList<OrderPayment>>();
        }
        // if there exist order id already add it into same list for order id or create a new record with order id

        if(!orderPayments.containsKey(orderId)){
            ArrayList<OrderPayment> arr = new ArrayList<OrderPayment>();
            orderPayments.put(orderId, arr);
        }
        ArrayList<OrderPayment> listOrderPayment = orderPayments.get(orderId);
        OrderPayment orderpayment = new OrderPayment(orderId,username(),orderName,orderPrice,userAddress,creditCardNo);
        listOrderPayment.add(orderpayment);

        // add order details into file

        try
        {
            // FileOutputStream fileOutputStream = new FileOutputStream(new File(TOMCAT_HOME+"\\webapps\\csj\\PaymentDetails.txt"));
            // ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            // objectOutputStream.writeObject(orderPayments);
            // objectOutputStream.flush();
            // objectOutputStream.close();
            // fileOutputStream.close();
            MySqlDataStoreUtilities.insertOrder(orderId,username(),orderName,orderPrice,userAddress,creditCardNo,date);
        }
        catch(Exception e)
        {
            System.out.println("inside exception file not written properly");
        }
    }

    public User getUser(){
        String usertype = usertype();
        HashMap<String, User> hm=new HashMap<String, User>();
        // String TOMCAT_HOME = System.getProperty("catalina.home");
        try
        {
            // FileInputStream fileInputStream=new FileInputStream(new File(TOMCAT_HOME+"\\webapps\\csj\\UserDetails.txt"));
            // ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            // hm= (HashMap)objectInputStream.readObject();
            hm = MySqlDataStoreUtilities.selectUser();
        }
        catch(Exception e)
        {
        }
        User user = hm.get(username());
        return user;
    }


    public String usertype(){
        if (session.getAttribute("usertype")!=null)
            return session.getAttribute("usertype").toString();
        return null;
    }

    public String storeReview(String productName,String productType, String price, String retailerName,String retailerpin,String retailercity, String retailerState, String productOnSale,String productMaker,String manufacturerRebate,String userName,String userAge,String userGender,String userOccupation,String reviewRating,String reviewDate,String reviewtext)
    {
      String message=MongoDBDataStoreUtilities.insertReview(productName,productType,price,retailerName,retailerpin,retailercity,retailerState, productOnSale,productMaker,manufacturerRebate,userName,userAge,userGender,userOccupation,reviewRating,reviewDate,reviewtext);
      if(!message.equals("Successfull"))
      {
        return "UnSuccessfull";
      }
      else
      {
        HashMap<String, ArrayList<Review>> reviews= new HashMap<String, ArrayList<Review>>();
        try
        {
          reviews=MongoDBDataStoreUtilities.selectReview();
        }
        catch(Exception e)
        {

        }
        if(reviews==null)
        {
          reviews = new HashMap<String, ArrayList<Review>>();
        }
     // if there exist product review already add it into same list for productname or create a new record with product name

        if(!reviews.containsKey(productName)){
          ArrayList<Review> arr = new ArrayList<Review>();
          reviews.put(productName, arr);
        }
          ArrayList<Review> listReview = reviews.get(productName);
          Review review = new Review(productName,productType,price,retailerName,retailerpin,retailercity,retailerState, productOnSale,productMaker,manufacturerRebate,userName,userAge,userGender,userOccupation,reviewRating,reviewDate,reviewtext);
          listReview.add(review);
          System.out.println(productName+productType+price+retailerName+retailerpin+retailercity+retailerState+productOnSale+productMaker+manufacturerRebate+userName+userAge+userGender+userOccupation+reviewRating+reviewDate+reviewtext);
     // add Reviews into database

     return "Successfull";
    }
 }
}
