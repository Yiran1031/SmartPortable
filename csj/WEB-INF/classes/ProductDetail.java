import java.util.*;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ProductDetail")
public class ProductDetail extends HttpServlet{
    private String id;
    private String name;
    private double price;
    private String image;
    private String type;
    private String condition;
    private double discount;
    private String manufacturer;
    private int num;
    HashMap<String,String> accessories;

    public ProductDetail(String id, String name, double price, String image, String type,String condition,double discount,String manufacturer,int num){
        this.id = id;
        this.name=name;
        this.price=price;
        this.image=image;
        this.type = type;
        this.condition=condition;
        this.discount = discount;
        this.manufacturer = manufacturer;
        this.accessories=new HashMap<String,String>();
        this.num = num;
    }

    public ProductDetail(String id, String name, double price, String image, String type,String condition,double discount,String manufacturer){
        this.id = id;
        this.name=name;
        this.price=price;
        this.image=image;
        this.type = type;
        this.condition=condition;
        this.discount = discount;
        this.manufacturer = manufacturer;
        this.accessories=new HashMap<String,String>();
        num = 99;
    }
    public ProductDetail(String id, String name, double price, String image, String type,String condition,double discount){
        this.id = id;
        this.name=name;
        this.price=price;
        this.image=image;
        this.type = type;
        this.condition=condition;
        this.discount = discount;
        this.accessories=new HashMap<String,String>();
    }

    HashMap<String,String> getAccessories() {
        return accessories;
    }
    public ProductDetail(){

    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public void setAccessories( HashMap<String,String> accessories) {
        this.accessories = accessories;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setNum(int num)
    {
      this.num = num;
    }

    public int getNum()
    {
      return num;
    }
    public String getRetailer()
    {
        return manufacturer;
    }
    public void setRetailer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }
}
