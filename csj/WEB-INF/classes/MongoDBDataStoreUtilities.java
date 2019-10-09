import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.AggregationOutput;
import com.mongodb.AggregationOptions;
import com.mongodb.Cursor;
import java.util.*;

public class MongoDBDataStoreUtilities
{
static DBCollection myReviews;
public static DBCollection getConnection()
{
MongoClient mongo;
mongo = new MongoClient("localhost", 27017);

DB db = mongo.getDB("CustomerReviews");
 myReviews= db.getCollection("myReviews");
return myReviews;
}


// public static String insertReview(String productname,String username,String producttype,String productmaker,String reviewrating,String reviewdate,String reviewtext,String retailerpin,String price,String retailercity)
// {
// 	try
// 		{
// 			getConnection();
// 			BasicDBObject doc = new BasicDBObject("title", "myReviews").
// 				append("userName", username).
// 				append("productName", productname).
// 				append("productType", producttype).
// 				append("productMaker", productmaker).
// 				append("reviewRating",Integer.parseInt(reviewrating)).
// 				append("reviewDate", reviewdate).
// 				append("reviewText", reviewtext).
// 				append("retailerpin", retailerpin).
// 				append("retailercity", retailercity).
// 				append("price",(int) Double.parseDouble(price));
// 			myReviews.insert(doc);
// 			return "Successfull";
// 		}
// 		catch(Exception e)
// 		{
// 		return "UnSuccessfull";
// 		}
//
// }

public static String insertReview(String productName,String productType, String price, String retailerName,String retailerpin,String retailercity, String retailerState, String productOnSale,String productMaker,String manufacturerRebate,String userName,String userAge,String userGender,String userOccupation,String reviewRating,String reviewDate,String reviewtext)
{
	try
		{
			getConnection();
      System.out.println(productName+productType+price);
			BasicDBObject doc = new BasicDBObject("title", "myReviews").
				append("productName", productName).
        append("productType", productType).
        append("price",(int) Double.parseDouble(price)).
        append("retailerName",retailerName).
        append("retailerpin", retailerpin).
        append("retailercity", retailercity).
        append("retailerState",retailerState).
        append("productOnSale",productOnSale).
        append("productMaker", productMaker).
        append("manufacturerRebate",manufacturerRebate).
        append("userName",userName).
        append("userAge",userAge).
        append("userGender",userGender).
        append("userOccupation",userOccupation).
        append("reviewRating",Integer.parseInt(reviewRating)).
        append("reviewDate",reviewDate).
        append("reviewText",reviewtext);
			myReviews.insert(doc);
			return "Successfull";
		}
		catch(Exception e)
		{
      e.printStackTrace();
		return "UnSuccessfull";
		}

}

public static HashMap<String, ArrayList<Review>> selectReview()
{
	HashMap<String, ArrayList<Review>> reviews=null;

	try
		{

      getConnection();
      DBCursor cursor = myReviews.find();
	    reviews=new HashMap<String, ArrayList<Review>>();
	while (cursor.hasNext())
	{
			BasicDBObject obj = (BasicDBObject) cursor.next();

		   if(!reviews.containsKey(obj.getString("productName")))
			{
				ArrayList<Review> arr = new ArrayList<Review>();
				reviews.put(obj.getString("productName"), arr);
			}
			ArrayList<Review> listReview = reviews.get(obj.getString("productName"));
			Review review =new Review(obj.getString("productName"),obj.getString("productType"),obj.getString("price"),obj.getString("retailerName"),obj.getString("retailerpin"),obj.getString("retailercity"),obj.getString("retailerState"),obj.getString("productOnSale"),obj.getString("productMaker"),obj.getString("manufacturerRebate"),obj.getString("userName"),obj.getString("userAge"),obj.getString("userGender"),obj.getString("userOccupation"),obj.getString("reviewRating"),obj.getString("reviewDate"),obj.getString("reviewText"));
			//add to review hashmap
			listReview.add(review);

			}
 		return reviews;
		}
		catch(Exception e)
		{
		 reviews=null;
		 return reviews;
		}


	}



  public static  ArrayList <Bestrating> topProducts(){
	  ArrayList <Bestrating> Bestrate = new ArrayList <Bestrating> ();
	  try{
		  System.out.println("top5");
	  getConnection();
	  int retlimit =5;
	  DBObject sort = new BasicDBObject();
	  sort.put("reviewRating",-1);
	  DBCursor cursor = myReviews.find().limit(retlimit).sort(sort);
	  while(cursor.hasNext()) {
		  BasicDBObject obj = (BasicDBObject) cursor.next();

		  String prodcutnm = obj.get("productName").toString();
		  String rating = obj.get("reviewRating").toString();
	      Bestrating best = new Bestrating(prodcutnm,rating);
		  Bestrate.add(best);
	  }

	}catch (Exception e){ System.out.println(e.getMessage());}
   return Bestrate;
  }

  public static ArrayList <Mostsoldzip> mostsoldZip(){
    ArrayList <Mostsoldzip> mostsoldzip = new ArrayList <Mostsoldzip> ();
    try{
      System.out.println("top5");
    getConnection();
      DBObject groupProducts = new BasicDBObject("_id","$retailerpin");
    groupProducts.put("count",new BasicDBObject("$sum",1));
    DBObject group = new BasicDBObject("$group",groupProducts);
    DBObject limit=new BasicDBObject();
      limit=new BasicDBObject("$limit",5);

    DBObject sortFields = new BasicDBObject("count",-1);
    DBObject sort = new BasicDBObject("$sort",sortFields);
    AggregationOutput output = myReviews.aggregate(group,sort,limit);
      for (DBObject res : output.results()) {
        System.out.println(res);
    String zipcode =(res.get("_id")).toString();
        String count = (res.get("count")).toString();
        Mostsoldzip mostsldzip = new Mostsoldzip(zipcode,count);
    mostsoldzip.add(mostsldzip);

    }



  }catch (Exception e){ System.out.println(e.getMessage());}
      return mostsoldzip;
}

public static ArrayList <Mostsold> mostsoldProducts(){
  ArrayList <Mostsold> mostsold = new ArrayList <Mostsold> ();
  try{
    System.out.println("top5product");

    getConnection();
    DBObject groupProducts = new BasicDBObject("_id","$productName");
  groupProducts.put("count",new BasicDBObject("$sum",1));
  DBObject group = new BasicDBObject("$group",groupProducts);
  DBObject limit=new BasicDBObject();
    limit=new BasicDBObject("$limit",5);

  DBObject sortFields = new BasicDBObject("count",-1);
  DBObject sort = new BasicDBObject("$sort",sortFields);
  AggregationOutput output = myReviews.aggregate(group,sort,limit);
  System.out.println("oun"+output);
    for (DBObject res : output.results()) {


      System.out.println("res"+res);
  String prodcutname =(res.get("_id")).toString();
      String count = (res.get("count")).toString();
      Mostsold mostsld = new Mostsold(prodcutname,count);
  mostsold.add(mostsld);

  }



}catch (Exception e){ System.out.println(e.getMessage());}
    return mostsold;

}
}
