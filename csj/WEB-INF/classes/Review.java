import java.io.IOException;
import java.io.*;


/*
	Review class contains class variables username,productname,reviewtext,reviewdate,reviewrating

	Review class has a constructor with Arguments username,productname,reviewtext,reviewdate,reviewrating

	Review class contains getters and setters for username,productname,reviewtext,reviewdate,reviewrating
*/

public class Review implements Serializable{
	private String productName;
	private String userName;
	private String productType;
	private String productMaker;
	private String reviewRating;
	private String reviewDate;
	private String reviewText;
	private String retailerpin;
	private String price;
	private String retailercity;
	private String retailerState;
	private String productOnSale;
	private String retailerName;
	private String manufacturerRebate;
//	private String userId;
	private String userAge;
	private String userGender;
	private String userOccupation;


	public Review(String productName,String productType, String price, String retailerName,String retailerpin,String retailercity, String retailerState, String productOnSale,String productMaker,String manufacturerRebate,String userName,String userAge,String userGender,String userOccupation,String reviewRating,String reviewDate,String reviewtext)
	{
		this.productName = productName;
		this.productType = productType;
		this.price = price;
		this.retailerName = retailerName;
		this.retailerpin = retailerpin;
		this.retailercity = retailercity;
		this.retailerState = retailerState;
		this.productOnSale = productOnSale;
		this.productMaker = productMaker;
		this.manufacturerRebate = manufacturerRebate;
		this.userName = userName;
		this.userAge = userAge;
		this.userGender = userGender;
		this.userOccupation = userOccupation;
		this.reviewRating = reviewRating;
		this.reviewDate = reviewDate;
		this.reviewText = reviewtext;
	}
	public Review (String productName,String userName,String productType,String productMaker,String reviewRating,String reviewDate,String reviewText,String retailerpin,String price,String retailercity){
		this.productName=productName;
		this.userName=userName;
		this.productType=productType;
		this.productMaker=productMaker;
	 	this.reviewRating=reviewRating;
		this.reviewDate=reviewDate;
	 	this.reviewText=reviewText;
		this.retailerpin=retailerpin;
		this.price= price;
		this.retailercity= retailercity;
	}

	public Review(String productName, String retailerpin, String reviewRating, String reviewText) {
       this.productName = productName;
       this.retailerpin = retailerpin;
       this.reviewRating = reviewRating;
       this.reviewText = reviewText;
    }

	public String getProductName() {
		return productName;
	}
	public String getUserName() {
		return userName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductMaker() {
		return productMaker;
	}

	public void setProductMaker(String productMaker) {
		this.productMaker = productMaker;
	}

	public String getReviewRating() {
		return reviewRating;
	}

	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setReviewRating(String reviewRating) {
		this.reviewRating = reviewRating;
	}
	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

		public String getRetailerPin() {
		return retailerpin;
	}

	public void setRetailerPin(String retailerpin) {
		this.retailerpin = retailerpin;
	}
			public String getRetailerCity() {
		return retailercity;
	}

	public void setRetailerCity(String retailercity) {
		this.retailercity = retailercity;
	}

			public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


	public void setRetailerName (String retailerName)
	{
		this.retailerName = retailerName;
	}
	public String getRetailerName ()
	{
		return retailerName;
	}

	public void setRetailerState(String retailerState)
	{
		this.retailerState = retailerState;
	}
	public String getRetailerState()
	{
		return retailerState;
	}

	public void setManufacturerRebate(String manufacturerRebate)
	{
		this.manufacturerRebate = manufacturerRebate;
	}
	public String getManufacturerRebate()
	{
		return manufacturerRebate;
	}

	public void setProductOnSale(String productOnSale)
	{
		this.productOnSale = productOnSale;
	}
	public String getProductOnsale()
	{
		return productOnSale;
	}

	public void setUserAge(String userAge)
	{
		this.userAge = userAge;
	}
	public String getUserAge()
	{
		return userAge;
	}

	public void setUserGender(String userGender)
	{
		this.userGender = userGender;
	}
	public String getUserGender()
	{
		return userGender;
	}

	public void setUserOccupation(String userOccupation)
	{
		this.userOccupation = userOccupation;
	}
	public String getUserOccupation()
	{
		return userOccupation;
	}
}
