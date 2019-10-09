import java.io.IOException;
import java.io.*;
import java.util.*;


public class DateSale implements Serializable{
  private String date;
  private int count;
  private double totalSale;

    public DateSale(String date,int count, double totalSale){
      this.date = date;
      this.count = count;
      this.totalSale = totalSale;
    }

  public void setDate(String date)
  {
    this.date = date;
  }

  public String getDate()
  {
    return this.date;
  }

  public void setCount(int count)
  {
    this.count = count;
  }
  public int getCount()
  {
    return this.count;
  }
  public void setTotalSale(double totalSale)
  {
    this.totalSale = totalSale;
  }
  public double getTotalSale()
  {
    return this.totalSale;
  }

}
