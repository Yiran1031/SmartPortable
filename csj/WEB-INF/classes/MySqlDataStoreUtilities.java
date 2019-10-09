import java.sql.*;
import java.util.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;

public class MySqlDataStoreUtilities{
  static Connection conn = null;
  public static void getConnection(){
    try{
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartportables","root","cumin");
    }
    catch(Exception e){

    }
  }
  public static HashMap<String,WearableTechnology> selectWT()
  {
    HashMap<String,WearableTechnology> hm = new HashMap<String,WearableTechnology>();
    try
    {
        getConnection();
        Statement stmt = conn.createStatement();
        String selectWTQuery = "select * from WearableTechnology";
        ResultSet  rs = stmt.executeQuery(selectWTQuery);
        while(rs.next())
        {
          WearableTechnology w = new WearableTechnology(rs.getString("id"),rs.getString("name"),rs.getDouble("price"),rs.getString("image"),rs.getString("type"),rs.getString("cond"),rs.getDouble("discount"));
          hm.put(rs.getString("id"),w);
        }
    }
    catch(Exception e)
    {}
      return hm;
  }
  public static HashMap<String,User> selectUser()
  {
    HashMap<String,User> hm = new HashMap<String,User>();
    try
    {
      getConnection();
      Statement stmt = conn.createStatement();
      String selectCustomerQuery = "select * from Registration";
      ResultSet rs = stmt.executeQuery(selectCustomerQuery);
      while(rs.next())
      {
        User user = new User(rs.getString("username"),rs.getString("password"),rs.getString("usertype"));
        hm.put(rs.getString("username"),user);
      }
    }
    catch(Exception e)
    {
    }
    return hm;
  }

  public static HashMap<String,SaleList> selectSaleList()
  {
    HashMap<String,SaleList> hm = new HashMap<String,SaleList>();
    try
    {
      getConnection();
      Statement stmt = conn.createStatement();
      String selectOrderQuery = "SELECT orderName,orderPrice,COUNT(*) AS total FROM customerorders GROUP BY orderName;";
      ResultSet rs = stmt.executeQuery(selectOrderQuery);
      while(rs.next())
      {
        SaleList orderList = new SaleList(rs.getString("orderName"),rs.getDouble("orderPrice"),rs.getInt("total"));
        hm.put(rs.getString("orderName"),orderList);
      }
    }
    catch(Exception e)
    {
    }
    return hm;
  }

  public static HashMap<String,DateSale> selectDateSale()
  {
    HashMap<String,DateSale> hm = new HashMap<String,DateSale>();
    SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    try
    {
      getConnection();
      Statement stmt = conn.createStatement();
      String selectOrderQuery = "SELECT date,COUNT(*) AS total,SUM(orderPrice) AS sales FROM customerorders GROUP BY date;";

      PreparedStatement pst = conn.prepareStatement(selectOrderQuery);
      ResultSet rs = pst.executeQuery();

      //ResultSet rs = stmt.executeQuery(selectOrderQuery);
      while(rs.next())
      {
        Date date = rs.getDate("date");
        String text = df.format(date);
        DateSale ds = new DateSale(text,rs.getInt("total"),rs.getDouble("sales"));
        hm.put(text,ds);
      }
    }
    catch(Exception e)
    {
    }
    return hm;
  }


  public static void insertWT(String id, String name, double price, String image, String type, String condition, double discount)
  {
    try
    {
      getConnection();
      String insertWTQuery = "INSERT INTO WearableTechnology(id,name,price,image,type,cond,discount)"+"VALUES(?,?,?,?,?,?,?);";
      PreparedStatement pst = conn.prepareStatement(insertWTQuery);
      System.out.println(id+","+name+","+price+","+image+","+type+","+condition+","+discount);
      pst.setString(1,id);
      pst.setString(2,name);
      pst.setDouble(3,price);
      pst.setString(4,image);
      pst.setString(5,type);
      pst.setString(6,condition);
      pst.setDouble(7,discount);
      pst.execute();
    }
      catch(Exception e)
    {
      System.out.println("insert error");
    }
  }

