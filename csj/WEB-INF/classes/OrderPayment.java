import java.io.IOException;
import java.io.*;
import java.util.*;


public class OrderPayment implements Serializable{
    private int orderId;
    private String userName;
    private String orderName;
    private double orderPrice;
    private String userAddress;
    private String creditCardNo;
    private Date date;

    public OrderPayment(int orderId,String userName,String orderName,double orderPrice,String userAddress,String creditCardNo,Date date){
        this.orderId=orderId;
        this.userName=userName;
        this.orderName=orderName;
        this.orderPrice=orderPrice;
        this.userAddress=userAddress;
        this.creditCardNo=creditCardNo;
        this.date = date;
    }

    public OrderPayment(int orderId,String userName,String orderName,double orderPrice,String userAddress,String creditCardNo){
        this.orderId=orderId;
        this.userName=userName;
        this.orderName=orderName;
        this.orderPrice=orderPrice;
        this.userAddress=userAddress;
        this.creditCardNo=creditCardNo;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public void setDate(Date date)
    {
      this.date = date;
    }

    public Date getDate()
    {
      return this.date;
    }

}
