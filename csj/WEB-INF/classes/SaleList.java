import java.io.IOException;
import java.io.*;


public class SaleList implements Serializable{
  private String orderName;
  private double price;
  private int count;

    public SaleList(String orderName,double price, int count){
      this.orderName = orderName;
      this.price = price;
      this.count = count;
    }

  public void setOrderName(String orderName)
  {
    this.orderName = orderName;
  }

  public String getOrderName()
  {
    return this.orderName;
  }

  public void setCount(int count)
  {
    this.count = count;
  }
  public int getCount()
  {
    return this.count;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }
  public double getPrice()
  {
    return this.price;
  }


}