  public static void insertPhone(String id, String name, double price, String image, String type, String condition, double discount)
  {
    try
    {
      getConnection();
      String insertPQuery = "INSERT INTO phone(id,name,price,image,type,cond,discount)"+"VALUES(?,?,?,?,?,?,?);";
      PreparedStatement pst = conn.prepareStatement(insertPQuery);
      System.out.println(id+","+name+","+price+","+image+","+type+","+condition+","+discount);
      pst.setString(1,id);
      pst.setString(2,name);
      pst.setDouble(3,price);
      pst.setString(4,image);
      pst.setString(5,type);
      pst.setString(6,condition);
      pst.setDouble(7,discount);
      pst.execute();
    }
      catch(Exception e)
    {
      System.out.println("insert phone error");
    }
  }

  public static void insertLaptops(String id, String name, double price, String image, String type, String condition, double discount)
  {
    try
    {
      getConnection();
      String insertPQuery = "INSERT INTO Laptops(id,name,price,image,type,cond,discount)"+"VALUES(?,?,?,?,?,?,?);";
      PreparedStatement pst = conn.prepareStatement(insertPQuery);
      System.out.println(id+","+name+","+price+","+image+","+type+","+condition+","+discount);
      pst.setString(1,id);
      pst.setString(2,name);
      pst.setDouble(3,price);
      pst.setString(4,image);
      pst.setString(5,type);
      pst.setString(6,condition);
      pst.setDouble(7,discount);
      pst.execute();
    }
      catch(Exception e)
    {
      System.out.println("insert Laptops error");
    }
  }

  public static void insertVA(String id, String name, double price, String image, String type, String condition, double discount)
  {
    try
    {
      getConnection();
      String insertPQuery = "INSERT INTO VoiceAssistant(id,name,price,image,type,cond,discount)"+"VALUES(?,?,?,?,?,?,?);";
      PreparedStatement pst = conn.prepareStatement(insertPQuery);
      System.out.println(id+","+name+","+price+","+image+","+type+","+condition+","+discount);
      pst.setString(1,id);
      pst.setString(2,name);
      pst.setDouble(3,price);
      pst.setString(4,image);
      pst.setString(5,type);
      pst.setString(6,condition);
      pst.setDouble(7,discount);
      pst.execute();
    }
      catch(Exception e)
    {
      System.out.println("insert VoiceAssistant error");
    }
  }


  public static void insertUser(String username,String password, String repassword, String usertype){
    try{
      getConnection();
      String insertIntoCustomerRegisterQuery = "INSERT INTO registration(username,password,repassword,usertype)"+"VALUES(?,?,?,?);";
      PreparedStatement pst = conn.prepareStatement(insertIntoCustomerRegisterQuery);
      System.out.println(username+","+password+","+repassword+","+usertype);
      pst.setString(1,username);
      pst.setString(2,password);
      pst.setString(3,repassword);
      pst.setString(4,usertype);
      pst.execute();
    }
    catch(Exception e)
    {

    }
  }


