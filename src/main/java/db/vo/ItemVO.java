package db.vo;

import java.sql.Date;

public class ItemVO {
	private int itemNumber;
	private String address;
	private String sellerID;
	private Date itemAddDate;
	private String sellerName;
	private int price;
	private int contractMonth;
	private int deposit;
	private int monthlyRentPrice;
	private int SQM;
	private int pricePerSQM;

	@Override
	public String toString() {
		return "itemNumber : " + itemNumber + "\taddress : " + address;
	}

	public int getContractMonth() {
		return contractMonth;
	}

	public void setContractMonth(int contractMonth) {
		this.contractMonth = contractMonth;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getMonthlyRentPrice() {
		return monthlyRentPrice;
	}

	public void setMonthlyRentPrice(int monthlyRentPrice) {
		this.monthlyRentPrice = monthlyRentPrice;
	}

	public int getSQM() {
		return SQM;
	}

	public void setSQM(int sQM) {
		SQM = sQM;
	}

	public int getPricePerSQM() {
		return pricePerSQM;
	}

	public void setPricePerSQM(int pricePerSQM) {
		this.pricePerSQM = pricePerSQM;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSellerID() {
		return sellerID;
	}

	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}

	public Date getItemAddDate() {
		return itemAddDate;
	}

	public void setItemAddDate(Date itemAddDate) {
		this.itemAddDate = itemAddDate;
	}
}