  public static void deleteOrder(int orderId, String orderName)
  {
    try
    {
      getConnection();
      String deleteOrderQuery = "DELETE FROM customerorders where OrderId=? and orderName=?";
      PreparedStatement pst = conn.prepareStatement(deleteOrderQuery);
      pst.setInt(1,orderId);
      pst.setString(2,orderName);
      pst.executeUpdate();
    }
    catch(Exception e)
    {

    }
  }
  public static void insertOrder(int orderId, String userName,String orderName,double orderPrice, String userAddress,String creditCardNo,Date date)
  {
    try
    {
      getConnection();
      String insertOrderQuery = "INSERT INTO customerOrders(OrderId,UserName,OrderName,OrderPrice,userAddress,creditCardNo,date)"+"VALUES(?,?,?,?,?,?,?);";
      PreparedStatement pst = conn. prepareStatement(insertOrderQuery);
      java.sql.Date sqlDate = new java.sql.Date(date.getTime());
      pst.setInt(1,orderId);
      pst.setString(2,userName);
      pst.setString(3,orderName);
      pst.setDouble(4,orderPrice);
      pst.setString(5,userAddress);
      pst.setString(6,creditCardNo);
      pst.setDate(7,sqlDate);
      pst.execute();
    }catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  public static int getNumber(String table_name,String name)
  {
    int num = 0;
    try
    {
      getConnection();
      String selectNumber = "SELECT num FROM "+table_name+" WHERE name = ?;";
      PreparedStatement pst = conn.prepareStatement(selectNumber);
      pst.setString(1,name);
      // pst.setString(2,name);
      ResultSet rs = pst.executeQuery();
      while(rs.next())
      {
        num = rs.getInt("num");
      }
    }catch(Exception e)
    {
      e.printStackTrace();
    }
    return num;
  }
  public static void updateNumber(String table_name,String name ,int num )
  {
    try
    {
      getConnection();
      String updateProduct = "UPDATE "+table_name+" SET num = ? WHERE name = ?;";
      PreparedStatement pst = conn.prepareStatement(updateProduct);
      // pst.setString(1,table_name);
      pst.setInt(1,num);
      pst.setString(2,name);
      pst.executeUpdate();
    }catch(Exception e)
    {
      e.printStackTrace();
    }
  }
  public static void UpdateOrder(int orderId, String userName,String orderName,double orderPrice, String userAddress,String creditCardNo)
  {
    try
    {
      getConnection();
      String insertOrderQuery = "UPDATE customerOrders SET orderPrice = ?, userAddress = ?,creditCardNo = ? WHERE orderId = ? AND userName = ? AND orderName = ?";
      PreparedStatement pst = conn. prepareStatement(insertOrderQuery);
      pst.setDouble(1,orderPrice);
      pst.setString(2,userAddress);
      pst.setString(3,creditCardNo);
      pst.setInt(4,orderId);
      pst.setString(5,userName);
      pst.setString(6,orderName);
      pst.executeUpdate();
    }catch(Exception e)
    {

    }
  }


  public static HashMap<Integer, ArrayList<OrderPayment>> selectOrder()
  {
    HashMap<Integer,ArrayList<OrderPayment>> orderPayments = new HashMap<Integer, ArrayList<OrderPayment>>();

    try
    {
      getConnection();

      String selectOrderQuery = "SELECT * FROM customerorders";
      PreparedStatement pst = conn.prepareStatement(selectOrderQuery);
      ResultSet rs = pst.executeQuery();
      ArrayList<OrderPayment> orderList = new ArrayList<OrderPayment>();

      while(rs.next())
      {
        if(!orderPayments.containsKey(rs.getInt("OrderId")))
        {
          ArrayList<OrderPayment> arr = new ArrayList<OrderPayment>();
          orderPayments.put(rs.getInt("OrderId"),arr);
        }

        ArrayList<OrderPayment> listOrderPayment = orderPayments.get(rs.getInt("OrderId"));
        System.out.println("data is"+rs.getInt("OrderId")+orderPayments.get(rs.getInt("OrderId")));
        OrderPayment order = new OrderPayment(rs.getInt("OrderId"),rs.getString("userName"),rs.getString("orderName"),rs.getDouble("orderPrice"),rs.getString("userAddress"),rs.getString("creditCardNo"));
        listOrderPayment.add(order);
      }
    }
    catch(Exception e)
    {

    }
    return orderPayments;
  }

  public static void deleteProduct(String id, String ty)
  {
    getConnection();
    if(ty.equals("SmartWatches") || ty.equals("FitnessWatches") || ty.equals("Headphones") || ty.equals("VirtualReality")||ty.equals("PetTracker"))
    {
      try{
      String deleteProductQuery  = "DELETE FROM wearabletechnology WHERE id=? ";
      PreparedStatement pst = conn.prepareStatement(deleteProductQuery);
      pst.setString(1,id);
      pst.executeUpdate();
      }
      catch(Exception e)
      {
        System.out.println("delete error");
      }
    }else if(ty.equals("phone")){
      try{
      String deleteProductQuery  = "DELETE FROM phone WHERE id=? ";
      PreparedStatement pst = conn.prepareStatement(deleteProductQuery);
      pst.setString(1,id);
      pst.executeUpdate();
      }
      catch(Exception e)
      {
        System.out.println("delete error");
      }
    }else if(ty.equals("Laptops")){
      try{
      String deleteProductQuery  = "DELETE FROM laptops WHERE id=? ";
      PreparedStatement pst = conn.prepareStatement(deleteProductQuery);
      pst.setString(1,id);
      pst.executeUpdate();
      }
      catch(Exception e)
      {
        System.out.println("delete error");
      }
    }else if(ty.equals("VoiceAssistant")){
      try{
      String deleteProductQuery  = "DELETE FROM voiceassistant WHERE id=? ";
      PreparedStatement pst = conn.prepareStatement(deleteProductQuery);
      pst.setString(1,id);
      pst.executeUpdate();
      }
      catch(Exception e)
      {
        System.out.println("delete error");
      }
    }
  }




  public static HashMap<String,WearableTechnology > selectAllWt()
  {
    HashMap<String,WearableTechnology> wts = new HashMap<String, WearableTechnology>();
    WearableTechnology wt = null;
    try
    {
      getConnection();

      String selectWTQuery = "SELECT * FROM wearabletechnology";
      PreparedStatement pst = conn.prepareStatement(selectWTQuery);
      ResultSet rs = pst.executeQuery();
      // ArrayList<wearabletechnology> orderList = new ArrayList<wearabletechnology>();

      while(rs.next())
      {
        // if(!wt.containsKey(rs.getString("id")))
        // {
        //   ArrayList<OrderPayment> arr = new ArrayList<OrderPayment>();
        //   orderPayments.put(rs.getInt("OrderId"),arr);
        // }
        //
        // ArrayList<OrderPayment> listOrderPayment = orderPayments.get(rs.getInt("OrderId"));
        // System.out.println("data is"+rs.getInt("OrderId")+orderPayments.get(rs.getInt("OrderId")));
        // OrderPayment order = new OrderPayment(rs.getInt("OrderId"),rs.getString("userName"),rs.getString("orderName"),rs.getDouble("orderPrice"),rs.getString("userAddress"),rs.getString("creditCardNo"));
        // listOrderPayment.add(order);
        wt = new WearableTechnology(rs.getString("id"),rs.getString("name"),rs.getDouble("price"),rs.getString("image"),rs.getString("type"),rs.getString("cond"),rs.getDouble("discount"),"unknown",rs.getInt("num"));
        wts.put(rs.getString("id"),wt);
      }
    }
    catch(Exception e)
    {
        System.out.println("WearableTechnology read error");
    }
    return wts;
  }

  public static ArrayList<Phone> phoneChart()
  {
    ArrayList<Phone> wts = new  ArrayList<Phone>();
    Phone wt = null;
    try
    {
      getConnection();

      String selectWTQuery = "SELECT * FROM phone";
      PreparedStatement pst = conn.prepareStatement(selectWTQuery);
      ResultSet rs = pst.executeQuery();

      while(rs.next())
      {
        wt = new Phone(rs.getString("id"),rs.getString("name"),rs.getDouble("price"),rs.getString("image"),rs.getString("type"),rs.getString("cond"),rs.getDouble("discount"),rs.getInt("num"));
        wts.add(wt);
      }
    }
    catch(Exception e)
    {
        System.out.println("phone read error");
    }
    return wts;
  }

  public static ArrayList<Laptops> laptopChart()
  {
    ArrayList<Laptops> wts = new  ArrayList<Laptops>();
    Laptops wt = null;
    try
    {
      getConnection();

      String selectWTQuery = "SELECT * FROM laptops";
      PreparedStatement pst = conn.prepareStatement(selectWTQuery);
      ResultSet rs = pst.executeQuery();

      while(rs.next())
      {
        wt = new Laptops(rs.getString("id"),rs.getString("name"),rs.getDouble("price"),rs.getString("image"),rs.getString("type"),rs.getString("cond"),rs.getDouble("discount"),rs.getInt("num"));
        wts.add(wt);
      }
    }
    catch(Exception e)
    {
        System.out.println("phone read error");
    }
    return wts;
  }

  public static ArrayList<WearableTechnology> WtChart()
  {
    ArrayList<WearableTechnology> wts = new  ArrayList<WearableTechnology>();
    WearableTechnology wt = null;
    try
    {
      getConnection();

      String selectWTQuery = "SELECT * FROM wearabletechnology";
      PreparedStatement pst = conn.prepareStatement(selectWTQuery);
      ResultSet rs = pst.executeQuery();

      while(rs.next())
      {
        wt = new WearableTechnology(rs.getString("id"),rs.getString("name"),rs.getDouble("price"),rs.getString("image"),rs.getString("type"),rs.getString("cond"),rs.getDouble("discount"),"unknown",rs.getInt("num"));
        wts.add(wt);
      }
    }
    catch(Exception e)
    {
        System.out.println("phone read error");
    }
    return wts;
  }

  public static ArrayList<VoiceAssistant> VaChart()
  {
    ArrayList<VoiceAssistant> wts = new  ArrayList<VoiceAssistant>();
    VoiceAssistant wt = null;
    try
    {
      getConnection();

      String selectWTQuery = "SELECT * FROM voiceassistant";
      PreparedStatement pst = conn.prepareStatement(selectWTQuery);
      ResultSet rs = pst.executeQuery();

      while(rs.next())
      {
        wt = new VoiceAssistant(rs.getString("id"),rs.getString("name"),rs.getDouble("price"),rs.getString("image"),rs.getString("type"),rs.getString("cond"),rs.getDouble("discount"),rs.getInt("num"));
        wts.add(wt);
      }
    }
    catch(Exception e)
    {
        System.out.println("phone read error");
    }
    return wts;
  }

  public static ArrayList<SaleList> saleChart()
  {
    ArrayList<SaleList> hm = new ArrayList<SaleList>();
    try
    {
      getConnection();
      Statement stmt = conn.createStatement();
      String selectOrderQuery = "SELECT orderName,orderPrice,COUNT(*) AS total FROM customerorders GROUP BY orderName;";
      ResultSet rs = stmt.executeQuery(selectOrderQuery);
      while(rs.next())
      {
        SaleList orderList = new SaleList(rs.getString("orderName"),rs.getDouble("orderPrice"),rs.getInt("total"));
        hm.add(orderList);
      }
    }
    catch(Exception e)
    {
    }
    return hm;
  }

  public static HashMap<String,Phone > selectAllPhone()
  {
    HashMap<String,Phone> wts = new HashMap<String, Phone>();
    Phone wt = null;
    try
    {
      getConnection();

      String selectWTQuery = "SELECT * FROM phone";
      PreparedStatement pst = conn.prepareStatement(selectWTQuery);
      ResultSet rs = pst.executeQuery();

      while(rs.next())
      {
        wt = new Phone(rs.getString("id"),rs.getString("name"),rs.getDouble("price"),rs.getString("image"),rs.getString("type"),rs.getString("cond"),rs.getDouble("discount"),rs.getInt("num"));
        wts.put(rs.getString("id"),wt);
      }
    }
    catch(Exception e)
    {
        System.out.println("phone read error");
    }
    return wts;
  }
  public static HashMap<String,Laptops > selectAllLaptop()
  {
    HashMap<String,Laptops> wts = new HashMap<String, Laptops>();
    Laptops wt = null;
    try
    {
      getConnection();

      String selectWTQuery = "SELECT * FROM laptops";
      PreparedStatement pst = conn.prepareStatement(selectWTQuery);
      ResultSet rs = pst.executeQuery();

      while(rs.next())
      {
        wt = new Laptops(rs.getString("id"),rs.getString("name"),rs.getDouble("price"),rs.getString("image"),rs.getString("type"),rs.getString("cond"),rs.getDouble("discount"),rs.getInt("num"));
        wts.put(rs.getString("id"),wt);
      }
    }
    catch(Exception e)
    {
        System.out.println("Laptops read error");
    }
    return wts;
  }


  public static HashMap<String,VoiceAssistant > selectAllVa()
  {
    HashMap<String,VoiceAssistant> wts = new HashMap<String, VoiceAssistant>();
    VoiceAssistant wt = null;
    try
    {
      getConnection();

      String selectWTQuery = "SELECT * FROM VoiceAssistant";
      PreparedStatement pst = conn.prepareStatement(selectWTQuery);
      ResultSet rs = pst.executeQuery();

      while(rs.next())
      {
        wt = new VoiceAssistant(rs.getString("id"),rs.getString("name"),rs.getDouble("price"),rs.getString("image"),rs.getString("type"),rs.getString("cond"),rs.getDouble("discount"),rs.getInt("num"));
        wts.put(rs.getString("id"),wt);
      }
    }
    catch(Exception e)
    {
        System.out.println("VoiceAssistant read error");
    }
    return wts;
  }

  public static void Insertproducts()
{
	try{


		getConnection();


		String truncatetableprod = "delete from  wearabletechnology;";
		PreparedStatement psttprod = conn.prepareStatement(truncatetableprod);
		psttprod.executeUpdate();

    truncatetableprod = "delete from  phone;";
    psttprod = conn.prepareStatement(truncatetableprod);
    psttprod.executeUpdate();

    truncatetableprod = "delete from  laptops;";
    psttprod = conn.prepareStatement(truncatetableprod);
    psttprod.executeUpdate();

    truncatetableprod = "delete from  voiceassistant;";
    psttprod = conn.prepareStatement(truncatetableprod);
    psttprod.executeUpdate();


		String insertProductQurey = "INSERT INTO wearabletechnology (id,name,price,image,type,cond,discount,num)" +
		"VALUES (?,?,?,?,?,?,?,?);";
		for(Map.Entry<String,WearableTechnology> entry : SaxParserDataStore.wts.entrySet())
		{
	    WearableTechnology wt = entry.getValue();

			PreparedStatement pst = conn.prepareStatement(insertProductQurey);
			pst.setString(1,wt.getId());
			pst.setString(2,wt.getName());
			pst.setDouble(3,wt.getPrice());
			pst.setString(4,wt.getImage());
			pst.setString(5,wt.getType());
			pst.setString(6,wt.getCondition());
			pst.setDouble(7,wt.getDiscount());
      pst.setInt(8,wt.getNum());

			pst.executeUpdate();


		}
    String insertProductQurey2 = "INSERT INTO phone(id,name,price,image,type,cond,discount,num)" +
    "VALUES (?,?,?,?,?,?,?,?);";
		for(Map.Entry<String,Phone> entry : SaxParserDataStore.phones.entrySet())
		{
      Phone phone = entry.getValue();

			PreparedStatement pst = conn.prepareStatement(insertProductQurey2);
      pst.setString(1,phone.getId());
			pst.setString(2,phone.getName());
			pst.setDouble(3,phone.getPrice());
			pst.setString(4,phone.getImage());
			pst.setString(5,phone.getType());
			pst.setString(6,phone.getCondition());
			pst.setDouble(7,phone.getDiscount());
      pst.setInt(8,phone.getP_number());

			pst.executeUpdate();
		}
    String insertProductQurey3 = "INSERT INTO laptops(id,name,price,image,type,cond,discount,num)" +
    "VALUES (?,?,?,?,?,?,?,?);";
		for(Map.Entry<String,Laptops> entry : SaxParserDataStore.laptops.entrySet())
		{
      Laptops laptop = entry.getValue();

			PreparedStatement pst = conn.prepareStatement(insertProductQurey3);
      pst.setString(1,laptop.getId());
			pst.setString(2,laptop.getName());
			pst.setDouble(3,laptop.getPrice());
			pst.setString(4,laptop.getImage());
			pst.setString(5,laptop.getType());
			pst.setString(6,laptop.getCondition());
			pst.setDouble(7,laptop.getDiscount());
      pst.setInt(8,laptop.getNum());

			pst.executeUpdate();
		}

    String insertProductQurey4 = "INSERT INTO voiceassistant (id,name,price,image,type,cond,discount,num)" +
    "VALUES (?,?,?,?,?,?,?,?);";
		for(Map.Entry<String,VoiceAssistant> entry : SaxParserDataStore.vas.entrySet())
		{
      VoiceAssistant va = entry.getValue();

			PreparedStatement pst = conn.prepareStatement(insertProductQurey4);
      pst.setString(1,va.getId());
			pst.setString(2,va.getName());
			pst.setDouble(3,va.getPrice());
			pst.setString(4,va.getImage());
			pst.setString(5,va.getType());
			pst.setString(6,va.getCondition());
			pst.setDouble(7,va.getDiscount());
      pst.setInt(8,va.getNum());

			pst.executeUpdate();
		}

	}catch(Exception e)
	{
  		e.printStackTrace();
	}
}

public static void UpdateProduct(String id, String name, double price, String type, String cond, Double discount,int num)
{
  try
  {
    getConnection();
    String table_name = null;
    if(type.equals("Phone"))
    {
      table_name = "phone";
    }else if (type.equals("Laptops"))
    {
      table_name = "laptops";
    }else if (type.equals("VoiceAssistant"))
    {
      table_name = "voiceassistant";
    }else if (type.equals("FitnessWatches") || type.equals("SmartWatches") || type.equals("Headphones") || type.equals("PetTracker") || type.equals("VirtualReality"))
    {
      table_name = "wearabletechnology";
    }
    String insertOrderQuery = "UPDATE "+table_name+" SET name = ?, price = ?,type = ?,cond = ?,discount = ?,num = ? WHERE id = ?";
    PreparedStatement pst = conn. prepareStatement(insertOrderQuery);
    pst.setString(1,name);
    pst.setDouble(2,price);
    pst.setString(3,type);
    pst.setString(4,cond);
    pst.setDouble(5,discount);
    pst.setInt(6,num);
    pst.setString(7,id);
    pst.executeUpdate();
  }catch(Exception e)
  {
    e.printStackTrace();
  }
}

public static HashMap<String,ProductDetail> getData()
  {
    update_productDetail();
    HashMap<String,ProductDetail> hm=new HashMap<String,ProductDetail>();
    try
    {
      getConnection();
      Statement stmt=conn.createStatement();
      String selectWTQuery = "SELECT * FROM productdetail";
      PreparedStatement pst = conn.prepareStatement(selectWTQuery);
      ResultSet rs = pst.executeQuery();
      while(rs.next())
      {
        ProductDetail p = new ProductDetail(rs.getString("Id"),rs.getString("productName"),rs.getDouble("productPrice"),rs.getString("productImage"),rs.getString("ProductType"),rs.getString("productCondition"),rs.getDouble("ProductDiscount"),rs.getString("productManufacturer"),rs.getInt("num"));
        hm.put(rs.getString("productName"),p);
      }
    }
    catch(Exception e)
    {
    e.printStackTrace();  
    }
    return hm;      
  }

  public static void update_productDetail()
  {
    HashMap<String,WearableTechnology> wts = selectAllWt();
    HashMap<String,Laptops> ls = selectAllLaptop();
    HashMap<String,Phone> ps = selectAllPhone();
    HashMap<String,VoiceAssistant> vas = selectAllVa(); 
    try
    {
      getConnection();

      String deleteQuery = "delete from  productdetail;";
      PreparedStatement psttprod = conn.prepareStatement(deleteQuery);
      psttprod.executeUpdate();

      String insertQuery = "INSERT INTO productdetail (ProductType,Id,productName,productPrice,productImage,productManufacturer,productCondition,ProductDiscount,num)" +
    "VALUES (?,?,?,?,?,?,?,?,?)";


    for(Map.Entry<String,WearableTechnology> entry : wts.entrySet())
    {
      WearableTechnology wt = entry.getValue();

      PreparedStatement pst = conn.prepareStatement(insertQuery);
      pst.setString(1,wt.getType());
      pst.setString(2,wt.getId());
      pst.setString(3,wt.getName());
      pst.setDouble(4,wt.getPrice());
      pst.setString(5,wt.getImage());
      pst.setString(6,"smartportables");
      pst.setString(7,wt.getCondition());
      pst.setDouble(8,wt.getDiscount());
      pst.setInt(9,wt.getNum());
      pst.executeUpdate();
    }

      for(Map.Entry<String,Phone> entry : ps.entrySet())
    {
      Phone p = entry.getValue();

      PreparedStatement pst = conn.prepareStatement(insertQuery);
      pst.setString(1,p.getType());
      pst.setString(2,p.getId());
      pst.setString(3,p.getName());
      pst.setDouble(4,p.getPrice());
      pst.setString(5,p.getImage());
      pst.setString(6,"smartportables");
      pst.setString(7,p.getCondition());
      pst.setDouble(8,p.getDiscount());
      pst.setInt(9,p.getP_number());
      pst.executeUpdate();
    }

    for(Map.Entry<String,Laptops> entry : ls.entrySet())
    {
      Laptops laptop = entry.getValue();

      PreparedStatement pst = conn.prepareStatement(insertQuery);
      pst.setString(1,laptop.getType());
      pst.setString(2,laptop.getId());
      pst.setString(3,laptop.getName());
      pst.setDouble(4,laptop.getPrice());
      pst.setString(5,laptop.getImage());
      pst.setString(6,"smartportables");
      pst.setString(7,laptop.getCondition());
      pst.setDouble(8,laptop.getDiscount());
      pst.setInt(9,laptop.getNum());
      pst.executeUpdate();
    }

      for(Map.Entry<String,VoiceAssistant> entry : vas.entrySet())
    {
      VoiceAssistant va = entry.getValue();

      PreparedStatement pst = conn.prepareStatement(insertQuery);
      pst.setString(1,va.getType());
      pst.setString(2,va.getId());
      pst.setString(3,va.getName());
      pst.setDouble(4,va.getPrice());
      pst.setString(5,va.getImage());
      pst.setString(6,"smartportables");
      pst.setString(7,va.getCondition());
      pst.setDouble(8,va.getDiscount());
      pst.setInt(9,va.getNum());
      pst.executeUpdate();
    }




    }
    catch(Exception e)
    {
       e.printStackTrace();
    }
  }

}
